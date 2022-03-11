package ClientMessageJeuMemory;


import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;


public class ClientMessageJeuDecode implements Decoder.Text<ClientMessageJeuMemory>{
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
	public ClientMessageJeuMemory decode(String mess) throws DecodeException {
		return gson.fromJson(mess, ClientMessageJeuMemory.class);
	}

	@Override
	public boolean willDecode(String mess) {
		// TODO Auto-generated method stub
		return true;
	}
}