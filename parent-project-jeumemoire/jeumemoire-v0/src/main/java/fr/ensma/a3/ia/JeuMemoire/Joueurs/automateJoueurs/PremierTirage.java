/**
 * 
 */
package fr.ensma.a3.ia.JeuMemoire.Joueurs.automateJoueurs;

import fr.ensma.a3.ia.JeuMemoire.Joueurs.AJoueur;

/**
 * @author nunod
 *
 */
public class PremierTirage extends AEtatJoueur {

	/**
	 * 
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