	/**
 * 
 */
package fr.ensma.a3.ia.JeuMemoire;

import java.util.List;

import fr.ensma.a3.ia.JeuMemoire.Joueurs.AJoueur;

/**
 * @author alvaresn
 *
 */
public class Partie extends AElementJeu {
	
	private List<AJoueur> joueurs;
	
	/**
	 * @param taillePlateau
	 */
	public Partie(BaseJeu base) {
		super(base);
	}

	/**
	 * @return the taillePlateau
	 */
	public Integer getTaillePlateau() {
		return base.getTaillePlateau();
	}

	/**
	 * @param taillePlateau the taillePlateau to set
	 */
	public void setTaillePlateau(Integer taillePlateau) {
		base.setTaillePlateau(taillePlateau);
	}
	
	public void ajouterJoueur(AJoueur j) {
		if(joueurs.size() < 8) {
			joueurs.add(j);
		}else {
			System.out.println("La partie est déjà complète, pas possible d'ajouter un autre joueur");
		}
	}
	
	public void suppJoueur(AJoueur j) {
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
		if (ligne1 < 0 || ligne1 > base.getTaillePlateau()) {
			System.out.println("Coordonées hors dimensions du plateau");
			return;
		}
		if (colonne1 < 0 || colonne1 > base.getTaillePlateau()) {
			System.out.println("Coordonées hors dimensions du plateau");
			return;
		}
		if (ligne2 < 0 || ligne2 > base.getTaillePlateau()) {
			System.out.println("Coordonées hors dimensions du plateau");
			return;
		}
		if (colonne2 < 0 || colonne2 > base.getTaillePlateau()) {
			System.out.println("Coordonées hors dimensions du plateau");
			return;
		}
		
		
	}
}
