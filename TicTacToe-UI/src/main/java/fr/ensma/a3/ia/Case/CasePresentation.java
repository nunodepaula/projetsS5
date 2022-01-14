/**
 * 
 */
package fr.ensma.a3.ia.Case;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alvaresn
 *
 */
public class CasePresentation {

	// Brouillon pour l'automate
	private String etatCroix = "croix";
	private String etatRond  = "rond";
	private String etatVide  = "vide";
	private String etatCourant = etatVide;
	
	private ICaseMediateur vue;
	private List<ICaseObserver> observeurs;
	
	/**
	 * 
	 */
	public CasePresentation() {		
		observeurs = new ArrayList<ICaseObserver>();
	}

	public void action() {
		if(etatCourant == etatVide) {
			etatCourant = etatCroix;
			vue.action(etatCroix);
		} else if(etatCourant == etatCroix) {
			etatCourant = etatRond;
			vue.action(etatRond);
		} else if(etatCourant == etatRond) {
			etatCourant = etatVide;
			vue.action(etatVide);
		}
		for(ICaseObserver obs: observeurs) {
			obs.actionEvent();
		}
	}
	
	public ICaseMediateur getMediateur() {
		return vue;
	}
	
	public void setMediateur(ICaseMediateur mediateur) {
		vue = mediateur;
	}
	
	public void addObserver(ICaseObserver obs) {
		observeurs.add(obs);
	}
}
