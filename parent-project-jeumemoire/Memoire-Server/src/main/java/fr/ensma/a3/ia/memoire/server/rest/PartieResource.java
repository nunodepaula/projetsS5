package fr.ensma.a3.ia.memoire.server.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.ensma.a3.ia.memoire.api.partie.PartieBean;
import fr.ensma.a3.ia.memoire.server.websocket.MemoryPartieEndPoint;

@Path("allparties")
@Produces(MediaType.APPLICATION_JSON)
public class PartieResource {

	
	@GET
	public List<PartieBean> getPartie() {
		return MemoryPartieEndPoint.getMesParties();
		
	}
}