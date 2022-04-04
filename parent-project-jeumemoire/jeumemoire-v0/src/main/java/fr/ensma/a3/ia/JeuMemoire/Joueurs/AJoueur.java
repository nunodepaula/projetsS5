/**
 * 
 */
package fr.ensma.a3.ia.JeuMemoire.Joueurs;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fr.ensma.a3.ia.JeuMemoire.Partie;
import fr.ensma.a3.ia.JeuMemoire.Plateau;
import fr.ensma.a3.ia.JeuMemoire.Cartes.ACarte;
import fr.ensma.a3.ia.JeuMemoire.Cartes.ICarte;
import fr.ensma.a3.ia.JeuMemoire.Cartes.Etat.TransitionNonTirableException;
import fr.ensma.a3.ia.JeuMemoire.Joueurs.automateJoueurs.EnAttente;
import fr.ensma.a3.ia.JeuMemoire.Joueurs.automateJoueurs.PremierTirage;
import fr.ensma.a3.ia.JeuMemoire.Joueurs.automateJoueurs.SecondTirage;
import fr.ensma.a3.ia.JeuMemoire.Joueurs.automateJoueurs.IEtatJoueurs;
import fr.ensma.a3.ia.JeuMemoire.Joueurs.automateJoueurs.TransitionNonPermisException;

/**
 * @author alvaresn
 *Définition d'un joueur
 */

public abstract class AJoueur{
	private String nom;
	private String prenom;
	private String email;
	private String pseudo;
	private Partie maPartie;
	protected List<ICarte> carteGagne;
	/*Etats*/
	private IEtatJoueurs EtatPremierTirage=new PremierTirage(this);
	private IEtatJoueurs EtatEnAttente=new EnAttente(this);
	private IEtatJoueurs EtatSecondTirage=new SecondTirage(this);
	private IEtatJoueurs EtatCourant;
	private Integer score;

	/**
	 * Obtient l'instance d'un joueur
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param pseudo
	 */
	public AJoueur(String nom, String prenom, String email, String pseudo,Partie maPartie) {
		super();
		this.nom = Objects.requireNonNull(nom);
		this.prenom = Objects.requireNonNull(prenom);
		this.email = Objects.requireNonNull(email);
		this.pseudo = Objects.requireNonNull(pseudo);
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
	/**
	 * 
	 * @return le score
	 */
	public Integer getScore() {
		return score;
	}
	/**
	 * 
	 * @param nouveauscore
	 */
	public void setScore(Integer nouveauscore) {
		this.score=nouveauscore;
	}

	/**
	 * @return le prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom le prénom à changer
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return l'email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 
	 * @return la partie
	 */
	public Partie getPartie() {
		return maPartie;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPartie(Partie nouvelPartie) {
		this.maPartie=nouvelPartie;
	}
	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}
	/**
	 * Représente le tirage d'une carte par sa ligne et sa colonne
	 * @param colonne1
	 * @param ligne1
	 * @return
	 */
	public ICarte tirerCarte(Integer colonne1,Integer ligne1) {
		this.maPartie.getPlateau().getCartes().get(ligne1).get(colonne1).afficher();
		return maPartie.getPlateau().getCartes().get(ligne1).get(colonne1);
	}
	/**
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	/**
	 * Remise à zéro des cartes gagnées
	 */
	public void resetCarteGagne() {
		carteGagne=new ArrayList<ICarte>();
	}
	/**
	 * 
	 * @return les cartes gagnées
	 */
	public List<ICarte> getCarteGagne(){
		return carteGagne;
	}
	/**
	 * ajout d'une nouvelle carte gagnée
	 * @param macarteGagne
	 */
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

	public IEtatJoueurs getEtatPremierTirage() {
		return EtatPremierTirage;
	}

	public IEtatJoueurs getEtatEnAttente() {
		return EtatEnAttente;
	}
	
	public IEtatJoueurs getEtatSecondTirage() {
		return EtatSecondTirage;
	}
	

	
	public void secondTirage() {
		try {
			EtatCourant.secondTour();
			System.out.println("Joueur"+pseudo+"second tirage");
		} catch(TransitionNonPermisException e) {
			System.out.println("Demon non accepte");
			}
	}
	
	public void aTontour() {
		try {
			EtatCourant.aTonTour();
			System.out.println("Joueur"+pseudo+"premier tirage");
		} catch (TransitionNonPermisException e) {
			System.out.println("Demande non accepte");
		}
	}
	public void enAttente() {
		try {
			EtatCourant.finDeTour();
		} catch (TransitionNonPermisException e) {
			System.out.println("Demande non accepte");
		}
	}
}
