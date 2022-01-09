package fr.ensma.a3.ia.JeuMemoire.Cartes;

public abstract class ACarteMagique implements ICarteMystere{
	private ICarteMystere carteMystere;
	public ACarteMagique(ICarteMystere macarteMystere) {
		carteMystere=macarteMystere;
	}
	@Override
	public void effetSpecial() {
		carteMystere.effetSpecial();
	}
	@Override
	public Plateau getPlateau() {
		return carteMystere.getPlateau();
	}
}
