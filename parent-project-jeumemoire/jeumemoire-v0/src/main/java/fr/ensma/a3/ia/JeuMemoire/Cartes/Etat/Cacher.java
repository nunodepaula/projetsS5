package fr.ensma.a3.ia.JeuMemoire.Cartes.Etat;

import fr.ensma.a3.ia.JeuMemoire.Cartes.ACarte;
/**
 *Définition de l'état cacher
 */
public class Cacher extends AEtatCarte{
	public Cacher(ACarte c) {
		uneCarte=c;
	}
	@Override
	public void afficher() {
		uneCarte.setEtatCourant(uneCarte.getAfficher());
	}
}
