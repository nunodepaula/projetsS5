package fr.ensma.a3.ia.JeuMemoire.Cartes;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import fr.ensma.a3.ia.JeuMemoire.Partie;
import fr.ensma.a3.ia.JeuMemoire.PartiePleineException;
import fr.ensma.a3.ia.JeuMemoire.Plateau;
import fr.ensma.a3.ia.JeuMemoire.Joueurs.JoueurPhysique;

@DisplayName("Test de la classe DansTaFace")
public class TestDansTaFace {
	private static DansTaFace dtf;
	private static final Plateau monPlateau=new Plateau(2,2);
	private static final Partie maPartie=new Partie(monPlateau,2,1);
	private static final JoueurPhysique monJoueur1=new JoueurPhysique("CJ","Benjamin","ben@gmail.com","ben",maPartie);
	private static final JoueurPhysique monJoueur2=new JoueurPhysique("CJ","Jacques","jacques@gmail.com","jack",maPartie);
	private static final CarteSimple maCarte=new CarteSimple("singe",monPlateau);
	
	@BeforeAll
	public static void initAll() {
		dtf=new DansTaFace(monPlateau, maPartie);
		try {
			maPartie.ajouterJoueur(monJoueur1);
			maPartie.ajouterJoueur(monJoueur2);
		} catch (PartiePleineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@Order(1)
	public void testSimple() {
	assertTrue(monPlateau.getCartes().get(1).contains(dtf));
	assertEquals(dtf.getPlateau(),monPlateau);
	assertEquals(dtf.getPartie(),maPartie);
	}
	@Test
	@Order(2)
	public void testPerdreTous() {
	List<ICarte> maListe=new ArrayList<ICarte>();
	maCarte.afficher();
	maCarte.trouver();
	monJoueur1.aTontour();
	monJoueur1.addCarteGagne(maCarte);
	monJoueur1.setScore(1);
	dtf.effetSpecial();
	assertEquals(monJoueur1.getScore(),0);
	assertEquals(maCarte.getEtatCourant(),maCarte.getCacher());
	}
}
