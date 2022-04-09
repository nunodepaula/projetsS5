/**
 * 
 */
package fr.ensma.a3.ia.entrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author nunod
 *
 */
public class EntreesPresentation {

	private IEntreesMediateur entreesVue;
	private List<IEntreesObserver> observeurs;
	
	private String sectionTitle;
	
	private HashMap<String, Integer> composIndices;
	
	/**
	 * Constructeurs pour la Présentation du composant Entrées
	 */
	public EntreesPresentation(String section, List<String> composEntrees) {
		// Titre de la section d'entrées
		sectionTitle = section;
		
		observeurs = new ArrayList<IEntreesObserver>();
		
		// Enregistrement du vecteur des composants dans un HashMap
		composIndices = new HashMap<String,Integer>(); 
		for(int i = 0; i < composEntrees.size(); i++) {
			composIndices.put(composEntrees.get(i), i);
		}
	}
	
	public void setMediateur(IEntreesMediateur mediateur) {
		entreesVue = mediateur;
		entreesVue.ajouterChamps(composIndices);
	}
	
	public String getSection() {
		return sectionTitle;
	}
	
	public void addObserver(IEntreesObserver obs) {
		observeurs.add(obs);
	}
	
	public HashMap<String, String> getData(){
		return entreesVue.action();
	}
	
	public void propagateError(String message) {
		entreesVue.messageErreur(message);
	}
	
	public void action() {
		for (IEntreesObserver obs : observeurs) {
			obs.actionEvent(this);
		}
	}

}
