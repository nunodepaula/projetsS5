/**
 * 
 */
package fr.ensma.a3.ia.ChoixPartie;

/**
 * @author nunod
 *
 */
public class ChoixPartiePresentation {

	private IChoixPartieMediateur vue;
	
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
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
		
		vue.setTitle(title);
	}
}
