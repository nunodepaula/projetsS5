package fr.ensma.a3.ia.memoire.server.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

@ApplicationPath("/services")
public class MemoireServicesApp extends Application{
	@GET
	public Response introFunction() {
		return Response.ok("Bienvenue aux services du Jeu Memoire").build();
	}
}
