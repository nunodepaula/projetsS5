package fr.ensma.a3.ia.memoire.api.joueur;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;

public class JoueurBeanEncoder implements Encoder.Text<JoueurBean>{

	private static Gson gson = new Gson();
	
	@Override
	public void init(EndpointConfig config) {	
	}

	@Override
	public void destroy() {		
	}

	@Override
	public String encode(JoueurBean object) throws EncodeException {
		// Objet Json pour l'envoie
		return gson.toJson(object);
	}

}
