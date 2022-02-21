package fr.ensma.a3.ia.JeuMemoire.Cartes.Etat;

public interface IEtatCarte {
	public void afficher() throws TransitionNonTirableException;
	public void cacher() throws TransitionNonTirableException;
	public void trouver() throws TransitionNonTirableException;
	public void remettreEnJeu() throws TransitionNonTirableException;
}
