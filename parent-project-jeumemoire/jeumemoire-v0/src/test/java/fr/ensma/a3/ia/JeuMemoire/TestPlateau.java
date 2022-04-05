package fr.ensma.a3.ia.JeuMemoire;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.ensma.a3.ia.JeuMemoire.Cartes.CarteSimple;
import fr.ensma.a3.ia.JeuMemoire.Cartes.ICarte;
import fr.ensma.a3.ia.JeuMemoire.Joueurs.JoueurPhysique;

@ExtendWith(MockitoExtension.class)
@DisplayName("Tests de la classe Plateau")
public class TestPlateau {
	private static Plateau plateauTest;
	private static final Integer nbLigne = 2;
	private static final Integer nbColonne = 2;
	@Mock
	ICarte uneCarte;

	@BeforeEach
	public void initAll() {
		plateauTest = new Plateau(nbLigne, nbColonne);
	}

	@Test
	@Order(1)
	public void testSimple() {
		assertAll("Etat instance non conforme", () -> assertEquals(plateauTest.getnbLignes(), nbLigne),
				() -> assertEquals(plateauTest.getnbColonnes(), nbColonne),
				() -> assertEquals(plateauTest.getCartes().size(), nbLigne),
				() -> assertThrows(NullPointerException.class, () -> {new Plateau(null,nbColonne);}),
				() -> assertThrows(NullPointerException.class, () -> {new Plateau(nbLigne,null);}));
	}

	@Test
	@Order(2)
	public void testAddCarte() {
		assertEquals(plateauTest.getCartes().size(), nbLigne);
		for (int i = 0; i < nbLigne; i++) {
			assertEquals(plateauTest.getCartes().get(i).size(), 0);
		}
		for (int i = 0; i < nbLigne; i++) {
			for (int j = 0; j < nbColonne; j++) {
				try {
					plateauTest.addCarte(uneCarte);
				} catch (JeuDeCartePleinException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		assertEquals(plateauTest.getCartes().size(), nbLigne);
		for (int i = 0; i < nbLigne; i++) {
			assertEquals(plateauTest.getCartes().get(i).size(), nbColonne);
		}
		try {
			plateauTest.addCarte(uneCarte);
		} catch (JeuDeCartePleinException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(plateauTest.getCartes().size(), nbLigne);
		for (int i = 0; i < nbLigne; i++) {
			assertEquals(plateauTest.getCartes().get(i).size(), nbColonne);
		}

	}

	@Test
	@Order(3)
	public void testRemoveCarte() {
		for (int i = 0; i < nbLigne; i++) {
			for (int j = 0; j < nbColonne; j++) {
				try {
					plateauTest.addCarte(uneCarte);
				} catch (JeuDeCartePleinException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		assertEquals(plateauTest.getCartes().size(), nbLigne);
		for (int i = 0; i < nbLigne; i++) {
			assertEquals(plateauTest.getCartes().get(i).size(), nbColonne);
		}
		for (int i = 0; i < nbLigne; i++) {
			for (int j = 0; j < nbColonne; j++) {
				assertTrue(plateauTest.removeCarte(uneCarte));
				assertEquals(plateauTest.getCartes().get(i).size(),nbColonne-j-1);
			}
		}
		assertFalse(plateauTest.removeCarte(uneCarte));
		
	}
}
