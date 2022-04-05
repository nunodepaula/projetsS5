/**
 * 
 */
package fr.ensma.a3.ia.Details;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author nunod
 *
 */
public class DetailsPresentation {

	private IDetailsMediateur vue;
	private List<IDetailsObserver> observeurs;
	
	private String title;
	
	private HashMap<String, Integer> composIndices;
	
	/**
	 * 
	 */
	public DetailsPresentation(List<String> composDetails) {
		// TODO Auto-generated constructor stub
		title = "Nouvelle Partie";
		
		observeurs = new ArrayList<IDetailsObserver>();
		// Enregistrement du vecteur des composants dans un HashMap
		composIndices = new HashMap<String,Integer>(); 
		for(int i = 0; i < composDetails.size(); i++) {
			composIndices.put(composDetails.get(i), i);
		}
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setMediateur(IDetailsMediateur mediateur) {
		vue = mediateur;
		vue.ajouterChamps(composIndices);
	}
	
	public void addObserver(IDetailsObserver obs) {
		observeurs.add(obs);
	}
	
	public void action() {
		for (IDetailsObserver obs : observeurs) {
			obs.actionEvent();
		}
	}

}