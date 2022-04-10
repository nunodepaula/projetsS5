package fr.ensma.a3.ia.memoire.server.websocket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.EndpointConfig;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import ClientMessagePartie.ClientMessagePartie;
import ClientMessagePartie.ClientMessagePartieDecode;
import ClientMessagePartie.ClientMessagePartieEncode;
import fr.ensma.a3.ia.JeuMemoire.Partie;
import fr.ensma.a3.ia.memoire.api.partie.PartieBean;

@ServerEndpoint(value = "/ws/allparties/{email}", encoders = ClientMessagePartieEncode.class, decoders = ClientMessagePartieDecode.class)
public class MemoryPartieEndPoint {

	// Map between users and their respective sessions
	private static Map<String, Session> map = new HashMap<String, Session>();
	// Parties Courrants
	private static List<PartieBean> mesPartiesAccueil = new ArrayList<PartieBean>();
	private static Map<Integer, Partie> mesPartiesJeu = new HashMap<Integer, Partie>();
	private static Map<String,Integer> createurIdentifiant=new HashMap<String,Integer>();
	
	/**
	 * On openning websocket connection, we map the logged user to its session id
	 * and save his email as a parameter of the session.
	 * 
	 * @param email (User identification)
	 * @param sess  (Session Object)
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
		ClientMessagePartie message = (ClientMessagePartie) mess;
		
		
	}
}
