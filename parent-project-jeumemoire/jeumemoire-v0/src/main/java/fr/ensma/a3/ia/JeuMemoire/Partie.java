/**
* 
*/
package fr.ensma.a3.ia.JeuMemoire;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.ensma.a3.ia.JeuMemoire.Cartes.ACarte;
import fr.ensma.a3.ia.JeuMemoire.Cartes.CarteSimple;
import fr.ensma.a3.ia.JeuMemoire.Cartes.DansTaFace;
import fr.ensma.a3.ia.JeuMemoire.Cartes.ICarte;
import fr.ensma.a3.ia.JeuMemoire.Cartes.ICarteMystere;
import fr.ensma.a3.ia.JeuMemoire.Cartes.MelangeTout;
import fr.ensma.a3.ia.JeuMemoire.Cartes.ReveleTout;
import fr.ensma.a3.ia.JeuMemoire.Joueurs.AJoueur;

/**
 * @author alvaresn
 *
 */
public class Partie {

	private List<AJoueur> joueurs;
	private Plateau monPlateau;
	private Integer gagnerPartie;
	private Integer nbJoueur;
	private String difficulte;
	private Integer nbpaires;
	private Integer mode;

	/**
	 * @param taillePlateau
	 */
	public Partie(Plateau monPlateau, Integer nbJoueur, String difficulte, Integer mode) {
		gagnerPartie = 0;
		this.monPlateau = monPlateau;
		joueurs = new ArrayList<AJoueur>();
		this.nbJoueur = nbJoueur;
		this.difficulte = difficulte;
		this.mode = mode;
	}

	/**
	 * @return the taillePlateau
	 */

	/**
	 * @param taillePlateau the taillePlateau to set
	 */

