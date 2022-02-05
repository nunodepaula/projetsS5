package fr.ensma.a3.ia.mymultichat.server.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.ensma.a3.ia.mymultichat.api.canal.ChatCanalDesc;
import fr.ensma.a3.ia.mymultichat.server.business.ChatCanalAdmin;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("canaux-disponibles")
public class CanauxDisponibles {

	@GET
	public Response getTousCanaux() {
		List<ChatCanalDesc> listcan = ChatCanalAdmin.getAllCanal();
		List<String> canaux = new ArrayList<String>();

		for (ChatCanalDesc canal : listcan) {
			canaux.add(canal.toString());
		}

		try {
			return Response.ok(canaux).header("Access-Control-Allow-Origin", "*").build();
		} catch (IndexOutOfBoundsException ex) {
			return Response.noContent().build();
		}
	}

}
