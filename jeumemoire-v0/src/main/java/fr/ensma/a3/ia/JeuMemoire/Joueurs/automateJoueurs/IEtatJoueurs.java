/**
 * 
 */
package fr.ensma.a3.ia.JeuMemoire.Joueurs.automateJoueurs;

/**
 * @author nunod
 *
 */
public interface IEtatJoueurs {

	public void aTonTour() throws TransitionNonPermisException;
	public void finTour() throws TransitionNonPermisException;
	public void nouveauTour() throws TransitionNonPermisException;
	
}