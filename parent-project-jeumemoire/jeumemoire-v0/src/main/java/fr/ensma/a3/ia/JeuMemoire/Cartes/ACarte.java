package fr.ensma.a3.ia.JeuMemoire.Cartes;

import java.lang.System.Logger;

import fr.ensma.a3.ia.JeuMemoire.JeuDeCartePleinException;
import fr.ensma.a3.ia.JeuMemoire.Plateau;
import fr.ensma.a3.ia.JeuMemoire.Cartes.Etat.Afficher;
import fr.ensma.a3.ia.JeuMemoire.Cartes.Etat.Cacher;
import fr.ensma.a3.ia.JeuMemoire.Cartes.Etat.IEtatCarte;
import fr.ensma.a3.ia.JeuMemoire.Cartes.Etat.TransitionNonTirableException;
import fr.ensma.a3.ia.JeuMemoire.Cartes.Etat.Trouver;
/**
 *Définition d'une carte
 */
public abstract class ACarte implements ICarte {
	protected String id;
	protected Plateau monPlateau;
	private IEtatCarte etatCourant;
	private IEtatCarte carteAfficher = new Afficher(this);
	private IEtatCarte carteTrouver = new Trouver(this);
	private IEtatCarte carteCacher = new Cacher(this);
	/**
	 * 
	 * @param nom de la carte
	 * @param unPlateau plateau dans lequel se trouve la carte
	 */
	public ACarte(String nom, Plateau unPlateau) {
		id = nom;
		monPlateau = unPlateau;
		try {
			getPlateau().addCarte(this);
		} catch (JeuDeCartePleinException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		etatCourant = carteCacher;
	}
	/**
	 * retourne l'identifiant de la carte
	 * @return identifiant
	 */
	public String getId() {
		return id;
	}

	@Override
	public void action() throws NotImplementedException {
		throw new NotImplementedException();
	}
	/**
	 * 
	 * @return plateau
	 */
	public Plateau getPlateau() {
		return monPlateau;
	}
	/**
	 * change l'état courant de la carte
	 * @param nouvelEtat
	 */
	public void setEtatCourant(IEtatCarte nouvelEtat) {
		etatCourant = nouvelEtat;
	}
	
	/**
	 * @return renvoie l'état courant de la carte
	 */
	public IEtatCarte getEtatCourant() {
		return etatCourant;
	}
	/**
	 * 
	 * @return renvoie l'état caché
	 */
	public IEtatCarte getCacher() {
		return carteCacher;
	}
	/**
	 * @return renvoie l'état trouvé de la carte
	 */
	public IEtatCarte getTrouver() {
		return carteTrouver;
	}
	/**
	 * @return renvoie l'état affiché de la carte
	 */
	public IEtatCarte getAfficher() {
		return carteAfficher;
	}
	/**
	 * change l'état de cacher vers afficher
	 */
	@Override
	public void afficher() {
		try {
			etatCourant.afficher();
			System.out.println(this.getId());
		} catch (TransitionNonTirableException e) {
			System.out.println("Demande non valide");
		}
	}
	/**
	 * change l'état de afficher vers cacher
	 */
	@Override
	public void cacher() {
		try {
			etatCourant.cacher();
			System.out.println("cacher");
		} catch (TransitionNonTirableException e) {
			System.out.println("Demande non valide");
		}
	}
	/**
	 * change l'état de afficher vers trouver
	 */
	@Override
	public void trouver() {
		try {
			etatCourant.trouver();
		} catch (TransitionNonTirableException e) {
			System.out.println("Demande non valide");
		}
	}
}
