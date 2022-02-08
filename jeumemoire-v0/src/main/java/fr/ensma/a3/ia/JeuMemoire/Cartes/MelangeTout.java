package fr.ensma.a3.ia.JeuMemoire.Cartes;

import java.util.List;
import java.util.Random;

import fr.ensma.a3.ia.JeuMemoire.Plateau;

public class MelangeTout extends ACarteMagique {

	public MelangeTout(Plateau monPlateau) {
		super("MelangeTout", monPlateau);
	}

	@Override
	public void effetSpecial() {
		melange();
	}

	int genererInt(int borneInf, int borneSup) {
		Random random = new Random();
		int nb;
		nb = borneInf + random.nextInt(borneSup - borneInf);
		return nb;
	}

	public void melange() {
		System.out.println("Carte Melange Tout trouve");
		for (int i = this.getPlateau().getnbLignes() - 1; i >= 0; i--) {
			for (int j = this.getPlateau().getnbColonnes() - 1; j >= 0; j--) {
				int aleatoireLigne = genererInt(0, this.getPlateau().getnbLignes() - 1);
				int aleatoireColonne = genererInt(0, this.getPlateau().getnbLignes() - 1);
				ICarte temp1 = this.getPlateau().getCartes().get(i).get(j);
				this.getPlateau().getCartes().get(i).set(j,
						this.getPlateau().getCartes().get(aleatoireLigne).get(aleatoireColonne));
				this.getPlateau().getCartes().get(aleatoireLigne).set(aleatoireColonne, temp1);
			}

		}
	}

}