	public void initPartie() {
		if (this.mode == 1) {
			nbpaires = 6;
			CarteSimple carte1 = new CarteSimple("pingouin", this.monPlateau);
			CarteSimple carte2 = new CarteSimple("pingouin", this.monPlateau);
			CarteSimple carte3 = new CarteSimple("singe", this.monPlateau);
			CarteSimple carte4 = new CarteSimple("singe", this.monPlateau);
			CarteSimple carte5 = new CarteSimple("zebre", this.monPlateau);
			CarteSimple carte6 = new CarteSimple("zebre", this.monPlateau);
			CarteSimple carte7 = new CarteSimple("chien", this.monPlateau);
			CarteSimple carte8 = new CarteSimple("chien", this.monPlateau);
			CarteSimple carte9 = new CarteSimple("chat", this.monPlateau);
			CarteSimple carte10 = new CarteSimple("chat", this.monPlateau);
			CarteSimple carte11 = new CarteSimple("tortue", this.monPlateau);
			CarteSimple carte12 = new CarteSimple("tortue", this.monPlateau);
			ReveleTout  carte13=new ReveleTout(this.getPlateau());
			DansTaFace carte14=new DansTaFace(this.getPlateau());
			for (int i = 0; i < this.getPlateau().getnbColonnes() * this.getPlateau().getnbLignes()
					- 2 * this.nbpaires-2; i++) {
				MelangeTout melangetout = new MelangeTout(this.getPlateau());
			}
		}
		if (this.nbpaires == 2) {
			nbpaires = 12;
			CarteSimple carte1 = new CarteSimple("pingouin", this.monPlateau);
			CarteSimple carte2 = new CarteSimple("pinguouin", this.monPlateau);
			CarteSimple carte3 = new CarteSimple("singe", this.monPlateau);
			CarteSimple carte4 = new CarteSimple("singe", this.monPlateau);
			CarteSimple carte5 = new CarteSimple("zebre", this.monPlateau);
			CarteSimple carte6 = new CarteSimple("zebre", this.monPlateau);
			CarteSimple carte7 = new CarteSimple("chien", this.monPlateau);
			CarteSimple carte8 = new CarteSimple("chien", this.monPlateau);
			CarteSimple carte9 = new CarteSimple("chat", this.monPlateau);
			CarteSimple carte10 = new CarteSimple("chat", this.monPlateau);
			CarteSimple carte11 = new CarteSimple("tortue", this.monPlateau);
			CarteSimple carte12 = new CarteSimple("tortue", this.monPlateau);
			CarteSimple carte13 = new CarteSimple("lion", this.monPlateau);
			CarteSimple carte14 = new CarteSimple("lion", this.monPlateau);
			CarteSimple carte15 = new CarteSimple("loup", this.monPlateau);
			CarteSimple carte16 = new CarteSimple("loup", this.monPlateau);
			CarteSimple carte17 = new CarteSimple("tigre", this.monPlateau);
			CarteSimple carte18 = new CarteSimple("tigre", this.monPlateau);
			CarteSimple carte19 = new CarteSimple("lapin", this.monPlateau);
			CarteSimple carte20 = new CarteSimple("lapin", this.monPlateau);
			CarteSimple carte21 = new CarteSimple("requin", this.monPlateau);
			CarteSimple carte22 = new CarteSimple("requin", this.monPlateau);
			CarteSimple carte23 = new CarteSimple("dauphin", this.monPlateau);
			CarteSimple carte24 = new CarteSimple("dauphin", this.monPlateau);
			for (int i = 0; i < this.getPlateau().getnbColonnes() * this.getPlateau().getnbLignes()
					- 2 * this.nbpaires; i++) {
				MelangeTout melangetout = new MelangeTout(this.getPlateau());
			}
		}
		if (this.mode == 3) {
			nbpaires = 30;
			CarteSimple carte1 = new CarteSimple("pinguouin", this.monPlateau);
			CarteSimple carte2 = new CarteSimple("pinguouin", this.monPlateau);
			CarteSimple carte3 = new CarteSimple("singe", this.monPlateau);
			CarteSimple carte4 = new CarteSimple("singe", this.monPlateau);
			CarteSimple carte5 = new CarteSimple("zebre", this.monPlateau);
			CarteSimple carte6 = new CarteSimple("zebre", this.monPlateau);
			CarteSimple carte7 = new CarteSimple("chien", this.monPlateau);
			CarteSimple carte8 = new CarteSimple("chien", this.monPlateau);
			CarteSimple carte9 = new CarteSimple("chat", this.monPlateau);
			CarteSimple carte10 = new CarteSimple("chat", this.monPlateau);
			CarteSimple carte11 = new CarteSimple("tortue", this.monPlateau);
			CarteSimple carte12 = new CarteSimple("tortue", this.monPlateau);
			CarteSimple carte13 = new CarteSimple("lion", this.monPlateau);
			CarteSimple carte14 = new CarteSimple("lion", this.monPlateau);
			CarteSimple carte15 = new CarteSimple("loup", this.monPlateau);
			CarteSimple carte16 = new CarteSimple("loup", this.monPlateau);
			CarteSimple carte17 = new CarteSimple("tigre", this.monPlateau);
			CarteSimple carte18 = new CarteSimple("tigre", this.monPlateau);
			CarteSimple carte19 = new CarteSimple("lapin", this.monPlateau);
			CarteSimple carte20 = new CarteSimple("lapin", this.monPlateau);
			CarteSimple carte21 = new CarteSimple("requin", this.monPlateau);
			CarteSimple carte22 = new CarteSimple("requin", this.monPlateau);
			CarteSimple carte23 = new CarteSimple("dauphin", this.monPlateau);
			CarteSimple carte24 = new CarteSimple("dauphin", this.monPlateau);
			CarteSimple carte25 = new CarteSimple("licorne", this.monPlateau);
			CarteSimple carte26 = new CarteSimple("licorne", this.monPlateau);
			CarteSimple carte27 = new CarteSimple("dragon", this.monPlateau);
			CarteSimple carte28 = new CarteSimple("dragon", this.monPlateau);
			CarteSimple carte29 = new CarteSimple("aigle", this.monPlateau);
			CarteSimple carte30 = new CarteSimple("aigle", this.monPlateau);
			CarteSimple carte31 = new CarteSimple("taupe", this.monPlateau);
			CarteSimple carte32 = new CarteSimple("taupe", this.monPlateau);
			CarteSimple carte33 = new CarteSimple("panthere", this.monPlateau);
			CarteSimple carte34 = new CarteSimple("panthere", this.monPlateau);
			CarteSimple carte35 = new CarteSimple("herisson", this.monPlateau);
			CarteSimple carte36 = new CarteSimple("herisson", this.monPlateau);
			CarteSimple carte37 = new CarteSimple("cochon", this.monPlateau);
			CarteSimple carte38 = new CarteSimple("cochon", this.monPlateau);
			CarteSimple carte39 = new CarteSimple("mouton", this.monPlateau);
			CarteSimple carte40 = new CarteSimple("mouton", this.monPlateau);
			CarteSimple carte41 = new CarteSimple("poule", this.monPlateau);
			CarteSimple carte42 = new CarteSimple("poule", this.monPlateau);
			CarteSimple carte43 = new CarteSimple("poussin", this.monPlateau);
			CarteSimple carte44 = new CarteSimple("poussin", this.monPlateau);
			CarteSimple carte45 = new CarteSimple("vache", this.monPlateau);
			CarteSimple carte46 = new CarteSimple("vache", this.monPlateau);
			CarteSimple carte47 = new CarteSimple("leopard", this.monPlateau);
			CarteSimple carte48 = new CarteSimple("leopard", this.monPlateau);
			CarteSimple carte49 = new CarteSimple("serpent", this.monPlateau);
			CarteSimple carte50 = new CarteSimple("serpent", this.monPlateau);
			CarteSimple carte51 = new CarteSimple("fourmi", this.monPlateau);
			CarteSimple carte52 = new CarteSimple("fourmi", this.monPlateau);
			CarteSimple carte53 = new CarteSimple("girafe", this.monPlateau);
			CarteSimple carte54 = new CarteSimple("girafe", this.monPlateau);
			CarteSimple carte55 = new CarteSimple("dinausore", this.monPlateau);
			CarteSimple carte56 = new CarteSimple("dinausore", this.monPlateau);
			CarteSimple carte57 = new CarteSimple("abeille", this.monPlateau);
			CarteSimple carte58 = new CarteSimple("abeille", this.monPlateau);
			CarteSimple carte59 = new CarteSimple("pieuvre", this.monPlateau);
			CarteSimple carte60 = new CarteSimple("pieuvre", this.monPlateau);
			for (int i = 0; i < this.getPlateau().getnbColonnes() * this.getPlateau().getnbLignes()
					- 2 * this.nbpaires; i++) {
				MelangeTout melangetout = new MelangeTout(this.getPlateau());
			}
		}
		this.joueurs.get(0).aTontour();
	}

