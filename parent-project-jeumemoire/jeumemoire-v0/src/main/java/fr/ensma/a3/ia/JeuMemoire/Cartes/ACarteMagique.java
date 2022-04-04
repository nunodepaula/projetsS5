package fr.ensma.a3.ia.JeuMemoire.Cartes;

import fr.ensma.a3.ia.JeuMemoire.Partie;
import fr.ensma.a3.ia.JeuMemoire.Plateau;
/**
 *Définition d'une carte Magique
 */
public abstract class ACarteMagique extends ACarte implements ICarteMystere {
	private Partie maPartie;
	public ACarteMagique(String nom, Plateau unPlateau,Partie maPartie) {
		super(nom,unPlateau);
		this.maPartie=maPartie;
	}
	
	public Partie getPartie() {
		return maPartie;
	}
}
