package fr.ensma.a3.ia.JeuMemoire.Cartes;

import fr.ensma.a3.ia.JeuMemoire.Plateau;

public class ReveleTout extends ACarteMagique {
	public ReveleTout(Plateau monPlateau) {
		super("MagiqueReveleTout",monPlateau);
	}

	@Override
	public void effetSpecial() {
		afficherTous();
	}
    //a modifier et corriger
	public void afficherTous() {
		System.out.println("Carte Revele Tout trouve");
		for (int i = 0; i < this.getPlateau().getCartes().size(); i++) {
			for(int j=0;j<this.getPlateau().getCartes().get(i).size();j++) {
				ACarte carte=(ACarte) this.getPlateau().getCartes().get(i).get(j);
				if(carte.getEtatCourant()==carte.getCacher()) {
				this.getPlateau().getCartes().get(i).get(j).afficher();
				}
			}
		}
	}
}
