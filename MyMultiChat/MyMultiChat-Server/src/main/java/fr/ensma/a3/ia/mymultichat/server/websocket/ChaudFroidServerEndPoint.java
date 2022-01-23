/**
 * 
 */
package fr.ensma.a3.ia.mymultichat.server.websocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
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

import fr.ensma.a3.ia.mymultichat.api.messages.client.ClientMessage;
import fr.ensma.a3.ia.mymultichat.api.messages.client.ClientMessageDecoder;
import fr.ensma.a3.ia.mymultichat.api.messages.client.ClientMessageEncoder;


/**
 * @author nunod
 *
 */
@ServerEndpoint(value = "/ws/chaudfroid/{canalandpseudo}", encoders = ClientMessageEncoder.class, decoders = ClientMessageDecoder.class)
public class ChaudFroidServerEndPoint {

	static Map<String, Set<Session>> dictionary = new HashMap<String, Set<Session>>();
	static Map<String, Queue<String>> tour = new HashMap<String, Queue<String>>();
	static Map<String, Integer> valeurs = new HashMap<String, Integer>();
	
	@OnOpen
	public void onOpen(@PathParam("canalandpseudo") String canalandpseudo, Session sess, EndpointConfig endpointConfig) {
		System.out.println("Nouveau joueur au chaud froid");
		System.out.println(sess.getId() + " vient de se connecter au canal " + canalandpseudo);
		String[] params = canalandpseudo.split(":");
		sess.getUserProperties().put("pseudo", params[1]);
		sess.getUserProperties().put("canalId", params[0]);
		
		String canalId = params[0];
		
		if (dictionary.get(canalId) != null) {
			dictionary.get(canalId).add(sess);
			
			Queue<String> q = tour.get(canalId);
			q.add(params[1]);
			tour.put(canalId, q);
		}
		else {
			Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
			clients.add(sess);
			dictionary.put(canalId, clients);
			
			Queue<String> q = new LinkedList<String>();
			q.add(params[1]);
			tour.put(canalId, q);
			
			Random rand = new Random();
			Integer valeur = rand.nextInt(100);
			valeurs.put(canalId, valeur);
		}
	}

	//Réaction du serveur à la réception du serveur
	@OnMessage
	public void onMessage(ClientMessage mess, Session sess) {
		String canalId = sess.getUserProperties().get("canalId").toString();
		String pseudo = sess.getUserProperties().get("pseudo").toString();
		
		Set<Session> clients = dictionary.get(canalId);
		Queue<String> queueTour = tour.get(canalId);
		String pseudoTour = queueTour.peek();
		Integer valeur = valeurs.get(canalId);
		
		ClientMessage messServer = new ClientMessage();
		messServer.setLePseudo("LeServer");
		if (pseudo == pseudoTour) {
			// Logique du jeu
			String contenu = mess.getLeContenu();
			
			Integer contenuValeur = Integer.valueOf(contenu);
			
			if (contenuValeur == valeur) {
				messServer.setLeContenu(pseudo + " a envoyé : " + contenu + " - Trouvé !!");
			} else if (contenuValeur > valeur) {
				messServer.setLeContenu(pseudo + " a envoyé : " + contenu + " - Trop grand");
			} else {
				messServer.setLeContenu(pseudo + " a envoyé : " + contenu + " - Trop petit");
			}
			
			for (Session client : clients) {
				try {
					client.getBasicRemote().sendObject(messServer);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (EncodeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			// Changer le tour
			queueTour.remove();
			queueTour.add(pseudoTour);
			String prochainJoueur = queueTour.peek();
			for (Session client : clients) {
				if (client.getUserProperties().get("pseudo").toString() == prochainJoueur) {
					messServer.setLeContenu("À ton tour !");
					try {
						client.getBasicRemote().sendObject(messServer);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (EncodeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} else {
			messServer.setLeContenu("Il faut attendre ton tour");
			try {
				sess.getBasicRemote().sendObject(messServer);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EncodeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@OnClose
	public void onClose(Session sess) {
		System.out.println(sess.getUserProperties().get("pseudo") + " vient de se déconnecter ...");
		//clients.remove(sess);
		
		String canalId = sess.getUserProperties().get("canalId").toString();
		String pseudo = sess.getUserProperties().get("pseudo").toString();
		dictionary.get(canalId).remove(sess);
		Set<Session> clients = dictionary.get(canalId);
		
		Queue<String> queueTour = tour.get(canalId);
		queueTour.remove(pseudo);
		tour.put(canalId, queueTour);
		
		ClientMessage mess = new ClientMessage();
		for (Session client : clients) {
			mess.setLePseudo("LeServer");
			mess.setLeContenu((String) sess.getUserProperties().get("pseudo") + " nous a quitté ... (sniff)");
			try {
				client.getBasicRemote().sendObject(mess);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EncodeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	  @OnError
	  public void onError(Session session, Throwable t) {
	    t.printStackTrace();
	  }
}
