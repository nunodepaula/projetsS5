package fr.ensma.a3.ia.JeuMemoire.Cartes;

import java.util.List;

import fr.ensma.a3.ia.JeuMemoire.Plateau;
import fr.ensma.a3.ia.JeuMemoire.Joueurs.AJoueur;

public class DansTaFace extends ACarteMagique {
	public DansTaFace(Plateau monPlateau) {
		super("MagiqueDansTaFace",monPlateau);
	}

	@Override
	public void effetSpecial() {
		this.perdreTous();
	}

	public void perdreTous() {
		System.out.println("Carte Dans Ta face trouve");
		for(int i=0;i<this.getPlateau().getJoueur().size();i++) {
			if(((this.getPlateau().getJoueur().get(i).getEtatCourant())==(this.getPlateau().getJoueur().get(i).getEtatPremierTirage())||(this.getPlateau().getJoueur().get(i).getEtatCourant())==(this.getPlateau().getJoueur().get(i).getEtatSecondTirage()))) {
				this.getPlateau().getJoueur().get(i).setScore(0);
				for(int j=0;j<this.getPlateau().getJoueur().get(i).getCarteGagne().size();j++) {
					this.getPlateau().getJoueur().get(i).getCarteGagne().get(j).cacher();
				}
			}
		}
	
	}
}
