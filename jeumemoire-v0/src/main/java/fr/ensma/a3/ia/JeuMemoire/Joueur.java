/**
 * 
 */
package fr.ensma.a3.ia.JeuMemoire;

/**
 * @author alvaresn
 *
 */
public class Joueur {

	private String nom;
	private String prenom;
	private String email;
	private String pseudo;
	
	/**
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param pseudo
	 */
	public Joueur(String nom, String prenom, String email, String pseudo) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.pseudo = pseudo;
	}

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
	
	public void tirerCarte(Integer ligne1, Integer colonne1, Integer ligne2, Integer colonne2) {
		
	}
}
