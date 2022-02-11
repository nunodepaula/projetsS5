package fr.ensma.a3.ia.Memoire.server;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.ensma.a3.ia.JeuMemoire.Joueurs.JoueurPhysique;




@Path("creation")
public class CreationJoueur {
	@POST
	@Path("/joueur")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postJoueurRecord(JoueurPhysique monJoueur) {
		JoueurPhysique cejoueur=new JoueurPhysique(monJoueur.getNom(),monJoueur.getPrenom(),monJoueur.getEmail(),monJoueur.getPseudo(),null);
		JoueurDB.getJoueurs().add(cejoueur);
		return Response.ok("plateau cree").build();
	}
}
