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
		composPartie.add("Nombre de Paires");
		
		detailsPartie = new DetailsPresentation(composPartie);
		detailsPartie.addObserver(this);
		DetailsVue vueDetails = new DetailsVue(detailsPartie);
		detailsPartie.setMediateur(vueDetails);
		
		vue.setCompoDetails(vueDetails);
	}

	@Override
	public void actionEvent() {
		// TODO Auto-generated method stub
		System.out.println("Action déclanché depuis la nouvelle partie");
	}
}
