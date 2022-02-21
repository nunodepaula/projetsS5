package ClientMessagePartie;


import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;


public class ClientMessagePartieDecode implements Decoder.Text<ClientMessagePartie>{
private static Gson gson = new Gson();
	
	@Override
	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public ClientMessagePartie decode(String mess) throws DecodeException {
		return gson.fromJson(mess, ClientMessagePartie.class);
	}

	@Override
	public boolean willDecode(String mess) {
		// TODO Auto-generated method stub
		return true;
	}
}