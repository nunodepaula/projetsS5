package fr.ensma.a3.ia.memoire.server.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("intro")
public class intro {

	@GET
	public Response introFunction() {
		return Response.ok("Bienvenue au Jeu Memoire").build();
	}

}
