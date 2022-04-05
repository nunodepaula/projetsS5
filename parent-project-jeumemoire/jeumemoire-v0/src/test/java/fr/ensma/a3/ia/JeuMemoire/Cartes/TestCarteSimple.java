package fr.ensma.a3.ia.JeuMemoire.Cartes;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

import fr.ensma.a3.ia.JeuMemoire.PartiePleineException;
import fr.ensma.a3.ia.JeuMemoire.Plateau;
import fr.ensma.a3.ia.JeuMemoire.Cartes.Etat.IEtatCarte;
import fr.ensma.a3.ia.JeuMemoire.Cartes.Etat.TransitionNonTirableException;

@DisplayName("Tests de la classe Partie")
public class TestCarteSimple {
	private static CarteSimple maCarte;
	private static final String valeur="singe";
	private static final Plateau monPlateau=new Plateau(4,4);
	@Mock
	private IEtatCarte etat;
	@BeforeAll
	public static void initAll(){
	maCarte=new CarteSimple(valeur,monPlateau);
	}
	@Test
	@Order(1)
	public void testSimple() {
		assertAll("Etat instance non conforme", () -> assertEquals(maCarte.getId(),valeur),
				() -> assertEquals(maCarte.getPlateau(),monPlateau),
				() -> assertEquals(maCarte.getEtatCourant(),maCarte.getCacher()),
				() -> assertTrue(monPlateau.getCartes().get(3).contains(maCarte)));
	}
	
	@Test
	@Order(2)
	public void testChangementEtat() {
		assertEquals(maCarte.getEtatCourant(),maCarte.getCacher());
		maCarte.afficher();
		assertEquals(maCarte.getEtatCourant(),maCarte.getAfficher());
		maCarte.trouver();
		assertEquals(maCarte.getEtatCourant(),maCarte.getTrouver());
		maCarte.cacher();
		assertEquals(maCarte.getEtatCourant(),maCarte.getCacher());
		maCarte.afficher();
		assertEquals(maCarte.getEtatCourant(),maCarte.getAfficher());
		maCarte.cacher();
		assertEquals(maCarte.getEtatCourant(),maCarte.getCacher());

	}
	
	
	
}
