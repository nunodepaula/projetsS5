package fr.ensma.a3.ia.JeuMemoire.Joueurs.automateJoueurs;

import fr.ensma.a3.ia.JeuMemoire.Joueurs.AJoueur;

public class SecondTirage extends AEtatJoueur{

	/**
	 * 
	 */
	public SecondTirage(AJoueur monJoueur) {
		// TODO Auto-generated constructor stub
		super(monJoueur);
	}

	@Override
	public void finDeTour() {
		// TODO Auto-generated method stub
		monJoueur.setEtatCourant(monJoueur.getEtatEnAttente());
	}	
}


