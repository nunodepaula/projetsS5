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
		
		System.out.println("Avant if");
		if (joueurDB.getByValue(j).isEmpty()) {
			System.out.println("Avant l'ajout du joueur à la liste");
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
		
		JoueurEntity j = new JoueurEntity(monjoueur.getEmail());
		
		System.out.println(monjoueur.getEmail());
		
		if (joueurDB.getByValue(j).isEmpty()) {
			joueurs.add(monjoueur);
			
			j.setNom(monjoueur.getNom());
			j.setPrenom(monjoueur.getPrenom());
			j.setPseudo(monjoueur.getPseudo());
			
			joueurDB.create(j);
			
			System.out.println("Nouveau Joueur :");
			System.out.println("    Nom        :" + unjoueur.getNom());
			System.out.println("    Prénom     :" + unjoueur.getPrenom());
			System.out.println("    Email      :" + unjoueur.getEmail());
			System.out.println("    Pseudo     :" + unjoueur.getPseudo());
			
			return Response.ok(monjoueur.getNom()).build();
		}
		
		return Response.status(409).build();
	}
	@GET
	@Path("/connexion")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response joueurRecordEmail(@HeaderParam("email") String email) {
		JoueurEntity j = new JoueurEntity(email);
		
		if (joueurDB.getByValue(j).isEmpty()) {
			return Response.status(404).build();
		}
		
		JoueurEntity unjoueur = joueurDB.getByValue(j).get();
		
		JoueurPhysique monjoueur = new JoueurPhysique(unjoueur.getNom(), unjoueur.getPrenom(), unjoueur.getEmail(),
				unjoueur.getPseudo(), null);
		
		joueurs.add(monjoueur);
		emails.add(email);
		
		JoueurBean jb = new JoueurBean();
		jb.setNom(monjoueur.getNom());
		jb.setPrenom(monjoueur.getPrenom());
		jb.setEmail(monjoueur.getEmail());
		jb.setPseudo(monjoueur.getPseudo());
		
		String jbStr = new Gson().toJson(jb);
		
		System.out.println("Joueur JSON : ");
		System.out.println(jbStr);
		
		return Response.ok(email).build();
	}
}