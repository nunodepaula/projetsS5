package fr.ensma.a3.ia.memoire.api.partie;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;

public class PartieBeanEncoder implements Encoder.Text<PartieBean> {

	private static Gson gson = new Gson();
	
	@Override
	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroy() {		
	}

	@Override
	public String encode(PartieBean object) throws EncodeException {
		// Objet Json pour l'envoie
		return gson.toJson(object);
	}

}
