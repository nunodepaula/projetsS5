package fr.ensma.a3.ia.rest;

import java.util.HashMap;

public class JoueurBean {

	private String nom;
	private String prenom;
	private String email;
	private String pseudo;
	
	public JoueurBean(HashMap<String, String> joueur) {
		this.nom = joueur.get("Nom");
		this.prenom = joueur.get("Prenom");
		this.email = joueur.get("Email");
		this.pseudo = joueur.get("Pseudo");
	}
	
	public void setNom(String unnom) {
		nom = unnom;
	}

	public void setPrenom(String unprenom) {
		prenom = unprenom;
	}

	public void setEmail(String unemail) {
		email = unemail;
	}

	public void setPseudo(String unpseudo) {
		pseudo = unpseudo;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getEmail() {
		return email;
	}

	public String getPseudo() {
		return pseudo;
	}

}
