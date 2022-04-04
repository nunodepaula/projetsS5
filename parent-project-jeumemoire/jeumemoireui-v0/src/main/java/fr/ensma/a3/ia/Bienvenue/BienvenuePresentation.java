/**
 * 
 */
package fr.ensma.a3.ia.Bienvenue;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.ISceneManager;
import fr.ensma.a3.ia.entrees.EntreesPresentation;
import fr.ensma.a3.ia.entrees.EntreesVue;
import fr.ensma.a3.ia.entrees.IEntreesObserver;

/**
 * @author nunod
 *
 */
public class BienvenuePresentation implements IEntreesObserver {

	private String gameTitle;
	
	private List<ISceneManager> observeurs;
	
	private IBienvenueMediateur bienvenueVue;
	
	private EntreesPresentation entreesInscription;
	private EntreesPresentation entreesConnexion;
	
	/**
	 * 
	 */
	public BienvenuePresentation(String title) {
		// TODO Auto-generated constructor stub
		this.gameTitle = title;
		
		observeurs = new ArrayList<ISceneManager>();
	}

	public BienvenuePresentation() {
		this.gameTitle = "Memory Game";
	}
	
	public void setMediateur(IBienvenueMediateur mediateur) {
		this.bienvenueVue = mediateur;
		ajouterEntrees();
	}
	
	public String getTitle() {
		return gameTitle;
	}
	
	public void ajouterEntrees() {
		List<String> composInscription = new ArrayList<String>();
		composInscription.add("Email");
		composInscription.add("Nom");
		composInscription.add("Prenom");
		composInscription.add("Pseudo");
		entreesInscription = new EntreesPresentation("Inscription", composInscription);
		entreesInscription.addObserver(this);
		EntreesVue vueInscription = new EntreesVue(entreesInscription);
		entreesInscription.setMediateur(vueInscription);
		
		bienvenueVue.ajouterInscription(vueInscription);
		
		List<String> composConnexion = new ArrayList<String>();
		composConnexion.add("Email");
		entreesConnexion = new EntreesPresentation("Connexion", composConnexion);
		entreesConnexion.addObserver(this);
		EntreesVue vueConnexion = new EntreesVue(entreesConnexion);
		entreesConnexion.setMediateur(vueConnexion);
		
		bienvenueVue.ajouterConnexion(vueConnexion);
	}
	
	public void addObserver(ISceneManager obs) {
		observeurs.add(obs);
	}

	@Override
	public void actionEvent() {
		// TODO Auto-generated method stub
		for (ISceneManager obs : observeurs) {
			obs.choixPartie();
		}
	}
}
