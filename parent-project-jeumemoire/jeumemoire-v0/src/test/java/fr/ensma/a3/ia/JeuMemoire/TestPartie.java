package fr.ensma.a3.ia.JeuMemoire;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.hamcrest.core.IsInstanceOf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.InstanceOf;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.ensma.a3.ia.JeuMemoire.Cartes.ACarteMagique;
import fr.ensma.a3.ia.JeuMemoire.Cartes.CarteSimple;
import fr.ensma.a3.ia.JeuMemoire.Joueurs.AJoueur;
import fr.ensma.a3.ia.JeuMemoire.Joueurs.JoueurPhysique;
import fr.ensma.a3.ia.JeuMemoire.Joueurs.automateJoueurs.EnAttente;
import fr.ensma.a3.ia.JeuMemoire.Joueurs.automateJoueurs.PremierTirage;
import fr.ensma.a3.ia.JeuMemoire.Joueurs.automateJoueurs.SecondTirage;
@ExtendWith(MockitoExtension.class)
@DisplayName("Tests de la classe Partie")
public class TestPartie {
	private static Partie partieTest;
	private static final Integer nbJoueur = 2;
	private static final Integer mode = 1;
	private static final Integer mode2 = 2;
	private static final Plateau monPlateau = new Plateau(4, 4);
	private static final Plateau monPlateau2 = new Plateau(7, 7);
	private static final Plateau monPlateau3 = new Plateau(10, 10);
	@Mock
	AJoueur joueur1, joueur2, joueur3;
	@Mock
	Plateau plateau;
	@Mock
	CarteSimple uneCarte,autreCarte;
	@Mock
	ACarteMagique uneCarteM;
	@Mock
	PremierTirage monTirage;
	@Mock
	SecondTirage secondTirage;
	@Mock 
	EnAttente attente;
	@BeforeAll
	public static void initAll() {
		partieTest = new Partie(monPlateau, nbJoueur, mode);
	}

	@Test
	@Order(1)
	public void testSimple() {
		assertAll("Etat instance non conforme", () -> assertEquals(partieTest.getPlateau(), monPlateau),
				() -> assertTrue(partieTest.getNbJoueurs().equals(nbJoueur)),
				() -> assertEquals(mode, partieTest.getMode()),
				() -> assertThrows(NullPointerException.class, () -> {new Partie(null,nbJoueur,mode);}),
				() -> assertThrows(NullPointerException.class, () -> {new Partie(monPlateau,null,mode);}),
				() -> assertThrows(NullPointerException.class, () -> {new Partie(monPlateau,nbJoueur,null);}));
	}

