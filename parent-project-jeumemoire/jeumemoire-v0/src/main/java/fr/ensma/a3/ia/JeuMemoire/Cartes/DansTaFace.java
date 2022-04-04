package fr.ensma.a3.ia.JeuMemoire.Cartes;

import java.util.List;

import fr.ensma.a3.ia.JeuMemoire.Partie;
import fr.ensma.a3.ia.JeuMemoire.Plateau;
import fr.ensma.a3.ia.JeuMemoire.Joueurs.AJoueur;
/**
 *Definition de la carte magique dans ta face
 */
public class DansTaFace extends ACarteMagique {
	public DansTaFace(Plateau monPlateau,Partie maPartie) {
		super("MagiqueDansTaFace",monPlateau,maPartie);
	}

	@Override
	public void effetSpecial() {
		this.perdreTous();
	}
/**
 * Effet de la carte,supprime les carte gagnées par le joueur et les remets en jeu 
 */
	public void perdreTous() {
		System.out.println("Carte Dans Ta face trouve");
		System.out.println(this.getPartie().getJoueurs().size());
		for(int i=0;i<this.getPartie().getJoueurs().size();i++) {
			if(((this.getPartie().getJoueurs().get(i).getEtatCourant())==(this.getPartie().getJoueurs().get(i).getEtatPremierTirage())||(this.getPartie().getJoueurs().get(i).getEtatCourant())==(this.getPartie().getJoueurs().get(i).getEtatSecondTirage()))) {
				this.getPartie().getJoueurs().get(i).setScore(0);
				for(int j=0;j<this.getPartie().getJoueurs().get(i).getCarteGagne().size();j++) {
					this.getPartie().getJoueurs().get(i).getCarteGagne().get(j).cacher();
				}
			}
		}
	}
}
