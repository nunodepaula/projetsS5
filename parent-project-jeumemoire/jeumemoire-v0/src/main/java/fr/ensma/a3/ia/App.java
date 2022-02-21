package fr.ensma.a3.ia;

import fr.ensma.a3.ia.JeuMemoire.BaseJeu;
import fr.ensma.a3.ia.JeuMemoire.Partie;
import fr.ensma.a3.ia.JeuMemoire.Plateau;
import fr.ensma.a3.ia.JeuMemoire.Cartes.CarteSimple;
import fr.ensma.a3.ia.JeuMemoire.Cartes.ICarteMystere;
import fr.ensma.a3.ia.JeuMemoire.Cartes.MelangeTout;
import fr.ensma.a3.ia.JeuMemoire.Cartes.ReveleTout;
import fr.ensma.a3.ia.JeuMemoire.Joueurs.JoueurPhysique;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		Plateau monPlateau = new Plateau(3, 3);
		CarteSimple carte1A = new CarteSimple("A", monPlateau);
		CarteSimple carte2A = new CarteSimple("A", monPlateau);
		CarteSimple carte1B = new CarteSimple("B", monPlateau);
		CarteSimple carte2B = new CarteSimple("B", monPlateau);
		CarteSimple carte1C = new CarteSimple("C", monPlateau);
		CarteSimple carte2C = new CarteSimple("C", monPlateau);
		CarteSimple carte1D = new CarteSimple("D", monPlateau);
		CarteSimple carte2D = new CarteSimple("D", monPlateau);
		ICarteMystere monmelange = new MelangeTout(monPlateau);
		BaseJeu mabase=new BaseJeu(3,9);
		//Partie maPartie=new Partie(mabase,monPlateau);
	//	JoueurPhysique joueur1=new JoueurPhysique("Dupond","Jacques","jacques@hotmail.fr","jacques",maPartie);
		//JoueurPhysique joueur2=new JoueurPhysique("Leponge","Bob","bob@hotmail.fr","bob",maPartie);
		//maPartie.lancerPartie();

	}
}
