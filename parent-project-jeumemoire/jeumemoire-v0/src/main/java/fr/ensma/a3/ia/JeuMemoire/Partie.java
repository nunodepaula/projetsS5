/**
* 
*/
package fr.ensma.a3.ia.JeuMemoire;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
 *Définition d'une partie de jeu du Memory
 */


public class Partie {

	private List<AJoueur> joueurs;
	private Plateau monPlateau;
	private Integer gagnerPartie;
	private Integer nbJoueur;
	private Integer nbpaires;
	private Integer mode;

	/**Obtient une instance de partie 
	 * @param {@link Plateau} le plateau sur lequel se déroule la partie
	 * @param nbJoueur nombre de joueur dans la partie
	 * @param mode le mode de difficulté choisie
	 */
	public Partie(Plateau monPlateau, Integer nbJoueur, Integer mode) {
		gagnerPartie = 0;
		this.monPlateau = Objects.requireNonNull(monPlateau);
		joueurs = new ArrayList<AJoueur>();
		this.nbJoueur = Objects.requireNonNull(nbJoueur);
		this.mode = Objects.requireNonNull(mode);
	}


	/**
	 * initialise la partie, instanciation des cartes simples et magiques,le premier joueur commence la partie
	 */
	public void initPartie() throws PartieVideException{
		if (this.monPlateau.getnbLignes()==4) {
			nbpaires=6;
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
			ReveleTout  carte13=new ReveleTout(this.getPlateau(),this);
			DansTaFace carte14=new DansTaFace(this.getPlateau(),this);
			MelangeTout carte15=new MelangeTout(monPlateau,this);
			MelangeTout carte16=new MelangeTout(monPlateau,this);
		}
		if (this.monPlateau.getnbLignes()==7) {
			nbpaires=20;
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
			if(this.mode==1) {
				ReveleTout  carte41=new ReveleTout(this.getPlateau(),this);
				DansTaFace carte42=new DansTaFace(this.getPlateau(),this);
				MelangeTout carte43=new MelangeTout(monPlateau,this);
				ReveleTout  carte44=new ReveleTout(this.getPlateau(),this);
				ReveleTout  carte45=new ReveleTout(this.getPlateau(),this);
				ReveleTout  carte46=new ReveleTout(this.getPlateau(),this);
				ReveleTout  carte47=new ReveleTout(this.getPlateau(),this);
				DansTaFace carte48=new DansTaFace(this.getPlateau(),this);
				MelangeTout carte49=new MelangeTout(this.getPlateau(),this);
			}
			if(this.mode==2) {
				ReveleTout  carte41=new ReveleTout(this.getPlateau(),this);
				DansTaFace carte42=new DansTaFace(this.getPlateau(),this);
				MelangeTout carte43=new MelangeTout(monPlateau,this);
				DansTaFace  carte44=new DansTaFace(this.getPlateau(),this);
				DansTaFace  carte45=new DansTaFace(this.getPlateau(),this);
				DansTaFace  carte46=new DansTaFace(this.getPlateau(),this);
				DansTaFace  carte47=new DansTaFace(this.getPlateau(),this);
				ReveleTout carte48=new ReveleTout(this.getPlateau(),this);
				MelangeTout carte49=new MelangeTout(this.getPlateau(),this);
			}
		}
		if (this.monPlateau.getnbLignes()==10) {
			nbpaires=30;
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
			if(this.mode==1) {
				for(int i=0;i<=19;i++) {
					ReveleTout revel=new ReveleTout(this.monPlateau,this);
				}
				for(int i=0;i<=9;i++) {
					DansTaFace dtf=new DansTaFace(monPlateau, this);
				}
				for(int i=0;i<=9;i++) {
					MelangeTout mt=new MelangeTout(monPlateau,this);
				}
			}
			if(this.mode==2) {
				for(int i=0;i<=19;i++) {
					DansTaFace revel=new DansTaFace(this.monPlateau,this);
				}
				for(int i=0;i<=9;i++) {
					ReveleTout dtf=new ReveleTout(monPlateau, this);
				}
				for(int i=0;i<=9;i++) {
					MelangeTout mt=new MelangeTout(monPlateau,this);
				}
			}
		}
		if(joueurs.size()>0) {
		this.joueurs.get(0).aTontour();
		}
		else {
			throw new PartieVideException("La partie est vide...");
		}
	}
	
	/**
	 * représente l'action d'un joueur pour tirer une carte
	 * @return l'identifiant de la carte tiré par le joueur
	 * @param {@link AJoueur} unjoueur le joueur qui tire la carte
	 * @param colonne la colonne dans laquelle le joueur tire la carte
	 * @param ligne la ligne dans laquelle le joueur tire la carte
	 */
	public String Action(AJoueur unjoueur, int colonne, int ligne) {
		String valeur;
		ICarte maCarte;
		maCarte = unjoueur.tirerCarte(colonne, ligne);
		if(!maCarte.getId().contains("Magique")) {
		unjoueur.addCarteGagne(maCarte);
		}
		valeur = maCarte.getId();
		if (maCarte instanceof ICarteMystere) {
			ICarteMystere maCarteMagique = (ICarteMystere) maCarte;
			maCarteMagique.effetSpecial();
			if (unjoueur.getEtatCourant() != unjoueur.getEtatSecondTirage()) {
				unjoueur.secondTirage();
				auJoueurSuivant("cacher");
			}
		}
		return valeur;
	}
	
