/**
 * 
 */
package fr.ensma.a3.ia.JeuMemoire.Joueurs;

import fr.ensma.a3.ia.JeuMemoire.Joueurs.automateJoueurs.IEtatJoueurs;

/**
 * @author alvaresn
 *
 */
public abstract class AJoueur {

	private String nom;
	private String prenom;
	private String email;
	private String pseudo;
	
	/*Etats*/
	private IEtatJoueurs EtatEnJeu;
	private IEtatJoueurs EtatEnAttente;
	private IEtatJoueurs EtatCourant;

	/**
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param pseudo
	 */
	public AJoueur(String nom, String prenom, String email, String pseudo) {
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
	
	/*Fonctions Associées aux états*/
	public IEtatJoueurs getEtatCourant() {
		return EtatCourant;
	}

	public void setEtatCourant(IEtatJoueurs etatCourant) {
		EtatCourant = etatCourant;
	}

	public IEtatJoueurs getEtatEnJeu() {
		return EtatEnJeu;
	}

	public IEtatJoueurs getEtatEnAttente() {
		return EtatEnAttente;
	}
}
