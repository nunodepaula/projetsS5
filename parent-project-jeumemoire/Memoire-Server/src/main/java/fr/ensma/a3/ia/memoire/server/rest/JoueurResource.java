package fr.ensma.a3.ia.memoire.server.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import fr.ensma.a3.ia.JeuMemoire.Joueurs.JoueurPhysique;
import fr.ensma.a3.ia.memoire.api.joueur.JoueurBean;

@Path("creation")
public class JoueurResource {

	public static List<JoueurPhysique> joueurs = new ArrayList<JoueurPhysique>();
	private static List<String> emails=new ArrayList<String>();
	
	@POST
	@Path("/inscription")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response joueurRecord(String joueur) {
		Gson gson = new Gson();
		//HashMap<String,String> unjoueur = gson.fromJson(
		//	    joueur, new TypeToken<HashMap<String, Object>>() {}.getType()
		//);
		JoueurBean unjoueur = gson.fromJson(joueur, JoueurBean.class);
		
		//JoueurPhysique monjoueur = new JoueurPhysique(unjoueur.get("Nom"), unjoueur.get("Prenom"),
		//		unjoueur.get("Email"), unjoueur.get("Pseudo"), null);
		JoueurPhysique monjoueur = new JoueurPhysique(unjoueur.getNom(), unjoueur.getPrenom(), unjoueur.getEmail(),
				unjoueur.getPseudo(), null);
		joueurs.add(monjoueur);
		
		System.out.println("Joueur reçu : "+joueur);
		System.out.println(monjoueur.getNom());
		
		return Response.ok(monjoueur.getNom()).build();
	}
	@GET
	@Path("/connexion")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response joueurRecordEmail(@HeaderParam("email") String email) {
		emails.add(email);
		return Response.ok(email).build();
	}
}
