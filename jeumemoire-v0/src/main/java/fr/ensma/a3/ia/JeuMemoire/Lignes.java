/**
 * 
 */
package fr.ensma.a3.ia.JeuMemoire;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.JeuMemoire.Cartes.ICarte;

/**
 * @author alvaresn
 *
 */
public class Lignes extends BaseJeu {

	private List<ICarte> colonnes;

	/**
	 * @param taillePlateau
	 */
	public Lignes(Integer taillePlateau) {
		super(taillePlateau);
		colonnes = new ArrayList<ICarte>();
	}

	/**
	 * @return the colonnes
	 */
	public List<ICarte> getColonnes() {
		return colonnes;
	}

	/**
	 * @param colonnes the colonnes to set
	 */
	public void setColonnes(List<ICarte> colonnes) {
		this.colonnes = colonnes;
	}

	public void ajouterColonne(ICarte c) {
		if (colonnes.size() < taillePlateau) {
			colonnes.add(c);
			System.out.println("Colonne ajoutée à la ligne");
		} else {
			System.out.println("La ligne est déjà complète");
		}
	}
}
