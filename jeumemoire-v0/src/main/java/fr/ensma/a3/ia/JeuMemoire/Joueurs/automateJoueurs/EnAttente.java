/**
 * 
 */
package fr.ensma.a3.ia.JeuMemoire.Joueurs.automateJoueurs;

import fr.ensma.a3.ia.JeuMemoire.Joueurs.AJoueur;

/**
 * @author nunod
 *
 */
public class EnAttente extends AEtatJoueur {

	/**
	 * 
	 */
	public EnAttente(AJoueur monJoueur) {
		// TODO Auto-generated constructor stub
		super(monJoueur);
	}
	
	@Override
	public void aTonTour() {
		// TODO Auto-generated method stub
		monJoueur.setEtatCourant(monJoueur.getEtatEnJeu());
	}

}
