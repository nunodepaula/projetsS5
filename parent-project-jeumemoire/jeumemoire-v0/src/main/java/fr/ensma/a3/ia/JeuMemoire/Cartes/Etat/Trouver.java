package fr.ensma.a3.ia.JeuMemoire.Cartes.Etat;

import fr.ensma.a3.ia.JeuMemoire.Cartes.ACarte;

public class Trouver extends AEtatCarte{
	public Trouver(ACarte c) {
		uneCarte=c;
	}
	@Override
	public void cacher() {
		uneCarte.setEtatCourant(uneCarte.getCacher());
	}
}