	@Test
	@Order(2)
	public void testAjoutJoueur() {
		try {
			assertEquals(partieTest.getJoueurs().size(), 0);
			partieTest.ajouterJoueur(joueur1);
			assertEquals(partieTest.getJoueurs().size(), 1);
			partieTest.ajouterJoueur(joueur2);
			assertEquals(partieTest.getJoueurs().size(), 2);
			assertThrows(PartiePleineException.class, () -> partieTest.ajouterJoueur(joueur3));
		} catch (PartiePleineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@Order(3)
	public void testSuppJoueur() {
		try {
			assertEquals(partieTest.getJoueurs().size(), 2);
			partieTest.suppJoueur();
			assertEquals(partieTest.getJoueurs().size(), 1);
			partieTest.suppJoueur();
			assertEquals(partieTest.getJoueurs().size(), 0);
			assertThrows(PartieVideException.class, () -> partieTest.suppJoueur());
		} catch (PartieVideException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@Order(4)
	public void testInitPartie() {
		Integer countCarteSimple = 0;
		Integer countCarteMagique = 0;
		Partie partieTest1 = new Partie(monPlateau, nbJoueur, mode);
		try {
			assertThrows(PartieVideException.class, () -> partieTest1.initPartie());
			try {
				partieTest1.ajouterJoueur(joueur1);
			} catch (PartiePleineException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			partieTest1.initPartie();
		} catch (PartieVideException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(partieTest1.getNbPaires(), 6);
		for (int i = 0; i < monPlateau.getCartes().size(); i++) {
			for (int j = 0; j < monPlateau.getCartes().get(i).size(); j++) {
				if (monPlateau.getCartes().get(i).get(j) instanceof ACarteMagique) {
					countCarteMagique++;
				}
				if (monPlateau.getCartes().get(i).get(j) instanceof CarteSimple) {
					countCarteSimple++;
				}
			}
		}
		assertEquals(countCarteMagique, 4);
		assertEquals(countCarteSimple, partieTest1.getNbPaires() * 2);
		countCarteSimple = 0;
		countCarteMagique = 0;
		Partie partieTest2 = new Partie(monPlateau2, nbJoueur, mode);
		try {
			partieTest2.ajouterJoueur(joueur1);
		} catch (PartiePleineException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			partieTest2.initPartie();
		} catch (PartieVideException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(partieTest2.getNbPaires(), 20);
		for (int i = 0; i < monPlateau2.getCartes().size(); i++) {
			for (int j = 0; j < monPlateau2.getCartes().get(i).size(); j++) {
				if (monPlateau2.getCartes().get(i).get(j) instanceof ACarteMagique) {
					countCarteMagique++;
				}
				if (monPlateau2.getCartes().get(i).get(j) instanceof CarteSimple) {
					countCarteSimple++;
				}
			}
		}
		assertEquals(countCarteMagique, 9);
		assertEquals(countCarteSimple, partieTest2.getNbPaires() * 2);
		countCarteMagique = 0;
		countCarteSimple = 0;
		Partie partieTest3 = new Partie(monPlateau3, nbJoueur, mode);
		try {
			partieTest3.ajouterJoueur(joueur1);
		} catch (PartiePleineException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			partieTest3.initPartie();
		} catch (PartieVideException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(partieTest3.getNbPaires(), 30);
		for (int i = 0; i < monPlateau3.getCartes().size(); i++) {
			for (int j = 0; j < monPlateau3.getCartes().get(i).size(); j++) {
				if (monPlateau3.getCartes().get(i).get(j) instanceof ACarteMagique) {
					countCarteMagique++;
				}
				if (monPlateau3.getCartes().get(i).get(j) instanceof CarteSimple) {
					countCarteSimple++;
				}
			}
		}
		assertEquals(countCarteMagique, 40);
		assertEquals(countCarteSimple, partieTest3.getNbPaires() * 2);
	}

	@Test
	@Order(5)
	public void testAction() {
		assertEquals(partieTest.getJoueurs().size(),2);
		when(uneCarte.getId()).thenReturn("singe");
		when(joueur1.tirerCarte(anyInt(),anyInt())).thenReturn(uneCarte);
		assertEquals(partieTest.Action(joueur1,0,0),"singe");
		verify(uneCarte,Mockito.times(2)).getId();
		verify(joueur1).tirerCarte(0,0);
		verify(joueur1,Mockito.times(1)).addCarteGagne(uneCarte);
		
		when(uneCarteM.getId()).thenReturn("Magique");
		when(joueur2.getEtatCourant()).thenReturn(monTirage);
		when(joueur2.getEtatSecondTirage()).thenReturn(secondTirage);
		when(joueur2.tirerCarte(anyInt(),anyInt())).thenReturn(uneCarteM);
		assertEquals(partieTest.Action(joueur2,1,1),"Magique");
		verify(joueur2,Mockito.times(1)).tirerCarte(1,1);
		verify(uneCarteM,Mockito.times(2)).getId();
		verify(uneCarteM,Mockito.times(1)).effetSpecial();
		verify(joueur2,Mockito.times(1)).getEtatCourant();
		verify(joueur2,Mockito.times(1)).getEtatSecondTirage();
		verify(joueur2,Mockito.times(1)).secondTirage();
	}
	
	@Test
	@Order(6)
	public void testAuJoueurSuivant() {
		assertEquals(partieTest.getJoueurs().size(),2);
		try {
			partieTest.suppJoueur();
			partieTest.suppJoueur();
			System.out.println("test num1"+partieTest.getJoueurs().size());
		} catch (PartieVideException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			partieTest.ajouterJoueur(joueur1);
			partieTest.ajouterJoueur(joueur2);
		} catch (PartiePleineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		when(joueur1.getEtatCourant()).thenReturn(secondTirage);
		when(joueur1.getEtatSecondTirage()).thenReturn(secondTirage);
		when(joueur2.getEtatCourant()).thenReturn(attente);
		when(joueur2.getEtatSecondTirage()).thenReturn(secondTirage);
		partieTest.auJoueurSuivant("cacher");
		verify(joueur1,Mockito.times(1)).enAttente();
		verify(joueur2,Mockito.times(1)).aTontour();
		verify(joueur2,Mockito.never()).enAttente();
		verify(joueur1,Mockito.never()).aTontour();
		
		when(joueur1.getEtatCourant()).thenReturn(attente);
		when(joueur1.getEtatSecondTirage()).thenReturn(secondTirage);
		when(joueur2.getEtatCourant()).thenReturn(secondTirage);
		when(joueur2.getEtatSecondTirage()).thenReturn(secondTirage);
		partieTest.auJoueurSuivant("cacher");
		verify(joueur2,Mockito.times(1)).enAttente();
		verify(joueur1,Mockito.times(1)).aTontour();
		verify(joueur2,Mockito.times(1)).aTontour();
		verify(joueur1,Mockito.times(1)).enAttente();
		
		when(joueur1.getEtatCourant()).thenReturn(secondTirage);
		when(joueur1.getEtatSecondTirage()).thenReturn(secondTirage);
		when(joueur2.getEtatCourant()).thenReturn(attente);
		when(joueur2.getEtatSecondTirage()).thenReturn(secondTirage);
		partieTest.auJoueurSuivant("trouver");
		verify(joueur1,Mockito.times(2)).enAttente();
		verify(joueur1,Mockito.times(2)).aTontour();
		verify(joueur2,Mockito.times(1)).enAttente();
		verify(joueur2,Mockito.times(1)).aTontour();
	}
	
}
