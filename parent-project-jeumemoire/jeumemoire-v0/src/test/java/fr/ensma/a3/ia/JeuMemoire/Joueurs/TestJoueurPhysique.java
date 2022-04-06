package fr.ensma.a3.ia.JeuMemoire.Joueurs;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsInstanceOf;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.InstanceOf;

import fr.ensma.a3.ia.JeuMemoire.Cartes.Etat.*;
import fr.ensma.a3.ia.JeuMemoire.JeuDeCartePleinException;
import fr.ensma.a3.ia.JeuMemoire.Partie;
import fr.ensma.a3.ia.JeuMemoire.Plateau;
import fr.ensma.a3.ia.JeuMemoire.Cartes.ACarte;
import fr.ensma.a3.ia.JeuMemoire.Cartes.CarteSimple;
import fr.ensma.a3.ia.JeuMemoire.Cartes.ICarte;

@DisplayName("Test de la classe Joueur Physique")
public class TestJoueurPhysique {
	private static JoueurPhysique monJoueur;
	private static final Plateau monPlateau=new Plateau(1,1);
	private static final Partie maPartie=new Partie(monPlateau,2,1);
	private static final String nom="CJ";
	private static final String prenom="Benjamin";
	private static final String email="ben@gmail.com";
	private static final String pseudo="ben";
	private static final CarteSimple maCarte=new CarteSimple("singe",monPlateau);
	private static final CarteSimple maCarte1=new CarteSimple("singe",monPlateau);
	
	@BeforeAll
	public static void initAll() {
		monJoueur=new JoueurPhysique(nom,prenom,email,pseudo,maPartie);
	}
	
	@Test
	@Order(1)
	public void testSimple() {
		assertAll("Etat instance non conforme", () -> assertEquals(monJoueur.getPrenom(),prenom),
				() -> assertEquals(monJoueur.getNom(),nom),
				() -> assertEquals(monJoueur.getPseudo(),pseudo),
				() -> assertEquals(monJoueur.getEmail(),email),
				() -> assertEquals(monJoueur.getPartie(),maPartie),
				() -> assertEquals(monJoueur.getCarteGagne(),new ArrayList<ICarte>()),
				() -> assertEquals(monJoueur.getScore(),0),
				() -> assertEquals(monJoueur.getEtatCourant(),monJoueur.getEtatEnAttente()),
				() -> assertThrows(NullPointerException.class, () -> {new JoueurPhysique(nom,prenom,email,null,maPartie);}),
				() -> assertThrows(NullPointerException.class, () -> {new JoueurPhysique(nom,prenom,null,pseudo,maPartie);}),
				() -> assertThrows(NullPointerException.class, () -> {new JoueurPhysique(nom,null,email,pseudo,maPartie);}),
				() -> assertThrows(NullPointerException.class, () -> {new JoueurPhysique(null,prenom,email,pseudo,maPartie);}));
	}
	
	@Test
	@Order(2)
	public void testSetScore() {
		monJoueur.setScore(5);
		assertEquals(monJoueur.getScore(),5);
	}
	
	
	@Test
	@Order(3)
	public void testChangementEtat() {
		monJoueur.aTontour();
		assertEquals(monJoueur.getEtatCourant(),monJoueur.getEtatPremierTirage());
		monJoueur.secondTirage();
		assertEquals(monJoueur.getEtatCourant(),monJoueur.getEtatSecondTirage());
		monJoueur.enAttente();
		assertEquals(monJoueur.getEtatCourant(),monJoueur.getEtatEnAttente());
	}
	
	@Test
	@Order(4)
	public void testResetCartGagne() {
		assertEquals(monJoueur.getCarteGagne().size(),0);
		monJoueur.addCarteGagne(maCarte1);
		monJoueur.addCarteGagne(maCarte);
		assertEquals(monJoueur.getCarteGagne().size(),2);
		monJoueur.resetCarteGagne();
		assertEquals(monJoueur.getCarteGagne().size(),0);
	}
	
	@Test
	@Order(5)
	public void testTirerCarte() {
		try {
			monPlateau.addCarte(maCarte1);
		} catch (JeuDeCartePleinException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assertEquals(monPlateau.getCartes().get(0).get(0),monJoueur.tirerCarte(0,0));
		//assertTrue(maCarte1.getEtatCourant() instanceof Afficher);
	}

}