	public String Action(AJoueur unjoueur, int colonne, int ligne) {
		String valeur;
		ICarte maCarte;
		maCarte = unjoueur.tirerCarte(colonne, ligne);
		unjoueur.addCarteGagne(maCarte);
		valeur = maCarte.getId();
		if (maCarte instanceof ICarteMystere) {
			ICarteMystere maCarteMagique = (ICarteMystere) maCarte;
			maCarteMagique.effetSpecial();
			if (unjoueur.getEtatCourant() != unjoueur.getEtatSecondTirage()) {
				unjoueur.secondTirage();
				auJoueurSuivant("cacher");
			}
		}
		System.out.println(maCarte.getId());
		return valeur;
	}
	

	public String test(AJoueur unjoueur) {
		String valeur;
		if ((unjoueur.getCarteGagne().get(unjoueur.getCarteGagne().size() - 1).getId()
				.compareTo(unjoueur.getCarteGagne().get(unjoueur.getCarteGagne().size() - 2).getId()) == 0)
				&& (unjoueur.getCarteGagne().get(unjoueur.getCarteGagne().size() - 1) != unjoueur.getCarteGagne()
						.get(unjoueur.getCarteGagne().size() - 2))) {
			unjoueur.setScore(unjoueur.getScore() + 1);
			unjoueur.getCarteGagne().get(unjoueur.getCarteGagne().size() - 1).trouver();
			unjoueur.getCarteGagne().get(unjoueur.getCarteGagne().size() - 2).trouver();
			valeur = "trouver";
			return valeur;
		} else {
			unjoueur.getCarteGagne().get(unjoueur.getCarteGagne().size() - 1).cacher();
			unjoueur.getCarteGagne().get(unjoueur.getCarteGagne().size() - 2).cacher();
			unjoueur.getCarteGagne().remove(unjoueur.getCarteGagne().size() - 1);
			unjoueur.getCarteGagne().remove(unjoueur.getCarteGagne().size() - 1);
			valeur = "cacher";
			return valeur;
		}
	}

