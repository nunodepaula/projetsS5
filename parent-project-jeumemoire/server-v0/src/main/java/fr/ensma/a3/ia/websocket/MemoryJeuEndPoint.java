package fr.ensma.a3.ia.websocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import ClientMessageJeuMemory.ClientMessageJeuDecode;
import ClientMessageJeuMemory.ClientMessageJeuEncode;
import ClientMessageJeuMemory.ClientMessageJeuMemory;
import fr.ensma.a3.ia.JeuMemoire.Partie;
import fr.ensma.a3.ia.JeuMemoire.Joueurs.AJoueur;
import fr.ensma.a3.ia.rest.JoueurResource;

@ServerEndpoint(value = "/ws/memory/{identifiantetemail}", encoders = ClientMessageJeuEncode.class, decoders = ClientMessageJeuDecode.class)
public class MemoryJeuEndPoint {
	static Map<Integer, Set<Session>> dictionary = new HashMap<Integer, Set<Session>>();

	@OnOpen
	public void onOpen(@PathParam("identifiantetemail") String identifiantetemail, Session sess,
			EndpointConfig endpointConfig) {
		System.out.println(identifiantetemail + "identifiant de la partie: email du joueur");
		String[] params = identifiantetemail.split(":");
		sess.getUserProperties().put("email", params[1]);
		sess.getUserProperties().put("identifiant", params[0]);
		String email = params[1];
		Integer identifiant = Integer.valueOf(params[0]);
		if (dictionary.get(identifiant) != null) {
			dictionary.get(identifiant).add(sess);
		} else {
			Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
			clients.add(sess);
			dictionary.put(identifiant, clients);
		}
		for (AJoueur i : JoueurResource.joueurs) {
			if (email.compareTo(i.getEmail()) == 0) {
				sess.getUserProperties().put("joueur", i);
			}
		}
		Set<Session> clients = dictionary.get(identifiant);

		for (Session client0 : clients) {
			ClientMessageJeuMemory monmess = new ClientMessageJeuMemory();
			monmess.setEmailCreateur(client0.getUserProperties().get("email").toString());
			monmess.setScore(0);
			for (Session client : clients) {
				try {
					client.getBasicRemote().sendObject(monmess);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (EncodeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}

	// Réaction du serveur à la réception du serveur
	@OnMessage
	public void onMessage(Object mess, Session sess) {
		System.out.println(sess.getUserProperties().get("email").toString() + " vient d'envoyer un message");
		String valeur;
		String valeurc;
		Integer identifiant = Integer.valueOf(sess.getUserProperties().get("identifiant").toString());
		Set<Session> clients = dictionary.get(identifiant);
		AJoueur joueur = (AJoueur) sess.getUserProperties().get("joueur");
		Partie partie = MemoryPartieEndPoint.getMesPartiesJeu().get(identifiant);
		System.out.println(partie.getJoueurs().get(0).getEmail());
		ClientMessageJeuMemory message = (ClientMessageJeuMemory) mess;
		if (dictionary.get(identifiant).size() == MemoryPartieEndPoint.getMesPartiesJeu().get(identifiant)
				.getNbJoueurs()) {
			if (joueur.getEtatCourant() != joueur.getEtatEnAttente()) {
				valeur = partie.Action(joueur, message.getColonne(), message.getLigne());
				valeurc=valeur;
				ClientMessageJeuMemory monmess = new ClientMessageJeuMemory();
				monmess.setValeur(valeur);
				monmess.setColonne(message.getColonne());
				monmess.setLigne(message.getLigne());
				for (Session client : clients) {
					try {
						client.getBasicRemote().sendObject(monmess);

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (EncodeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				if((valeur.contains("Magique"))&&(joueur.getEtatCourant()==joueur.getEtatEnAttente())){
					monmess.setValeur("cacher");
					for (Session client : clients) {
						try {
							client.getBasicRemote().sendObject(monmess);

						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (EncodeException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
				if (joueur.getEtatCourant() == joueur.getEtatSecondTirage()) {
					valeurc=valeur;
					valeur = partie.test(joueur);
					ClientMessageJeuMemory monmessage2 = new ClientMessageJeuMemory();
					monmessage2.setValeur(valeur);
					monmessage2.setEmailCreateur(joueur.getEmail());
					monmessage2.setScore(joueur.getScore());
					for (Session client : clients) {
						try {
							client.getBasicRemote().sendObject(monmessage2);

						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (EncodeException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					partie.auJoueurSuivant(valeur);
					if (partie.finPartie()) {
						for (Session client : clients) {
							try {
								client.close();

							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
				if ((joueur.getEtatCourant() == joueur.getEtatPremierTirage()) && (valeur.compareTo("trouver") != 0)) {
					joueur.secondTirage();
				}
				if (valeurc.compareTo("MagiqueReveleTout") == 0) {
					for (int i = 0; i < partie.getPlateau().getnbLignes(); i++) {
						for (int j = 0; j < partie.getPlateau().getnbColonnes(); j++) {
							ClientMessageJeuMemory messageReveleTout = new ClientMessageJeuMemory();
							String valeurafficher;
							valeurafficher = partie.getCarteByLigneColonne(i, j);
							if (valeurafficher != null) {
								messageReveleTout.setLigne(i);
								messageReveleTout.setColonne(j);
								messageReveleTout.setEmailCreateur(sess.getUserProperties().get("email").toString());
								messageReveleTout.setScore(joueur.getScore());
								messageReveleTout.setValeur(valeurafficher);
								try {
									sess.getBasicRemote().sendObject(messageReveleTout);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (EncodeException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					}
					ClientMessageJeuMemory monmessReinit = new ClientMessageJeuMemory();
					monmessReinit.setValeur("cacher");
					for (Session client : clients) {
						try {
							client.getBasicRemote().sendObject(monmessReinit);

						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (EncodeException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
				if(valeurc.compareTo("MagiqueDansTaFace")==0) {
					System.out.println("notification dans ta face");
					List<Integer>carteaReafficher=partie.reaffichage(joueur);
					for(int i=0;i<carteaReafficher.size()-1;i=i+2) {
						ClientMessageJeuMemory messageDansTaFace=new ClientMessageJeuMemory();
						Integer ligne=carteaReafficher.get(i);
						Integer colonne=carteaReafficher.get(i+1);
						System.out.println(carteaReafficher.get(i));
						System.out.println(carteaReafficher.get(i+1));				
						messageDansTaFace.setColonne(colonne);
						messageDansTaFace.setLigne(ligne);
						messageDansTaFace.setValeur("danstaface");
						messageDansTaFace.setEmailCreateur(sess.getUserProperties().get("email").toString());
						messageDansTaFace.setScore(joueur.getScore());
						System.out.println("le score du joueur est "+joueur.getScore());
						for (Session client : clients) {
							try {
								client.getBasicRemote().sendObject(messageDansTaFace);
								
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (EncodeException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}						
					}
				}
			}
		} 
		}	
			else {
			System.out.println("pas assez de joueurs dans la partie");
		}
	
	}

	@OnClose
	public void onClose(Session sess) {
		System.out.println(sess.getUserProperties().get("email") + " vient de se déconnecter ...");
	}

	// clients.remove(sess);
	/*
	 * String canalId = sess.getUserProperties().get("canalId").toString();
	 * dictionary.get(canalId).remove(sess); Set<Session> clients =
	 * dictionary.get(canalId);
	 * 
	 * ClientMessage mess = new ClientMessage(); for (Session client : clients) {
	 * mess.setLePseudo("LeServer"); mess.setLeContenu((String)
	 * sess.getUserProperties().get("pseudo") + " nous a quitté ... (sniff)"); try {
	 * client.getBasicRemote().sendObject(mess); } catch (IOException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } catch (EncodeException e) {
	 * // TODO Auto-generated catch block e.printStackTrace(); } } }
	 */
	@OnError
	public void onError(Session session, Throwable t) {
		t.printStackTrace();
	}
}
