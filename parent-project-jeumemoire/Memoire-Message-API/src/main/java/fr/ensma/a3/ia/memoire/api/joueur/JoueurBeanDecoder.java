package fr.ensma.a3.ia.memoire.api.joueur;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;

public class JoueurBeanDecoder implements Decoder.Text<JoueurBean> {

	private static Gson gson = new Gson();
	
	@Override
	public void init(EndpointConfig config) {
	}

	@Override
	public void destroy() {
	}

	@Override
	public JoueurBean decode(String s) throws DecodeException {
		// TODO Auto-generated method stub
		return gson.fromJson(s, JoueurBean.class);
	}

	@Override
	public boolean willDecode(String s) {
		// TODO Auto-generated method stub
		return false;
	}

}
