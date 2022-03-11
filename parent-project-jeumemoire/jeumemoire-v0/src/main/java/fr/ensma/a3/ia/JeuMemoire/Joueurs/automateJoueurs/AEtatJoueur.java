/**
 * 
 */
package fr.ensma.a3.ia.JeuMemoire.Joueurs.automateJoueurs;

import fr.ensma.a3.ia.JeuMemoire.Joueurs.AJoueur;

/**
 * @author nunod
 *
 */
public class AEtatJoueur implements IEtatJoueurs {
	protected AJoueur monJoueur;
	/**
	 * 
	 */
	public AEtatJoueur(AJoueur monJoueur) {
		// TODO Auto-generated constructor stub
		this.monJoueur=monJoueur;
	}

	@Override
	public void aTonTour() throws TransitionNonPermisException{
		// TODO Auto-generated method stub
		throw new TransitionNonPermisException();
	}

	@Override
	public void secondTour() throws TransitionNonPermisException{
		// TODO Auto-generated method stub
		throw new TransitionNonPermisException();
	}
	@Override
	public void finDeTour() throws TransitionNonPermisException{
		// TODO Auto-generated method stub
		throw new TransitionNonPermisException();
	}


}
