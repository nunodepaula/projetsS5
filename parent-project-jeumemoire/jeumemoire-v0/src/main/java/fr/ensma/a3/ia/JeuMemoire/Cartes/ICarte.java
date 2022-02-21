/**
 * 
 */
package fr.ensma.a3.ia.JeuMemoire.Cartes;

/**
 * @author alvaresn
 *
 */
public interface ICarte {
	public void afficher();
	public void cacher();
	public void trouver();
	public String getId();
	public void action() throws NotImplementedException;
}
