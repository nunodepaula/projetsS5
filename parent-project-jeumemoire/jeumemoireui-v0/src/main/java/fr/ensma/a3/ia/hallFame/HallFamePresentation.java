/**
 * 
 */
package fr.ensma.a3.ia.hallFame;

import fr.ensma.a3.ia.Score;

/**
 * @author nunod
 *
 */
public class HallFamePresentation {

	private IHallFameMediateur vue;

	private String title;
	
	/**
	 * 
	 */
	public HallFamePresentation() {
		title = "Hall of Fame";
	}

	public void setMediateur(IHallFameMediateur mediateur) {
		this.vue = mediateur;
	}
	
	public void setTitle(String titre) {
		title = titre;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void ajouterJoueur(Score j) {
		vue.ajouterJoueur(j);
	}
	
	public void supprimerJoueur(Score j) {
		vue.supprimerJoueur(j);
	}
}
