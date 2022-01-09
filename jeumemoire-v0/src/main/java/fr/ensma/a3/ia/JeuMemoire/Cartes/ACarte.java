package fr.ensma.a3.ia.JeuMemoire.Cartes;

import java.lang.System.Logger;

import fr.ensma.a3.ia.JeuMemoire.Cartes.Etat.Afficher;
import fr.ensma.a3.ia.JeuMemoire.Cartes.Etat.Cacher;
import fr.ensma.a3.ia.JeuMemoire.Cartes.Etat.IEtatCarte;
import fr.ensma.a3.ia.JeuMemoire.Cartes.Etat.TransitionNonTirableException;
import fr.ensma.a3.ia.JeuMemoire.Cartes.Etat.Trouver;

public abstract class ACarte implements ICarte{
	protected String id;
	protected Plateau monPlateau;
	private IEtatCarte etatCourant;
	private IEtatCarte carteAfficher=new Afficher(this);
	private IEtatCarte carteTrouver=new Trouver(this);
	private IEtatCarte carteCacher=new Cacher(this);
	public ACarte(String nom,Plateau unPlateau) {
		id=nom;
		monPlateau=unPlateau;
		getPlateau().ajouterCarte();
		etatCourant=carteCacher;
	}
	public String getId() {
		return id;
	}
	@Override
	public void action() throws NotImplementedException {
		throw new NotImplementedException();		
	}
	public Plateau getPlateau() {
		return monPlateau;
	}
	public void setEtatCourant(IEtatCarte nouvelEtat) {
		etatCourant=nouvelEtat;
	}
	public IEtatCarte getCacher() {
		return carteCacher;
	}
	public IEtatCarte getTrouver() {
		return carteTrouver;
	}
	public IEtatCarte getAfficher() {
		return carteAfficher;
	}
	@Override
	public void afficher() {
		try {
		etatCourant.afficher();
		System.out.println(this.getId());
		}catch(TransitionNonTirableException e) {
			System.out.println("Demande non valide");
		}
	}
	@Override
	public void cacher() {
		try {
		etatCourant.cacher();
		System.out.println("cacher");
		}catch(TransitionNonTirableException e) {
			System.out.println("Demande non valide");
		}
	}
	public void trouver() {
		try {
			etatCourant.trouver();
		}catch(TransitionNonTirableException e) {
			System.out.println("Demande non valide");
		}		
	}
}
