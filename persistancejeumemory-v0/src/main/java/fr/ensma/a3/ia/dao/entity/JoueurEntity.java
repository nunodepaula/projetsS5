/**
 * 
 */
package fr.ensma.a3.ia.dao.entity;

import java.util.Objects;

/**
 * @author alvaresn
 *
 */
public class JoueurEntity {

	private String nom;
	private String prenom;
	private String email;
	private String pseudo;
	
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	@Override
	public String toString() {
		return "JoueurEntity :" + nom.toUpperCase() + ", " + prenom + " - " + email + " - pseudo=" + pseudo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, nom, prenom, pseudo);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof JoueurEntity)) {
			return false;
		}
		JoueurEntity joueur = (JoueurEntity) obj;
		return Objects.equals(email, joueur.email) && Objects.equals(nom, joueur.nom)
				&& Objects.equals(prenom, joueur.prenom) && Objects.equals(pseudo, joueur.pseudo);
	}
	
	
}
