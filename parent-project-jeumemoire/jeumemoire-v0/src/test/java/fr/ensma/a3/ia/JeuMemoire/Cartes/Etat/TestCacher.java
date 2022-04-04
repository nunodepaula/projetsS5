package fr.ensma.a3.ia.JeuMemoire.Cartes.Etat;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import fr.ensma.a3.ia.JeuMemoire.PartiePleineException;
import fr.ensma.a3.ia.JeuMemoire.Plateau;
import fr.ensma.a3.ia.JeuMemoire.Cartes.CarteSimple;
import fr.ensma.a3.ia.JeuMemoire.Cartes.Etat.Cacher;
import fr.ensma.a3.ia.JeuMemoire.Cartes.Etat.TransitionNonTirableException;

@DisplayName("Test de la classe Cacher")
public class TestCacher {
	private static Cacher cacher;
	private static final Plateau monPlateau=new Plateau(4,4);
	private static final CarteSimple maCarte=new CarteSimple("singe",monPlateau);
	
	@BeforeEach
	public void initEach() {
		cacher=new Cacher(maCarte);
	}
	
	@Test
	@Order(1)
	public void testSimple() {
		assertThrows(TransitionNonTirableException.class, () -> cacher.cacher());
		assertThrows(TransitionNonTirableException.class, () -> cacher.trouver());
	}
	
	
}
