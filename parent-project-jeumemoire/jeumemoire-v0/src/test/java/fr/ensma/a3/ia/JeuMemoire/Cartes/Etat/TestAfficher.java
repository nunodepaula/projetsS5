package fr.ensma.a3.ia.JeuMemoire.Cartes.Etat;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import fr.ensma.a3.ia.JeuMemoire.PartiePleineException;
import fr.ensma.a3.ia.JeuMemoire.Plateau;
import fr.ensma.a3.ia.JeuMemoire.Cartes.CarteSimple;
import fr.ensma.a3.ia.JeuMemoire.Cartes.Etat.Afficher;
import fr.ensma.a3.ia.JeuMemoire.Cartes.Etat.Cacher;
import fr.ensma.a3.ia.JeuMemoire.Cartes.Etat.TransitionNonTirableException;

@DisplayName("Tests de la classe Afficher")
public class TestAfficher {
	private static Afficher afficher;
	private static final Plateau monPlateau=new Plateau(4,4);
	private static final CarteSimple maCarte=new CarteSimple("singe",monPlateau);
	
	
	@BeforeAll
	public static void initAll() {
		afficher=new Afficher(maCarte);
	}
	
	@Test
	@Order(1)
	public void testAfficher() {
		assertThrows(TransitionNonTirableException.class, () -> afficher.afficher());
	}
		
}
