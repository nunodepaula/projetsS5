package fr.ensma.a3.ia.JeuMemoire.Cartes;

public class MelangeTout extends ACarteMagique{
	
	public MelangeTout(ICarteMystere maCarteMystere) {
		super(maCarteMystere);
	}
	@Override
	public void effetSpecial() {
		super.effetSpecial();
		melange();
	}
	
	public void melange() {
		
	}
}
