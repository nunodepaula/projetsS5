/**
 * 
 */
package fr.ensma.a3.ia.JeuMemoire.Joueurs.automateJoueurs;

import fr.ensma.a3.ia.JeuMemoire.Joueurs.AJoueur;

/**
 * @author nunod
 *
 */
public class EnJeu extends AEtatJoueur {

	/**
	 * 
	 */
	public EnJeu(AJoueur monJoueur) {
		// TODO Auto-generated constructor stub
		super(monJoueur);
	}

	@Override
	public void finTour() {
		// TODO Auto-generated method stub
		monJoueur.setEtatCourant(monJoueur.getEtatEnAttente());
	}	
}
