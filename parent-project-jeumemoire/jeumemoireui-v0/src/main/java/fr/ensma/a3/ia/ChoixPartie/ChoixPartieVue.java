/**
 * 
 */
package fr.ensma.a3.ia.ChoixPartie;

import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 * @author nunod
 *
 */
public class ChoixPartieVue extends GridPane implements IChoixPartieMediateur {

	private ChoixPartiePresentation presentation;
	
	private Label titleLabel;
	private Label infosLabel1;
	private Label infosLabel2;
	
	/**
	 * 
	 */
	public ChoixPartieVue(ChoixPartiePresentation presentation) {
		// Basic initialization
		super();
		this.presentation = presentation;
		
		titleLabel = new Label(this.presentation.getTitle());
		titleLabel.setFont(Font.font(20));
		
		GridPane.setHalignment(titleLabel, HPos.CENTER);
		this.add(titleLabel, 0, 0, 2, 1);
		
		infosLabel1 = new Label("Selectionner une partie en attente de joueur ou remplissez une nouvelle partie");
		infosLabel1.setFont(Font.font(16));
		
		GridPane.setHalignment(infosLabel1, HPos.CENTER);
		this.add(infosLabel1, 0, 1, 2, 1);
		
		infosLabel2 = new Label("Puis cliquez en 'Commencer'");
		infosLabel2.setFont(Font.font(16));
		
		GridPane.setHalignment(infosLabel2, HPos.CENTER);
		this.add(infosLabel2, 0, 2, 2, 1);
	}
	
	public void setTitle(String title) {
		titleLabel.setText(title);
	}

}
