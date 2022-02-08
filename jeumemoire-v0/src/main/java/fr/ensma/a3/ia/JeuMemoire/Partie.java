/**
* 
*/
package fr.ensma.a3.ia.JeuMemoire;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.ensma.a3.ia.JeuMemoire.Cartes.ACarte;
import fr.ensma.a3.ia.JeuMemoire.Joueurs.AJoueur;

/**
 * @author alvaresn
 *
 */
public class Partie extends AElementJeu {

	private List<AJoueur> joueurs;
	private Plateau monPlateau;
	private Integer gagnerPartie;
	/**
	 * @param taillePlateau
	 */
	public Partie(BaseJeu base,Plateau monPlateau) {
		super(base);
		gagnerPartie=0;
		this.monPlateau=monPlateau;
		joueurs=new ArrayList<AJoueur>();
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
		if (joueurs.size() < 8) {
			joueurs.add(j);
		} else {
			System.out.println("La partie est déjà complète, pas possible d'ajouter un autre joueur");
		}
	}
	
	public void suppJoueur(AJoueur j) {
		if (joueurs.size() == 0) {
			System.out.println("La partie n'a pas encore des joueurs");
			return;
		}
		if (joueurs.contains(j)) {
			joueurs.remove(j);
			System.out.println("Joueurs supprimé !!");
		} else {
			System.out.println("Joueurs n'est pas dans la partie");
		}
	}

	public Boolean tirerCarte(Integer ligne1, Integer colonne1) {
		if (ligne1 < 0 || ligne1 > monPlateau.getnbLignes()-1) {
			System.out.println("Coordonées hors dimensions du plateau");
			return false;
		}
		if (colonne1 < 0 || colonne1 > monPlateau.getnbColonnes()-1) {
			System.out.println("Coordonées hors dimensions du plateau");
			return false;
		}
		else {
			return true;
		}
	}
	
	public void affichage() {
		for(int i=0;i<monPlateau.getnbLignes();i++) {
			for(int j=0;j<monPlateau.getnbColonnes();j++) {
				if(((ACarte)monPlateau.getCartes().get(i).get(j)).getEtatCourant()==((ACarte)monPlateau.getCartes().get(i).get(j)).getCacher()){
					System.out.print("*");
				}
				if(((ACarte)monPlateau.getCartes().get(i).get(j)).getEtatCourant()==((ACarte)monPlateau.getCartes().get(i).get(j)).getAfficher()) {
					System.out.print(monPlateau.getCartes().get(i).get(j).getId());
				}
				if(((ACarte)monPlateau.getCartes().get(i).get(j)).getEtatCourant()==((ACarte)monPlateau.getCartes().get(i).get(j)).getTrouver()) {
					System.out.print("-");
				}
		}
			System.out.print("\n");	
		}
		
	}
	
	public Plateau getPlateau() {
		return monPlateau;
	}

	public void lancerPartie() {
		while (gagnerPartie != 1) {
			for (int i = 0; i < joueurs.size(); i++) {
				joueurs.get(i).aTontour();
				affichage();
				System.out.println("Entrer un entier selectionnez la ligne");
				Scanner sc = new Scanner(System.in);
				Integer ligne = sc.nextInt();
				System.out.println("Entrer un entier selectionnez la colonne");
				Integer colonne = sc.nextInt();
				if (tirerCarte(ligne, colonne)) {
					joueurs.get(i).tirerCarte(colonne, ligne);
					
				}
				affichage();
				System.out.println("Second Tirage");
				Integer ligne2 = sc.nextInt();
				Integer colonne2 = sc.nextInt();
				if (tirerCarte(colonne2, ligne2)) {
					joueurs.get(i).tirerCarte(colonne2, ligne2);
				
				}
				affichage();
				if ((monPlateau.getCartes().get(ligne).get(colonne).getId())
						.compareTo(monPlateau.getCartes().get(ligne2).get(colonne2).getId()) == 0) {
					System.out.println("rentre ici 0");
					monPlateau.getCartes().get(ligne).get(colonne).trouver();
					monPlateau.getCartes().get(ligne2).get(colonne2).trouver();
					joueurs.get(i).setScore(joueurs.get(i).getScore() + 1);
					joueurs.get(i).addCarteGagne((monPlateau.getCartes().get(ligne).get(colonne)));
					joueurs.get(i).addCarteGagne((monPlateau.getCartes().get(ligne2).get(colonne2)));
				}
				else {
					System.out.println("rentre ici 1");
					monPlateau.getCartes().get(ligne).get(colonne).cacher();
					monPlateau.getCartes().get(ligne2).get(colonne2).cacher();
				}
				joueurs.get(i).enAttente();
			}
		}
	}
}
