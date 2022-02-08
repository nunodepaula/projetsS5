/**
 * 
 */
package fr.ensma.a3.ia.JeuMemoire.Joueurs;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.JeuMemoire.Partie;
import fr.ensma.a3.ia.JeuMemoire.Plateau;
import fr.ensma.a3.ia.JeuMemoire.Cartes.ACarte;
import fr.ensma.a3.ia.JeuMemoire.Cartes.ICarte;
import fr.ensma.a3.ia.JeuMemoire.Cartes.Etat.TransitionNonTirableException;
import fr.ensma.a3.ia.JeuMemoire.Joueurs.automateJoueurs.EnAttente;
import fr.ensma.a3.ia.JeuMemoire.Joueurs.automateJoueurs.EnJeu;
import fr.ensma.a3.ia.JeuMemoire.Joueurs.automateJoueurs.IEtatJoueurs;
import fr.ensma.a3.ia.JeuMemoire.Joueurs.automateJoueurs.TransitionNonPermisException;

/**
 * @author alvaresn
 *
 */
public abstract class AJoueur{
	private Partie maPartie;
	private String nom;
	private String prenom;
	private String email;
	private String pseudo;
	protected List<ICarte> carteGagne;
	/*Etats*/
	private IEtatJoueurs EtatEnJeu=new EnJeu(this);
	private IEtatJoueurs EtatEnAttente=new EnAttente(this);
	private IEtatJoueurs EtatCourant;
	private Integer score;

	/**
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param pseudo
	 */
	public AJoueur(String nom, String prenom, String email, String pseudo,Partie maPartie) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.pseudo = pseudo;
		carteGagne=new ArrayList<ICarte>();
		this.maPartie=maPartie;
		EtatCourant=EtatEnAttente;
		score=0;
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
	
	public Integer getScore() {
		return score;
	}
	
	public void setScore(Integer nouveauscore) {
		this.score=nouveauscore;
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
	
	public void tirerCarte(Integer colonne1,Integer ligne1) {
		this.maPartie.getPlateau().getCartes().get(ligne1).get(colonne1).afficher();
	}
	/**
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public void resetCarteGagne() {
		carteGagne=new ArrayList<>();
	}
	
	public List<ICarte> getCarteGagne(){
		return carteGagne;
	}
	
	public void addCarteGagne(ICarte macarteGagne) {
		carteGagne.add(macarteGagne);
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
	
	
	public void aTontour() {
		try {
			EtatCourant.aTonTour();
			System.out.println("Joueur"+pseudo+"a ton tour");
		} catch (TransitionNonPermisException e) {
			System.out.println("Demande non accepte");
		}
	}
	public void enAttente() {
		try {
			EtatCourant.finTour();
		} catch (TransitionNonPermisException e) {
			System.out.println("Demande non accepte");
		}
	}
}
