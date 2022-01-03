/**
 * 
 */
package fr.ensma.a3.ia.JeuMemoire;

import java.util.List;

/**
 * @author alvaresn
 *
 */
public class Partie extends BaseJeu {
	
	private List<Joueur> joueurs;
	
	/**
	 * @param taillePlateau
	 */
	public Partie(Integer taillePlateau) {
		super(taillePlateau);
	}

	/**
	 * @return the taillePlateau
	 */
	public Integer getTaillePlateau() {
		return taillePlateau;
	}

	/**
	 * @param taillePlateau the taillePlateau to set
	 */
	public void setTaillePlateau(Integer taillePlateau) {
		this.taillePlateau = taillePlateau;
	}
	
	public void ajouterJoueur(Joueur j) {
		if(joueurs.size() < 8) {
			joueurs.add(j);
		}else {
			System.out.println("La partie est déjà complète, pas possible d'ajouter un autre joueur");
		}
	}
	
	public void suppJoueur(Joueur j) {
		if(joueurs.size()==0) {
			System.out.println("La partie n'a pas encore des joueurs");
			return ;
		}
		if(joueurs.contains(j)){
			joueurs.remove(j);
			System.out.println("Joueurs supprimé !!");
		}else {
			System.out.println("Joueurs n'est pas dans la partie");
		}
	}
	
	public void tirerCarte(Integer ligne1, Integer colonne1, Integer ligne2, Integer colonne2) {
		if (ligne1 < 0 || ligne1 > taillePlateau) {
			System.out.println("Coordonées hors dimensions du plateau");
			return;
		}
		if (colonne1 < 0 || colonne1 > taillePlateau) {
			System.out.println("Coordonées hors dimensions du plateau");
			return;
		}
		if (ligne2 < 0 || ligne2 > taillePlateau) {
			System.out.println("Coordonées hors dimensions du plateau");
			return;
		}
		if (colonne2 < 0 || colonne2 > taillePlateau) {
			System.out.println("Coordonées hors dimensions du plateau");
			return;
		}
		
		
	}
}
