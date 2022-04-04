package fr.ensma.a3.ia.JeuMemoire.Cartes;


import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import fr.ensma.a3.ia.JeuMemoire.JeuDeCartePleinException;
import fr.ensma.a3.ia.JeuMemoire.Partie;
import fr.ensma.a3.ia.JeuMemoire.PartieVideException;
import fr.ensma.a3.ia.JeuMemoire.Plateau;
import fr.ensma.a3.ia.JeuMemoire.Joueurs.JoueurPhysique;

@DisplayName("Test de la classe MelangeTout")
public class TestMelangeTout {
	private static MelangeTout mt;
	private static final Plateau monPlateau=new Plateau(2,2); 
	private static final Partie maPartie=new Partie(monPlateau,2,2);
	private static final JoueurPhysique monJoueur1=new JoueurPhysique("CJ","Benjamin","ben@gmail.com","ben",maPartie);
	private static final JoueurPhysique monJoueur2=new JoueurPhysique("CJ","Jacques","jacques@gmail.com","jack",maPartie);
	private static final CarteSimple maCarte=new CarteSimple("singe",monPlateau);
	private static final CarteSimple maCarte2=new CarteSimple("singe",monPlateau);
	private static final CarteSimple maCarte3=new CarteSimple("zebre",monPlateau);
	
	
	@BeforeAll
	public static void initAll() {
		mt=new MelangeTout(monPlateau,maPartie);
	
	}
	
	@Test
	@Order(1)
	public void testSimple() {
		assertTrue(monPlateau.getCartes().get(0).contains(mt));
		assertEquals(mt.getPlateau(),monPlateau);
		assertEquals(mt.getPartie(),maPartie);
	}
	
	@Test
	@Order(2)
	public void testGenereInt() {
		Integer temp=0;
		List<Integer> maListe=new ArrayList<Integer>();
		List<Integer> maListe2=new ArrayList<Integer>();
		for(int i=0;i<=10;i++) {
			maListe.add(i);
		}
		for(int i=0;i<100;i++) {
			temp=mt.genererInt(0, 11);
			assertTrue(maListe.contains(temp));
			maListe2.add(temp);
		}
		for(int i=0;i<maListe2.size();i++) {
			maListe.remove(maListe2.get(i));
		}
		assertEquals(maListe,new ArrayList<Integer>());
		System.out.println(monPlateau.getCartes().get(0).size());
	}
	
	@Test
	@Order(3)
	public void testListeAMelanger() {
		monPlateau.getCartes().get(0).get(0).afficher();
		monPlateau.getCartes().get(0).get(0).trouver();
		List<ICarte> maListe=mt.listeaMelanger();
		assertEquals(maListe.size(),3);
		assertFalse(maListe.contains(monPlateau.getCartes().get(0).get(0)));
		monPlateau.getCartes().get(0).get(1).afficher();
		monPlateau.getCartes().get(0).get(1).trouver();
		maListe=mt.listeaMelanger();
		assertEquals(maListe.size(),2);
		assertFalse(maListe.contains(monPlateau.getCartes().get(0).get(0))||maListe.contains(monPlateau.getCartes().get(0).get(1)));
	}
	//ne marche pas
	@Test
	@Order(4)
	public void testMelange() {
		Integer count=0;
		Plateau plateaucopie=new Plateau(2,2);
		try {
			plateaucopie.addCarte(maCarte);
			plateaucopie.addCarte(maCarte2);
			plateaucopie.addCarte(maCarte3);
			plateaucopie.addCarte(mt);
		} catch (JeuDeCartePleinException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<monPlateau.getCartes().size();i++) {
			for(int j=0;j<monPlateau.getCartes().get(i).size();j++) {
			assertEquals(plateaucopie.getCartes().get(i).get(j),monPlateau.getCartes().get(i).get(j));
		}
		}
		mt.effetSpecial();
		for(int i=0;i<monPlateau.getCartes().size();i++) {
			for(int j=0;j<monPlateau.getCartes().get(i).size();j++) {
			if(plateaucopie.getCartes().get(i).get(j)!=monPlateau.getCartes().get(i).get(j)) {
				count++;
			}
		}
			assertNotEquals(count,0);
		
	}
	}
	
	
}
