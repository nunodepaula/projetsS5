package fr.ensma.a3.ia.dao.entity;

public class JoueurEntity {
	private int idJ;
	private String email;
	private String nom;
	private String prenom;
	private String pseudo;
	
	public JoueurEntity() {	
	}
	
	public JoueurEntity(String email) {
		this.email = email;
	}
	
	public Integer getIdJ() {
		return idJ;
	}
	public void setIdJ(Integer unId) {
		idJ=unId;
	}
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String unemail) {
		email=unemail;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String unNom) {
		nom=unNom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String unPrenom) {
		prenom=unPrenom;
	}
	
	public String getPseudo() {
		return pseudo;
	}
	
	public void setPseudo(String unPseudo) {
		pseudo=unPseudo;
	}
}
