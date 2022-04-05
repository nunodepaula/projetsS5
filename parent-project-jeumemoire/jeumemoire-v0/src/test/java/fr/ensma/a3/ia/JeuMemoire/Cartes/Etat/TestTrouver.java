package fr.ensma.a3.ia.JeuMemoire.Cartes.Etat;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import fr.ensma.a3.ia.JeuMemoire.Plateau;
import fr.ensma.a3.ia.JeuMemoire.Cartes.CarteSimple;
import fr.ensma.a3.ia.JeuMemoire.Cartes.Etat.Cacher;
import fr.ensma.a3.ia.JeuMemoire.Cartes.Etat.TransitionNonTirableException;
import fr.ensma.a3.ia.JeuMemoire.Cartes.Etat.Trouver;

@DisplayName("Test de la classe Trouver")
public class TestTrouver {
	private static Trouver trouver;
	private static final Plateau monPlateau=new Plateau(4,4);
	private static final CarteSimple maCarte=new CarteSimple("singe",monPlateau);
	@BeforeEach
	public void InitEach() {
		trouver=new Trouver(maCarte);
	}
	
	@Test
	@Order(1)
	public void TestSimple() {
		assertThrows(TransitionNonTirableException.class, () -> trouver.trouver());
		assertThrows(TransitionNonTirableException.class, () -> trouver.afficher());
	}
	
}
