package fr.ensma.a3.ia.JeuMemoire.Cartes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.ensma.a3.ia.JeuMemoire.Plateau;

public class MelangeTout extends ACarteMagique {

	public MelangeTout(Plateau monPlateau) {
		super("MagiqueMelangeTout", monPlateau);
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
	private List<ICarte> listeaMelanger(){
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
	
	private void remplissage(List<ICarte> mesCartes) {
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

