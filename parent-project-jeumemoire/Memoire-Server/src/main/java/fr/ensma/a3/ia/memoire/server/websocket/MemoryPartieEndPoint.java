package fr.ensma.a3.ia.memoire.server.websocket;

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
import fr.ensma.a3.ia.dao.IEntityDAO;
import fr.ensma.a3.ia.dao.JoueurPoiDAO;
import fr.ensma.a3.ia.dao.PartiePoiDAO;
import fr.ensma.a3.ia.dao.entity.JoueurEntity;
import fr.ensma.a3.ia.dao.entity.PartieEntity;
import fr.ensma.a3.ia.memoire.api.partie.PartieBean;
import fr.ensma.a3.ia.memoire.server.rest.JoueurResource;

@ServerEndpoint(value = "/ws/allparties/{email}", encoders = ClientMessagePartieEncode.class, decoders = ClientMessagePartieDecode.class)
public class MemoryPartieEndPoint {

	// Map between users and their respective sessions
	private static Map<String, Session> map = new HashMap<String, Session>();
	// Parties Courrants
	private static List<PartieBean> mesPartiesAccueil = new ArrayList<PartieBean>();
	private static Map<Integer, Partie> mesPartiesJeu = new HashMap<Integer, Partie>();
	private static Map<String, Integer> createurIdentifiant = new HashMap<String, Integer>();

	// Objets pour la base de données
	private static IEntityDAO<JoueurEntity> dbJoueur = new JoueurPoiDAO();
	private static IEntityDAO<PartieEntity> dbPartie = new PartiePoiDAO();
	//private static IEntityDAO<JoueurPartieEntity> dbJp = new JoueurPartiePoiDAO();

	/**
	 * On openning websocket connection, we map the logged user to its session id
	 * and save his email as a parameter of the session.
	 * 
	 * @param email          (User identification)
	 * @param sess           (Session Object)
	 * @param endpointConfig
	 */
	@OnOpen
	public void onOpen(@PathParam("email") String email, Session sess, EndpointConfig endpointConfig) {
		System.out.println(sess.getId() + " recherche une partie " + email);
		sess.getUserProperties().put("email", email);
		map.put(email, sess);
	}

	@OnMessage
	public void onMessage(Object mess, Session sess) {
		// Identidication du joueur et de sa message
		String email = sess.getUserProperties().get("email").toString();
		JoueurEntity joueur = new JoueurEntity(email);
		joueur = dbJoueur.getByValue(joueur).get();
		ClientMessagePartie message = (ClientMessagePartie) mess;

		// Réaction du serveur lorsque l'utilisateur crée une nouvelle partie
		if (mesPartiesJeu.get(message.getId()) == null) {
			System.out.println("creation d'une partie par le joueur : " + joueur.getNom());

			// Creation d'une partie à partir de données reçues
			int id = dbPartie.lastId();
			PartieEntity pEntity = new PartieEntity(id, message.getLongueurPlateau(), message.getMode());
			dbPartie.create(pEntity);
			message.setId(id);
			createurIdentifiant.put(email, joueur.getIdJ());
			PartieBean partie = new PartieBean(message.getNomCreateur(), message.getLongueurPlateau(),
					message.getNbPaires(), message.getMode(), message.getNbJoueurs(), id);
			// Ajout de la nouvelle partie aux parties courrantes
			mesPartiesAccueil.add(partie);
			Partie vpartie = new Partie(new Plateau(message.getLongueurPlateau(), message.getLongueurPlateau()),
					message.getNbJoueurs(), message.getMode());
			mesPartiesJeu.put(id, vpartie);

			//Envoie des données concernant la partie aux autres utilisateurs
			for (String key : map.keySet()) {
				System.out.println(sess.getId().equals(map.get(key).getId()));
				if (!sess.getId().equals(map.get(key).getId())) {
					System.out.println(mess.toString());
					try {
						map.get(key).getBasicRemote().sendObject(message);
					} catch (IOException e) {
						// Auto-generated catch block
						e.printStackTrace();
					} catch (EncodeException e) {
						// Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			// Ajout du joueur dans la partie
			for (int i = 0; i < JoueurResource.joueurs.size(); i++) {
				if (JoueurResource.joueurs.get(i).getEmail().compareTo(email) == 0) {
					System.out.println("ajout du joueur " + email + "dans la partie" + message.getId());
					try {
						vpartie.ajouterJoueur(JoueurResource.joueurs.get(i));
					} catch (PartiePleineException e) {
						// Auto-generated catch block
						e.printStackTrace();
					}
					try {
						vpartie.initPartie();
					} catch (PartieVideException e) {
						// Auto-generated catch block
						e.printStackTrace();
					}
					mesPartiesJeu.put(id, vpartie);
				}
			}
			
			
		}else { //Ajout d'un joueur qui rejoint une partie par son identifiant
			System.out.println("ajout de " + email + "dans la partie " + message.getId());
			
			// On cherche l'instance du joueur et l'ajoute à la partie
			for (int i = 0; i < JoueurResource.joueurs.size(); i++) {
				if (JoueurResource.joueurs.get(i).getEmail().compareTo(email) == 0) {
					try {
						mesPartiesJeu.get(message.getId()).ajouterJoueur(JoueurResource.joueurs.get(i));
					} catch (PartiePleineException e) {
						// Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			//Test si la partie est complète on supprime la partie de l'affichage
			if (mesPartiesJeu.get(message.getId()).getJoueurs().size() == message.getNbJoueurs()) {
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
						// Auto-generated catch block
						e.printStackTrace();
					} catch (EncodeException e) {
						// Auto-generated catch block
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
		
		// TODO Add data to JoueurPartie Database
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