	public Boolean finPartie() {
		Integer count = 0;
		for (List<ICarte> maLigne : this.getPlateau().getCartes()) {
			for (ICarte maCarte : maLigne) {
				ACarte mCarte = (ACarte) maCarte;
				if (mCarte.getEtatCourant() == mCarte.getTrouver()) {
					count++;
				}
			}
		}
		System.out.println(count);
		if (count == 2 * this.nbpaires) {
			return true;
		} else {
			return false;
		}
	}
	
	public List<Integer> reaffichage(AJoueur joueur){
		List<Integer> coordonneCarteReafficher=new ArrayList<Integer>();
		for(ICarte maCarte : joueur.getCarteGagne()) {
				for(int i=0;i<this.getPlateau().getCartes().size();i++) {
				for(int j=0;i<this.getPlateau().getCartes().get(i).size();j++) {
					if (maCarte.getId().compareTo(this.getPlateau().getCartes().get(i).get(j).getId())==0) {
						coordonneCarteReafficher.add(i);
						coordonneCarteReafficher.add(j);
				}
			}
		}
				joueur.getCarteGagne().remove(maCarte);
		}
		return coordonneCarteReafficher;
	}

	public void auJoueurSuivant(String valeur) {
		if (valeur == "cacher") {
			for (int i = 0; i < joueurs.size(); i++) {
				if (joueurs.get(i).getEtatCourant() == joueurs.get(i).getEtatSecondTirage()) {
					joueurs.get(i).enAttente();
					if (i == this.nbJoueur - 1) {
						joueurs.get(0).aTontour();
					} else {
						joueurs.get(i + 1).aTontour();
					}
				}
			}
		} else {
			for (int i = 0; i < joueurs.size(); i++) {
				if (joueurs.get(i).getEtatCourant() == joueurs.get(i).getEtatSecondTirage()) {
					joueurs.get(i).enAttente();
					joueurs.get(i).aTontour();
				}
			}
		}
	}

	public List<AJoueur> getJoueurs() {
		return joueurs;
	}

	public Integer getNbJoueurs() {
		return nbJoueur;
	}

	public void ajouterJoueur(AJoueur j) {
		if (joueurs.size() < 8) {
			joueurs.add(j);
			j.setPartie(this);
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
		if (ligne1 < 0 || ligne1 > monPlateau.getnbLignes() - 1) {
			System.out.println("Coordonées hors dimensions du plateau");
			return false;
		}
		if (colonne1 < 0 || colonne1 > monPlateau.getnbColonnes() - 1) {
			System.out.println("Coordonées hors dimensions du plateau");
			return false;
		} else {
			return true;
		}
	}

	public void affichage() {
		for (int i = 0; i < monPlateau.getnbLignes(); i++) {
			for (int j = 0; j < monPlateau.getnbColonnes(); j++) {
				if (((ACarte) monPlateau.getCartes().get(i).get(j))
						.getEtatCourant() == ((ACarte) monPlateau.getCartes().get(i).get(j)).getCacher()) {
					System.out.print("*");
				}
				if (((ACarte) monPlateau.getCartes().get(i).get(j))
						.getEtatCourant() == ((ACarte) monPlateau.getCartes().get(i).get(j)).getAfficher()) {
					System.out.print(monPlateau.getCartes().get(i).get(j).getId());
				}
				if (((ACarte) monPlateau.getCartes().get(i).get(j))
						.getEtatCourant() == ((ACarte) monPlateau.getCartes().get(i).get(j)).getTrouver()) {
					System.out.print("-");
				}
			}
			System.out.print("\n");
		}

	}

	public Plateau getPlateau() {
		return monPlateau;
	}
	public String getCarteByLigneColonne(int i,int j) {
		ICarte maCarte=this.getPlateau().getCartes().get(i).get(j);
		ACarte carte=(ACarte) maCarte;
		if(carte.getEtatCourant()==carte.getAfficher()) {
			carte.cacher();
			return(carte.getId());
		}
		if(carte.getEtatCourant()==carte.getCacher()) {
			return(carte.getId());
		}
		else {
			return null;
			}
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
				} else {
					System.out.println("rentre ici 1");
					monPlateau.getCartes().get(ligne).get(colonne).cacher();
					monPlateau.getCartes().get(ligne2).get(colonne2).cacher();
				}
				joueurs.get(i).enAttente();
			}
		}
	}
}
