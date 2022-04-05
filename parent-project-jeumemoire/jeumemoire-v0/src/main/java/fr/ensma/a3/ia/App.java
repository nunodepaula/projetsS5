package fr.ensma.a3.ia;


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
		Integer a=5;
		System.out.println(System.identityHashCode(a));
		a.valueOf(126);
		System.out.println("Hello World!");
		System.out.println(System.identityHashCode(a));
		
		
	}
}
