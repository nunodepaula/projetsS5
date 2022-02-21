/**
 * 
 */
package fr.ensma.a3.ia.JeuMemoire;

import java.util.ArrayList;
import java.util.List;



import fr.ensma.a3.ia.JeuMemoire.Cartes.ICarte;
import fr.ensma.a3.ia.JeuMemoire.Joueurs.AJoueur;

/**
 * @author alvaresn
 *
 */
public class Plateau {
	private int nbLignes;
	private int nbColonnes;
	ArrayList<List<ICarte>> mesCartes;
	List<AJoueur> mesJoueurs;

	public Plateau(int ligne, int colonne) {
		nbLignes = ligne;
		nbColonnes = colonne;
		mesCartes = new ArrayList<List<ICarte>>();
		for (int i = 0; i < nbLignes; i++) {
			mesCartes.add(new ArrayList<ICarte>());
		}
		mesJoueurs = new ArrayList<AJoueur>();
	}

	public void addJoueur(AJoueur unJoueur) {
		mesJoueurs.add(unJoueur);
	}

	public void addCarte(ICarte uneCarte) {
		int temp = -1;
		for (int i = 0; i < nbLignes; i++) {
			if (mesCartes.get(i).size() < nbColonnes) {
				temp = i;
			}
		}
		if (temp != -1) {
			mesCartes.get(temp).add(uneCarte);
		}
	}
	
	public void removeCarte(ICarte uneCarte) {
	for(int i=0;i<nbLignes;i++) {
		mesCartes.get(i).remove(uneCarte);
	}
	}

	public List<AJoueur> getJoueur() {
		return mesJoueurs;
	}

	public List<List<ICarte>> getCartes() {
		return mesCartes;
	}

	public int getnbLignes() {
		return nbLignes;
	}

	public int getnbColonnes() {
		return nbColonnes;
	}
}
