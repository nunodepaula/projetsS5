package fr.ensma.a3.ia.JeuMemoire.Cartes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import fr.ensma.a3.ia.JeuMemoire.Partie;
import fr.ensma.a3.ia.JeuMemoire.Plateau;
import fr.ensma.a3.ia.JeuMemoire.Joueurs.JoueurPhysique;

@DisplayName("Test de la classe Revele Tout")
public class TestReveleTout {
	private static ReveleTout rvltout;
	private static final Plateau monPlateau=new Plateau(2,2); 
	private static final Partie maPartie=new Partie(monPlateau,2,2);
	private static final CarteSimple maCarte=new CarteSimple("singe",monPlateau);
	private static final CarteSimple maCarte2=new CarteSimple("singe",monPlateau);
	private static final CarteSimple maCarte3=new CarteSimple("zebre",monPlateau);

	@BeforeAll
	public static void initAll() {
		rvltout=new ReveleTout(monPlateau,maPartie);
	}
	
	@Test
	@Order(1)
	public void testSimple() {
		assertEquals(rvltout.getPlateau(), monPlateau);
		assertEquals(rvltout.getPartie(),maPartie);
	}
	
	@Test
	@Order(2)
	public void testReveleTout() {
		rvltout.effetSpecial();
		for(int i=0;i<monPlateau.getCartes().size();i++) {
			for(int j=0;j<monPlateau.getCartes().get(i).size();j++) {
				ACarte maCarte=(ACarte) monPlateau.getCartes().get(i).get(j);
				assertEquals(maCarte.getEtatCourant(),maCarte.getAfficher());
			}
		}
	}
	
}
