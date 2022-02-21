package fr.ensma.a3.ia.JeuMemoire.Cartes;

import fr.ensma.a3.ia.JeuMemoire.Plateau;

public interface ICarteMystere extends ICarte{
	public void effetSpecial();
	public Plateau getPlateau();
}
