package fr.ensma.a3.ia.rest;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import fr.ensma.a3.ia.websocket.MemoryPartieEndPoint;

@Path("identifiant")
public class IdentifiantResource {	
	@GET
	public Response getIdentifiantWithEmail(@HeaderParam("email") String email) {
        return Response.ok(MemoryPartieEndPoint.getMapIdentifiantCreateur().get(email)).build();
}
}