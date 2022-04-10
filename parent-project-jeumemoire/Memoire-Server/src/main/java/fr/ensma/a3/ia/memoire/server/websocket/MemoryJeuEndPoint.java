package fr.ensma.a3.ia.memoire.server.websocket;

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
import fr.ensma.a3.ia.dao.IEntityDAO;
import fr.ensma.a3.ia.dao.JoueurPartiePoiDAO;
import fr.ensma.a3.ia.dao.JoueurPoiDAO;
import fr.ensma.a3.ia.dao.entity.JoueurEntity;
import fr.ensma.a3.ia.dao.entity.JoueurPartieEntity;
import fr.ensma.a3.ia.memoire.server.rest.JoueurResource;

@ServerEndpoint(value = "/ws/memory/{identifiantetemail}", encoders = ClientMessageJeuEncode.class, decoders = ClientMessageJeuDecode.class)
public class MemoryJeuEndPoint {

	// Mapping entre l'identifiant de chaque partie et ses joueurs
	static Map<Integer, Set<Session>> dictionary = new HashMap<Integer, Set<Session>>();
	private static IEntityDAO<JoueurEntity> dbJoueur = new JoueurPoiDAO();
	private static IEntityDAO<JoueurPartieEntity> dbJp = new JoueurPartiePoiDAO();

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

		// Initialisation du score de chaque joueur
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

		// Vérification de la quantité des joueurs avant de commencer la partie
		if (dictionary.get(identifiant).size() == MemoryPartieEndPoint.getMesPartiesJeu().get(identifiant)
				.getNbJoueurs()) {
			// Si c'est le tour du joueur
			if (joueur.getEtatCourant() != joueur.getEtatEnAttente()) {
				valeur = partie.Action(joueur, message.getColonne(), message.getLigne());
				valeurc = valeur;
				ClientMessageJeuMemory monmess = new ClientMessageJeuMemory();
				monmess.setValeur(valeur);
				monmess.setColonne(message.getColonne());
				monmess.setLigne(message.getLigne());

				for (Session client : clients) {
					try {
						client.getBasicRemote().sendObject(monmess);

					} catch (IOException e) {
						// Auto-generated catch block
						e.printStackTrace();
					} catch (EncodeException e) {
						// Auto-generated catch block
						e.printStackTrace();
					}
				}

				// Effet des cartes Magiques
				if ((valeur.contains("Magique")) && (joueur.getEtatCourant() == joueur.getEtatEnAttente())) {
					monmess.setValeur("cacher");
					for (Session client : clients) {
						try {
							client.getBasicRemote().sendObject(monmess);

						} catch (IOException e) {
							// Auto-generated catch block
							e.printStackTrace();
						} catch (EncodeException e) {
							// Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

				// Second tour du joueur quand c'est le cas
				if (joueur.getEtatCourant() == joueur.getEtatSecondTirage()) {
					valeurc = valeur;
					valeur = partie.test(joueur);
					ClientMessageJeuMemory monmessage2 = new ClientMessageJeuMemory();
					monmessage2.setValeur(valeur);
					monmessage2.setEmailCreateur(joueur.getEmail());
					monmessage2.setScore(joueur.getScore());

					for (Session client : clients) {
						try {
							client.getBasicRemote().sendObject(monmessage2);

						} catch (IOException e) {
							// Auto-generated catch block
							e.printStackTrace();
						} catch (EncodeException e) {
							// Auto-generated catch block
							e.printStackTrace();
						}
					}
					partie.auJoueurSuivant(valeur);
					if (partie.finPartie()) {
						for (Session client : clients) {
							try {
								client.close();

							} catch (IOException e) {
								// Auto-generated catch block
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
				if (valeurc.compareTo("MagiqueDansTaFace") == 0) {
					System.out.println("notification dans ta face");
					List<Integer> carteaReafficher = partie.reaffichage(joueur);
					for (int i = 0; i < carteaReafficher.size() - 1; i = i + 2) {
						ClientMessageJeuMemory messageDansTaFace = new ClientMessageJeuMemory();
						Integer ligne = carteaReafficher.get(i);
						Integer colonne = carteaReafficher.get(i + 1);
						System.out.println(carteaReafficher.get(i));
						System.out.println(carteaReafficher.get(i + 1));
						messageDansTaFace.setColonne(colonne);
						messageDansTaFace.setLigne(ligne);
						messageDansTaFace.setValeur("danstaface");
						messageDansTaFace.setEmailCreateur(sess.getUserProperties().get("email").toString());
						messageDansTaFace.setScore(joueur.getScore());
						System.out.println("le score du joueur est " + joueur.getScore());
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
		} else {
			System.out.println("pas assez de joueurs dans la partie");
		}
	}

	@OnClose
	public void onClose(Session sess) {
		System.out.println(sess.getUserProperties().get("email") + " vient de se déconnecter ...");
		
		// Enregistrement du score du joueur dans la base
		AJoueur joueur = (AJoueur) sess.getUserProperties().get("joueur");
		
		JoueurEntity j = new JoueurEntity(joueur.getEmail());
		j = dbJoueur.getByValue(j).get();
		JoueurPartieEntity jp = new JoueurPartieEntity(
				Integer.parseInt((String) sess.getUserProperties().get("identifiant")),
				j.getIdJ(),
				joueur.getScore()
		);
		
		dbJp.create(jp);
	}

	@OnError
	public void onError(Session session, Throwable t) {
		t.printStackTrace();
	}
}
