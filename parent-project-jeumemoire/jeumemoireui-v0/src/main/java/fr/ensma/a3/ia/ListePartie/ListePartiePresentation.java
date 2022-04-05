/**
 * 
 */
package fr.ensma.a3.ia.ListePartie;

import fr.ensma.a3.ia.Partie;

/**
 * @author nunod
 *
 */
public class ListePartiePresentation {

	private IListePartieMediateur vue;
	
	private String title;
	
	/**
	 * 
	 */
	public ListePartiePresentation() {
		// TODO Auto-generated constructor stub
		title = "Parties en attente";
	}
	
	public void setMediateur(IListePartieMediateur mediateur) {
		this.vue = mediateur;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void ajouterPartie(Partie p) {
		vue.ajouterPartie(p);
	}
	
	public void supprimerPartie(Partie p) {
		vue.supprimerPartie(p);
	}

}
