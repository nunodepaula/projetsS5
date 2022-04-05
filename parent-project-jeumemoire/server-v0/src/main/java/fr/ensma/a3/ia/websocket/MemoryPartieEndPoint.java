package fr.ensma.a3.ia.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import ClientMessagePartie.ClientMessagePartie;
import ClientMessagePartie.ClientMessagePartieDecode;
import ClientMessagePartie.ClientMessagePartieEncode;
import fr.ensma.a3.ia.JeuMemoire.Partie;
import fr.ensma.a3.ia.JeuMemoire.PartiePleineException;
import fr.ensma.a3.ia.JeuMemoire.PartieVideException;
import fr.ensma.a3.ia.JeuMemoire.Plateau;
import fr.ensma.a3.ia.rest.JoueurResource;
import fr.ensma.a3.ia.rest.PartieBean;

@ServerEndpoint(value = "/ws/allparties/{email}", encoders = ClientMessagePartieEncode.class, decoders = ClientMessagePartieDecode.class)
public class MemoryPartieEndPoint {
	private static Integer id = 0;
	private static Map<String, Session> map = new HashMap<String, Session>();
	private static List<PartieBean> mesPartiesAccueil = new ArrayList<PartieBean>();
	private static Map<Integer, Partie> mesPartiesJeu = new HashMap<Integer, Partie>();
	private static Map<String,Integer> createurIdentifiant=new HashMap<String,Integer>();

	@OnOpen
	public void onOpen(@PathParam("email") String email, Session sess, EndpointConfig endpointConfig) {
		System.out.println(sess.getId() + " recherche une partie " + email);
		sess.getUserProperties().put("email", email);
		map.put(email, sess);

	}

	// Réaction du serveur à la réception du message
	@OnMessage
	public void onMessage(Object mess, Session sess) {
		String email = sess.getUserProperties().get("email").toString();
		ClientMessagePartie message = (ClientMessagePartie) mess;
		//Réaction du serveur lorsque l'utilisateur crée une nouvelle partie
		if (mesPartiesJeu.get(message.getId()) == null) {
			System.out.println("creation d'une partie par un joueur");
			id = id + 1;
			message.setId(id);
			createurIdentifiant.put(email, id);
			System.out.println(message.getNomCreateur());
			//Envoie des données concernant la partie aux autres utilisateurs
			for (String key : map.keySet()) {
				System.out.println(sess.getId().equals(map.get(key).getId()));
				if (!sess.getId().equals(map.get(key).getId())) {
					System.out.println(mess.toString());
					try {
						map.get(key).getBasicRemote().sendObject(message);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (EncodeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
			//Creation d'une partie à partir des données reçues
			PartieBean partie = new PartieBean(message.getNomCreateur(), message.getLongueurPlateau(),
					message.getNbPaires(), message.getMode(), message.getNbJoueurs(), id);
			mesPartiesAccueil.add(partie);
			Partie vpartie = new Partie(new Plateau(message.getLongueurPlateau(), message.getLongueurPlateau()), message.getNbJoueurs(),message.getMode());
			mesPartiesJeu.put(id, vpartie);
			//Ajout du joueur dans la partie
			for (int i = 0; i < JoueurResource.joueurs.size(); i++) {
				if (JoueurResource.joueurs.get(i).getEmail().compareTo(email) == 0) {
					System.out.println("ajout du joueur "+email+"dans la partie"+message.getId());
					try {
						vpartie.ajouterJoueur(JoueurResource.joueurs.get(i));
					} catch (PartiePleineException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						vpartie.initPartie();
					} catch (PartieVideException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					mesPartiesJeu.put(id, vpartie);
				}
			}
		}
		//Ajout d'un joueur qui rejoint une partie par son identifiant
		else {
			System.out.println("ajout de " + email + "dans la partie " + message.getId());
			for (int i = 0; i < JoueurResource.joueurs.size(); i++) {
				if (JoueurResource.joueurs.get(i).getEmail().compareTo(email) == 0) {
					try {
						mesPartiesJeu.get(message.getId()).ajouterJoueur(JoueurResource.joueurs.get(i));
					} catch (PartiePleineException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			//Test si la partie est complète on supprime la partie de l'affichage
			if (mesPartiesJeu.get(id).getJoueurs().size() == message.getNbJoueurs()) {
				System.out.println("suppression de la partie");
				for (int j = 0; j < mesPartiesAccueil.size(); j++) {
					if (mesPartiesAccueil.get(j).getIdentifiant() == message.getId()) {
						mesPartiesAccueil.remove(j);
					}

				}
				for (String key : map.keySet()) {
					try {
						map.get(key).getBasicRemote().sendObject(message);
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

	@OnClose
	public void onClose(Session sess) {
		System.out.println(sess.getUserProperties().get("email") + " vient de se déconnecter ...");
		String email = sess.getUserProperties().get("email").toString();
		map.remove(email);
	}

	@OnError
	public void onError(Session session, Throwable t) {
		t.printStackTrace();
	}

	public static List<PartieBean> getMesParties() {
		return mesPartiesAccueil;
	}
	
	public static Map<Integer, Partie> getMesPartiesJeu(){
		return mesPartiesJeu;
	}
	public static Map<String,Integer> getMapIdentifiantCreateur(){
		return createurIdentifiant;
	}
}
