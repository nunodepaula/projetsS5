package fr.ensma.a3.ia.JeuMemoire.Cartes;

import fr.ensma.a3.ia.JeuMemoire.Partie;
import fr.ensma.a3.ia.JeuMemoire.Plateau;
/**
 *Définition de la carte ReveleTout
 */
public class ReveleTout extends ACarteMagique {
	public ReveleTout(Plateau monPlateau,Partie maPartie) {
		super("MagiqueReveleTout",monPlateau,maPartie);
	}

	@Override
	public void effetSpecial() {
		afficherTous();
	}
    /**
     * Place toutes les cartes du plateau de l'état cacher à l'état affficher
     */
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
