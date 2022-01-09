package fr.ensma.a3.ia.JeuMemoire.Cartes.Etat;

import fr.ensma.a3.ia.JeuMemoire.Cartes.ACarte;

public abstract class AEtatCarte implements IEtatCarte{
	
	protected ACarte uneCarte;
	@Override
	public void afficher() throws TransitionNonTirableException {
		throw new TransitionNonTirableException();
	}

	@Override
	public void cacher() throws TransitionNonTirableException {
		throw new TransitionNonTirableException();		
	}
	
	@Override
	public void trouver() throws TransitionNonTirableException {
		throw new TransitionNonTirableException();
	}
	@Override
	public void remettreEnJeu() throws TransitionNonTirableException {
		throw new TransitionNonTirableException();
	}
}
