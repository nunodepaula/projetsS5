package fr.ensma.a3.ia.Memoire.server;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.JeuMemoire.Joueurs.JoueurPhysique;

public class JoueurDB {

	private static List<JoueurPhysique> joueurs = new ArrayList<>();


	public static List<JoueurPhysique> getJoueurs() {
		return joueurs;
	}

	}
