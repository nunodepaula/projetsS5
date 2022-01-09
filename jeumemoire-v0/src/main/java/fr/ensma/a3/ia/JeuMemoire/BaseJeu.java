/**
 * 
 */
package fr.ensma.a3.ia.JeuMemoire;

/**
 * @author alvaresn
 *
 */
public abstract class BaseJeu {

	protected Integer taillePlateau;
	
	/**
	 * @param taillePlateau
	 */
	public BaseJeu(Integer taillePlateau) {
		super();
		this.taillePlateau = taillePlateau;
	}
}
