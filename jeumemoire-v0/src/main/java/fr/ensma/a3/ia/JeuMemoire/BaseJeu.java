/**
 * 
 */
package fr.ensma.a3.ia.JeuMemoire;

/**
 * @author alvaresn
 *
 */
public class BaseJeu {

	protected Integer taillePlateau;
	protected Integer nbPaires;
	
	/**
	 * @param taillePlateau
	 */
	public BaseJeu(Integer taillePlateau, Integer nbPaires) {
		super();
		this.taillePlateau = taillePlateau;
		this.nbPaires = nbPaires;
	}

	public Integer getTaillePlateau() {
		return taillePlateau;
	}

	public void setTaillePlateau(Integer taillePlateau) {
		this.taillePlateau = taillePlateau;
	}

	public Integer getNbPaires() {
		return nbPaires;
	}

	public void setNbPaires(Integer nbPaires) {
		this.nbPaires = nbPaires;
	}
	
	
}
