/**
 * 
 */
package fr.ensma.a3.ia.JeuMemoire.Joueurs.automateJoueurs;

import fr.ensma.a3.ia.JeuMemoire.Joueurs.AJoueur;

/**
 * @author nunod
 *Définition de l'état EnAttente
 */
public class EnAttente extends AEtatJoueur {

	/**
	 * Obtient l'instance de EnAttente
	 * @param monJoueur
	 */
	public EnAttente(AJoueur monJoueur) {
		// TODO Auto-generated constructor stub
		super(monJoueur);
	}
	
	@Override
	public void aTonTour() {
		// TODO Auto-generated method stub
		monJoueur.setEtatCourant(monJoueur.getEtatPremierTirage());
	}

}
