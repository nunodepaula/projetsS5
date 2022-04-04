/**
 * 
 */
package fr.ensma.a3.ia.JeuMemoire.Joueurs.automateJoueurs;

import fr.ensma.a3.ia.JeuMemoire.Joueurs.AJoueur;

/**
 * @author nunod
 * Définition du PremierTirage
 */
public class PremierTirage extends AEtatJoueur {

	/**
	 * Obtient l'instance de PremierTirage
	 * @param monJoueur
	 */
	public PremierTirage(AJoueur monJoueur) {
		// TODO Auto-generated constructor stub
		super(monJoueur);
	}

	@Override
	public void secondTour() {
		// TODO Auto-generated method stub
		monJoueur.setEtatCourant(monJoueur.getEtatSecondTirage());
	}	
}
