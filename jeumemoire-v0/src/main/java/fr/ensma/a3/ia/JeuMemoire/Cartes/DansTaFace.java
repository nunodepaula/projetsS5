package fr.ensma.a3.ia.JeuMemoire.Cartes;

public class DansTaFace extends ACarteMagique{
	public DansTaFace(ICarteMystere maCarteMystere) {
		super(maCarteMystere);
	}
	@Override
	public void effetSpecial() {
		super.effetSpecial();
		this.perdreTous();
	}
	public void perdreTous() {
		
	}
	
}
