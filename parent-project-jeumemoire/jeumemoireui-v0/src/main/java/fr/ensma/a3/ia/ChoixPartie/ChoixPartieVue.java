/**
 * 
 */
package fr.ensma.a3.ia.ChoixPartie;

import fr.ensma.a3.ia.Details.DetailsVue;
import fr.ensma.a3.ia.ListePartie.ListePartieVue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
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
		
		this.setHgap(10);
		this.setVgap(10);
		this.setPadding(new Insets(15,20,10,10));
		
		titleLabel = new Label(this.presentation.getTitle());
		titleLabel.setFont(Font.font(20));
		
		GridPane.setHalignment(titleLabel, HPos.CENTER);
		this.add(titleLabel, 0, 0, 4, 1);
		
		infosLabel1 = new Label("Selectionner une partie en attente de joueur ou remplissez une nouvelle partie");
		infosLabel1.setFont(Font.font(16));
		
		GridPane.setHalignment(infosLabel1, HPos.LEFT);
		this.add(infosLabel1, 0, 1, 3, 1);
		
		infosLabel2 = new Label("Puis cliquez en 'Commencer'");
		infosLabel2.setFont(Font.font(16));
		
		GridPane.setHalignment(infosLabel2, HPos.LEFT);
		this.add(infosLabel2, 0, 2, 3, 1);
	}
	
	public void setTitle(String title) {
		titleLabel.setText(title);
	}
	
	@Override
	public void setCompoParties(ListePartieVue vueParties) {
		this.add(vueParties, 0,3,3,2);
	}
	
	@Override
	public void setCompoDetails(DetailsVue vueDetails) {
		this.add(vueDetails, 3, 3,1,1);
	}
	
	@Override
	public void setCompoSelecPartie(DetailsVue vueSelecPartie) {
		this.add(vueSelecPartie, 3, 4, 1, 1);
	}

}
