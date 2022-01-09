package fr.ensma.a3.ia.JeuMemoire.Cartes.Etat;

import fr.ensma.a3.ia.JeuMemoire.Cartes.ACarte;

public class Afficher extends AEtatCarte{
	public Afficher(ACarte c) {
		uneCarte=c;
	}
	@Override
	public void cacher() {
		uneCarte.setEtatCourant(uneCarte.getCacher());
	}
	@Override
	public void trouver() {
		uneCarte.setEtatCourant(uneCarte.getTrouver());
	}
}
