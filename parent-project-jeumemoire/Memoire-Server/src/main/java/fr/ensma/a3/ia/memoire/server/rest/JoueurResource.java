package fr.ensma.a3.ia.memoire.server.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import fr.ensma.a3.ia.JeuMemoire.Joueurs.JoueurPhysique;
import fr.ensma.a3.ia.dao.IEntityDAO;
import fr.ensma.a3.ia.dao.JoueurPoiDAO;
import fr.ensma.a3.ia.dao.entity.JoueurEntity;
import fr.ensma.a3.ia.memoire.api.joueur.JoueurBean;

@Path("creation")
public class JoueurResource {

	public static List<JoueurPhysique> joueurs = new ArrayList<JoueurPhysique>();
	private static List<String> emails=new ArrayList<String>();
	
	private static IEntityDAO<JoueurEntity> joueurDB = new JoueurPoiDAO();
	
	@POST
	@Path("/inscriptionmap")
	public Response joueurRecordMap(String joueur) {
		Gson gson = new Gson();
		
		HashMap<String,String> unjoueur = gson.fromJson(
			    joueur, new TypeToken<HashMap<String, Object>>() {}.getType()
		);
		
		JoueurPhysique monjoueur = new JoueurPhysique(unjoueur.get("Nom"), unjoueur.get("Prenom"),
				unjoueur.get("Email"), unjoueur.get("Pseudo"), null);
		
		JoueurEntity j = new JoueurEntity(monjoueur.getEmail());
		
		System.out.println(monjoueur.getEmail());
		String email = j.getEmail();
		System.out.println("Current mails :");
		List<JoueurEntity> js = joueurDB.getAll();
		for (JoueurEntity je : js) {
			System.out.println(je.getEmail());
			if(je.getEmail().compareTo(email)==0) {
				System.out.println("  --Le Même--");
			}else {
				System.out.println("  --Pas celui");
			}
		}
		System.out.println("---------------");
		
		if (joueurDB.getByValue(j).isEmpty()) {
			joueurs.add(monjoueur);
			
			j.setNom(monjoueur.getNom());
			j.setPrenom(monjoueur.getPrenom());
			j.setPseudo(monjoueur.getPseudo());
			
			joueurDB.create(j);
			
			System.out.println("Nouveau Joueur :");
			System.out.println("    Nom        :" + unjoueur.get("Nom"));
			System.out.println("    Prénom     :" + unjoueur.get("Prenom"));
			System.out.println("    Email      :" + unjoueur.get("Email"));
			System.out.println("    Pseudo     :" + unjoueur.get("Pseudo"));
			
			return Response.ok(monjoueur.getNom()).build();
		}
		
		return Response.status(409).build();
	}
	
	@POST
	@Path("/inscription")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response joueurRecord(JoueurBean unjoueur) {
		JoueurPhysique monjoueur = new JoueurPhysique(unjoueur.getNom(), unjoueur.getPrenom(), unjoueur.getEmail(),
				unjoueur.getPseudo(), null);
		joueurs.add(monjoueur);
		
		System.out.println("Nouveau Joueur :");
		System.out.println("    Nom        :" + unjoueur.getNom());
		System.out.println("    Prénom     :" + unjoueur.getPrenom());
		System.out.println("    Email      :" + unjoueur.getEmail());
		System.out.println("    Pseudo     :" + unjoueur.getPseudo());
		
		return Response.ok(monjoueur.getNom()).header("Access-Control-Allow-Origin", "*").build();
	}
	@GET
	@Path("/connexion")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response joueurRecordEmail(@HeaderParam("email") String email) {
		emails.add(email);
		return Response.ok(email).build();
	}
}