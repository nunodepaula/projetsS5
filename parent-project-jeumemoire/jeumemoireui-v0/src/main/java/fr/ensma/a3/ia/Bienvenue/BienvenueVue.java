/**
 * 
 */
package fr.ensma.a3.ia.Bienvenue;

import fr.ensma.a3.ia.entrees.EntreesVue;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 * @author nunod
 *
 */
public class BienvenueVue extends GridPane implements IBienvenueMediateur {

	private BienvenuePresentation presentation;
	
	/**
	 * 
	 */
	public BienvenueVue(BienvenuePresentation presentation) {
		// TODO Auto-generated constructor stub
		this.presentation = presentation;
		
		this.setHgap(10);
		
		Label title = new Label(this.presentation.getTitle());
		title.setFont(Font.font(20));
		
		GridPane.setHalignment(title, HPos.CENTER);
		this.add(title, 0, 0, 2, 1);
	}

	@Override
	public void ajouterInscription(EntreesVue vueInscription) {
		this.add(vueInscription, 0, 1);
	}

	@Override
	public void ajouterConnexion(EntreesVue vueConnexion) {
		this.add(vueConnexion, 1, 1);
	}

}
