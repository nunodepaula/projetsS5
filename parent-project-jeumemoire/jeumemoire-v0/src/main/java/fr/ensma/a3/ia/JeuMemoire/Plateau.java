/**
 * 
 */
package fr.ensma.a3.ia.JeuMemoire;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fr.ensma.a3.ia.JeuMemoire.Cartes.ICarte;
import fr.ensma.a3.ia.JeuMemoire.Joueurs.AJoueur;

/**
 * Définition du plateau de jeu
 * @author alvaresn
 */


public class Plateau {
	private Integer nbLignes;
	private Integer nbColonnes;
	ArrayList<List<ICarte>> mesCartes;
	/**
	 * Obtient l'instance d'un plateau 
	 * @param ligne nombre de lignes de cartes dans le plateau
	 * @param colonne nombre de colonnes de cartes dans le plateau
	 */
	public Plateau(Integer ligne, Integer colonne) {
		this.nbLignes = Objects.requireNonNull(ligne);
		this.nbColonnes = Objects.requireNonNull(colonne);
		mesCartes = new ArrayList<List<ICarte>>();
		for (int i = 0; i < nbLignes; i++) {
			mesCartes.add(new ArrayList<ICarte>());
		}
	}

	
	/**
	 * Ajout d'une carte dans le plateau
	 * @param {@link ICarte} uneCarte
	 */
	public void addCarte(ICarte uneCarte) throws JeuDeCartePleinException{
		int temp = -1;
		for (int i = 0; i < nbLignes; i++) {
			if (mesCartes.get(i).size() < nbColonnes) {
				temp = i;
				
			}
		}
		System.out.println(temp);
		if (temp != -1) {
			mesCartes.get(temp).add(uneCarte);
		}
		else {
			throw new JeuDeCartePleinException("Le jeu de carte est plein");
		}
	}
	
	
	
	/**
	 * Retrait d'une carte du plateau 
	 * @param {@ link ICarte} uneCarte 
	 */
	public Boolean removeCarte(ICarte uneCarte) {
	for(int i=0;i<nbLignes;i++) {
		if(mesCartes.get(i).remove(uneCarte)){
			return true;
		};
	}
	return false;
	}

	
	/**
	 * Renvoie la liste des cartes du plateau 
	 * @return liste des cartes du plateau
	 */
	public List<List<ICarte>> getCartes() {
		return mesCartes;
	}
	/**
	 * Renvoie le nombre de lignes du plateau
	 * @return nombre de lignes
	 */
	public int getnbLignes() {
		return nbLignes;
	}
	/**
	 * Renvoie le nombre de colonnes 
	 * @return nombre de colonnes
	 */
	public int getnbColonnes() {
		return nbColonnes;
	}
}