	/**
	 * Détermine si a la fin du second tour les deux cartes tirées par le joueur sont les mêmes
	 * @return string qui indique le résultat de la comparaison
	 * @param {@link AJoueur} unjoueur le joueur qui est en train de jouer
	 */
	public String test(AJoueur unjoueur) {
		String valeur;
		if(unjoueur.getCarteGagne().size()%2==0) {
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
		}
		}
		else {
			valeur="cacher";
			unjoueur.getCarteGagne().get(unjoueur.getCarteGagne().size() - 1).cacher();
			unjoueur.getCarteGagne().remove(unjoueur.getCarteGagne().size() - 1);
		}
			return valeur;
		}
	
	/**
	 * Détermine si toutes les cartes ont étés trouvés à la fin du tour d'un joueur
	 * @return le booléen qui indique si la partie est terminé
	 */
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
	/**
	 * Détermine les cartes à réintégrer dans le jeu
	 * @return liste des cartes à réintégrer dans la partie
	 * @param {@link AJoueur} joueur joueur dont le tour est en train de se dérouler
	 */
	public List<Integer> reaffichage(AJoueur joueur){
		List<Integer> coordonneCarteReafficher=new ArrayList<Integer>();
		System.out.println(joueur.getCarteGagne().size());
		for(int a=0;a<joueur.getCarteGagne().size()-1;a=a+2) {
			ICarte maCarte=joueur.getCarteGagne().get(a);
			System.out.println(maCarte.getId());
				for(int i=0;i<this.getPlateau().getCartes().size();i++) {
				for(int j=0;j<this.getPlateau().getCartes().get(i).size();j++) {
					if (maCarte.getId().compareTo(this.getPlateau().getCartes().get(i).get(j).getId())==0) {
						System.out.println(i);
						System.out.println(j);
						coordonneCarteReafficher.add(i);
						coordonneCarteReafficher.add(j);
				}
			}
		}
		}
		joueur.resetCarteGagne();
		return coordonneCarteReafficher;
	}
	/**
	 * Passe le tour de jeu au joueur suivant
	 * @param valeur résultat de la fonction test 
	 */
	public void auJoueurSuivant(String valeur) {
		if (valeur == "cacher") {
			for (int i = 0; i < joueurs.size(); i++) {
				if (joueurs.get(i).getEtatCourant() == joueurs.get(i).getEtatSecondTirage()) {
					joueurs.get(i).enAttente();
					if (i == this.nbJoueur - 1) {
						System.out.println("interaction 111");
						joueurs.get(0).aTontour();
					} else {
						System.out.println("interaction 222");
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
	/**
	 * Joueurs se trouvant dans la partie
	 * @return la liste des joueurs dans la partie
	 */
	public List<AJoueur> getJoueurs() {
		return joueurs;
	}
	/**
	 * renvoie le nombre de joueurs dans la partie
	 * @return nombre de joueurs dans la partie
	 */
	public Integer getNbJoueurs() {
		return nbJoueur;
	}
	/**
	 * Renvoie le mode de difficulté
	 * @return le mode de difficulté
	 */
	public Integer getMode() {
		return mode;
	}
	
	/**
	 * Ajoute un joueur dans la partie
	 * Entraine : ajout d'un joueur si nbJoueur> nombre de joueurs dans la partie, PartiePleineException sinon
	 * @param j joueur à ajouter dans la partie
	 */
	public void ajouterJoueur(AJoueur j) throws PartiePleineException{
		if (joueurs.size() < nbJoueur) {
			joueurs.add(j);
			j.setPartie(this);
		} else {
			throw new PartiePleineException("La partie est pleine");
		}
	}
	/**
	 * supprime un joueur de la partie
	 */
	public void suppJoueur() throws PartieVideException{
		if (joueurs.size() == 0) {
			throw new PartieVideException("La partie est vide");	
		}
		else {
			System.out.println(joueurs.remove(joueurs.size()-1));
			System.out.println("Joueurs supprimé !!");
			System.out.println(joueurs.size());
		}
	}
	/**
	 * nombre de paires contenu dans le jeu initialiser lors de initPartie
	 * @return le nbpaires
	 */
	public Integer getNbPaires() {
		return nbpaires;
	}
	
	//pas utiliser 
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
	//pas utiliser
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
	/**
	 * Renvoie le plateau de jeu
	 * @return {@link Plateau} le plateau de jeu
	 */
	public Plateau getPlateau() {
		return monPlateau;
	}
	
	/**
	 * Recupere une carte dans le jeu
	 * @return l'identifiant de la carte
	 * @param i la ligne la de la carte correspondante
	 * @param j la colonne de la carte correspondante
	 */
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
		
	
	//pas utiliser
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
