package fr.ensma.a3.ia.memoire.server.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import fr.ensma.a3.ia.memoire.server.websocket.MemoryPartieEndPoint;

@Path("/identifiant")
public class IdentifiantResource {
	@GET
	@Path("{email}")
	public Response getIdentifiantWithEmail(@PathParam("email") String email) {
		System.out.println("ton email" + email);
		return Response.ok(MemoryPartieEndPoint.getMapIdentifiantCreateur().get(email)).build();
	}
}