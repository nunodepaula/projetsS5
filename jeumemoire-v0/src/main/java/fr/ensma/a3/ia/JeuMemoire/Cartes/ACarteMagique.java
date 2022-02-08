package fr.ensma.a3.ia.JeuMemoire.Cartes;

import fr.ensma.a3.ia.JeuMemoire.Plateau;

public abstract class ACarteMagique extends ACarte implements ICarteMystere {
	
	public ACarteMagique(String nom, Plateau unPlateau) {
		super(nom,unPlateau);
	}	
}
