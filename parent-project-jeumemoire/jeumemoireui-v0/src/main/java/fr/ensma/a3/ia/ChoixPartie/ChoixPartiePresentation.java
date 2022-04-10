/**
 * 
 */
package fr.ensma.a3.ia.ChoixPartie;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.Details.DetailsPresentation;
import fr.ensma.a3.ia.Details.DetailsVue;
import fr.ensma.a3.ia.Details.IDetailsObserver;
import fr.ensma.a3.ia.ListePartie.ListePartiePresentation;
import fr.ensma.a3.ia.ListePartie.ListePartieVue;

/**
 * @author nunod
 *
 */
public class ChoixPartiePresentation implements IDetailsObserver {

	private IChoixPartieMediateur vue;
	
	private DetailsPresentation detailsPartie;
	private DetailsPresentation selectionPartie;
	private ListePartiePresentation parties;
	
	private String title;
	
	/**
	 * 
	 */
	public ChoixPartiePresentation() {
		// TODO Auto-generated constructor stub
		title = "Choix de partie";
	}
	
	public void setMediateur(IChoixPartieMediateur mediateur) {
		vue = mediateur;
		configParties();
		configEntrees();
		addCBValues();
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
		
		vue.setTitle(title);
	}
	
	private void configParties() {
		parties = new ListePartiePresentation();
		ListePartieVue vueParties = new ListePartieVue(parties);
		parties.setMediateur(vueParties);
		
		vue.setCompoParties(vueParties);
	}
	
	private void configEntrees() {
		List<String> composPartie = new ArrayList<String>();
		composPartie.add("Difficulte");
		composPartie.add("Taille Plateau");
		composPartie.add("Nombre de Joueurs");
		
		detailsPartie = new DetailsPresentation(composPartie);
		detailsPartie.addObserver(this);
		DetailsVue vueDetails = new DetailsVue(detailsPartie);
		detailsPartie.setMediateur(vueDetails);
		
		vue.setCompoDetails(vueDetails);
		
		List<String> composSelectionPartie = new ArrayList<String>();
		composSelectionPartie.add("Identifiant");
		
		selectionPartie = new DetailsPresentation(composSelectionPartie);
		selectionPartie.addObserver(this);
		DetailsVue vueSelecPartie = new DetailsVue(selectionPartie);
		selectionPartie.setMediateur(vueSelecPartie);
		
		vue.setCompoSelecPartie(vueSelecPartie);
	}
	
	private void addCBValues() {
		detailsPartie.ajouterInfoCB("Taille Plateau", "4");
		detailsPartie.ajouterInfoCB("Taille Plateau", "7");
		detailsPartie.ajouterInfoCB("Taille Plateau", "10");
		
		detailsPartie.ajouterInfoCB("Difficulte", "1");
		detailsPartie.ajouterInfoCB("Difficulte", "2");
		
		for (Integer i = 2; i <= 8; i++) {
			detailsPartie.ajouterInfoCB("Nombre de Joueurs", i.toString());
		}
	}

	@Override
	public void actionEvent() {
		// TODO Auto-generated method stub
		System.out.println("Action déclanché depuis la nouvelle partie");
		
		
	}
}
