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
	public void secondTour() throws TransitionNonPermisException;
	public void finDeTour() throws TransitionNonPermisException;
	
}