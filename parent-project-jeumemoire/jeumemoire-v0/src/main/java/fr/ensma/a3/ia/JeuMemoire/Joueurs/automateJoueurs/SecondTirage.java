package fr.ensma.a3.ia.JeuMemoire.Joueurs.automateJoueurs;

import fr.ensma.a3.ia.JeuMemoire.Joueurs.AJoueur;

/**
 * Définition de l'état d'un second tirage
 */
public class SecondTirage extends AEtatJoueur{

	/**
	 * Obtient l'instance d'un second tirage
	 * @param monJoueur
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


