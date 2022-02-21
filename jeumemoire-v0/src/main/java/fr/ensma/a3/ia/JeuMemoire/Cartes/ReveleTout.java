package fr.ensma.a3.ia.JeuMemoire.Cartes;

public class ReveleTout extends ACarteMagique{
	public ReveleTout(ICarteMystere maCarteMystere) {
		super(maCarteMystere);
	}
	@Override
	public void effetSpecial() {
		super.effetSpecial();
		afficherTous();
	}
	public void afficherTous() {
	}
}
