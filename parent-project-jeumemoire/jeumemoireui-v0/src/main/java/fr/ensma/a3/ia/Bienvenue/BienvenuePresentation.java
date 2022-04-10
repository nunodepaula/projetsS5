/**
 * 
 */
package fr.ensma.a3.ia.Bienvenue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;

import fr.ensma.a3.ia.ISceneManager;
import fr.ensma.a3.ia.entrees.EntreesPresentation;
import fr.ensma.a3.ia.entrees.EntreesVue;
import fr.ensma.a3.ia.entrees.IEntreesObserver;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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

	// Server Configurations
	private String serverIp = "localhost";
	private Integer serverPort = 8080;
	private String inscriptionLink = "/services/creation/inscriptionmap";
	private String connectionLink = "/services/creation/connexion";

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

	private String getLink(String service) {
		return "http://" + serverIp + ":" + serverPort.toString() + service;
	}

	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	public Integer getServerPort() {
		return serverPort;
	}

	public void setServerPort(Integer serverPort) {
		this.serverPort = serverPort;
	}

	public void addObserver(ISceneManager obs) {
		observeurs.add(obs);
	}

	public void propagateEvent(int status) {
		if (status == 200) {
			// Communication to the main screen for updating the current window
			for (ISceneManager obs : observeurs) {
				obs.choixPartie();
			}
		} else if (status == 409) {
			//
			entreesInscription.propagateError("Email déjà utilisé");
		} else if (status == 404) {
			entreesConnexion.propagateError("Joueur non trouvé");
		}
	}
	
	@Override
	public void actionEvent(EntreesPresentation presentation) {
		// Get data inserted by the user
		HashMap<String, String> player = presentation.getData();

		Response r;
		Gson gson = new Gson();
		Client restClient = ClientBuilder.newClient();
		// Interpret Data accordingly to inscription or connection
		if (presentation.equals(entreesInscription)) {
			System.out.println("New Player Inscription");

			r = restClient.target(getLink(inscriptionLink)).request(MediaType.APPLICATION_JSON)
					.post(Entity.json(gson.toJson(player)));

			System.out.println(gson.toJson(player));
			System.out.println(r.toString());
			
			// Communication to the main screen for updating the current window
			propagateEvent(r.getStatus());

		} else if (presentation.equals(entreesConnexion)) {
			System.out.println("Connexion of existing player");

			r = restClient.target(getLink(connectionLink)).request(MediaType.APPLICATION_JSON)
					.header("email", player.get("Email")).get();

			System.out.println(gson.toJson(player));
			System.out.println(r.toString());

			// Communication to the main screen for updating the current window
			propagateEvent(r.getStatus());
		}
	}
}
