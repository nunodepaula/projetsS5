package fr.ensma.a3.ia.memoire.api.partie;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;

public class PartieBeanDecoder implements Decoder.Text<PartieBean> {

	private static Gson gson = new Gson();
	
	@Override
	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {		
	}

	@Override
	public PartieBean decode(String s) throws DecodeException {
		return gson.fromJson(s, PartieBean.class);
	}

	@Override
	public boolean willDecode(String s) {
		return false;
	}

	
}
