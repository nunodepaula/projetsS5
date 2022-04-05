package fr.ensma.a3.ia.JeuMemoire.Cartes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.ensma.a3.ia.JeuMemoire.Partie;
import fr.ensma.a3.ia.JeuMemoire.Plateau;
/**
 * Définition de la carte Mélange Tout
 * @author Jordan
 *
 */
public class MelangeTout extends ACarteMagique {
	/**
	 * Obtient une instance de Mélange Tout
	 * @param monPlateau
	 * @param maPartie
	 */
	public MelangeTout(Plateau monPlateau,Partie maPartie) {
		super("MagiqueMelangeTout", monPlateau,maPartie);
	}

	@Override
	public void effetSpecial() {
		melange();
	}
	/**
	 * Obtient un entier aléatoirement entre deux bornes
	 * @param borneInf
	 * @param borneSup
	 * @return
	 */
	int genererInt(int borneInf, int borneSup) {
		Random random = new Random();
		int nb;
		nb = borneInf + random.nextInt(borneSup - borneInf);
		return nb;
	}
	/**
	 * Récupère les cartes à mélanger (qui ne sont pas dans l'état trouver)
	 * @return Liste des cartes à mélanger
	 */
	public List<ICarte> listeaMelanger(){
		List<ICarte> maListeAMelanger=new ArrayList<ICarte>();
		for(int i=0;i<this.getPlateau().getCartes().size();i++) {
			for(int j=0;j<this.getPlateau().getCartes().get(i).size();j++) {
				ACarte maCarte=(ACarte) this.getPlateau().getCartes().get(i).get(j);
				if(maCarte.getEtatCourant()!=maCarte.getTrouver()) {
					maListeAMelanger.add(maCarte);
				}
			}
		}
		return maListeAMelanger;
	}
	/**
	 * Fonction chargé de reremplir les carte du plateau avec la liste précédente une fois qu'elle a été mélangé
	 * @param mesCartes 
	 */
	public void remplissage(List<ICarte> mesCartes) {
		int count=0;
		for(int i=0;i<this.getPlateau().getCartes().size();i++) {
			for(int j=0;j<this.getPlateau().getCartes().get(i).size();j++) {
				ACarte maCarte=(ACarte) this.getPlateau().getCartes().get(i).get(j);
				if(maCarte.getEtatCourant()!=maCarte.getTrouver()) {
					this.getPlateau().getCartes().get(i).set(j,mesCartes.get(count));
					count++;
				}
			}
	
	}
	}
	/**
	 * Fonction chargé de mélanger la liste obtenue par listeaMelanger et de les réinsérer dans le plateau 
	 */
	public void melange() {
		System.out.println("Carte Melange Tout trouve");
		List<ICarte> maListe=this.listeaMelanger();
		System.out.println(maListe.size());
		for (int i = maListe.size() - 1; i >= 0; i--) {
			System.out.println(i);
			int aleatoire=genererInt(0,i+1);
			ICarte tmp=maListe.get(i);
			maListe.set(i, maListe.get(aleatoire));
			maListe.set(aleatoire, tmp);
			}
		this.remplissage(maListe);
		}
	}

