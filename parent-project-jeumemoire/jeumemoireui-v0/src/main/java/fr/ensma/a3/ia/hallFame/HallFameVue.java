/**
 * 
 */
package fr.ensma.a3.ia.hallFame;

import fr.ensma.a3.ia.Score;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 * @author nunod
 *
 */
public class HallFameVue extends GridPane implements IHallFameMediateur, EventHandler<ActionEvent> {

	private HallFamePresentation presentation;
	
	private Label title;
	private Button btnRecommencer;
	private Button btnDeconnecter;
	
	private TableView<Score> tableParties;
	/**
	 * 
	 */
	public HallFameVue(HallFamePresentation presentation) {
		this.presentation = presentation;
		
		this.setHgap(5);
		this.setVgap(5);
		this.setPadding(new Insets(15,20,10,10));
		
		// Ajout du label pour le titre de la section
		title = new Label(this.presentation.getTitle());
		title.setFont(Font.font(16));
		
		GridPane.setHalignment(title, HPos.CENTER);
		this.add(title, 0, 0, 3, 1);
		
		tableParties = new TableView<Score>();
		
		TableColumn<Score,String> pseudoCol = new TableColumn<Score,String>("Joueur");
		tableParties.getColumns().add(pseudoCol);
		tableParties.resizeColumn(pseudoCol, 35);
		TableColumn<Score,Integer> scoreCol = new TableColumn<Score,Integer>("Score");
		tableParties.getColumns().add(scoreCol);
		tableParties.resizeColumn(scoreCol, 30);
		TableColumn<Score,Integer> partiesCol = new TableColumn<Score,Integer>("Nombre de Parties");
		tableParties.getColumns().add(partiesCol);
		tableParties.resizeColumn(partiesCol, 50);
		
		tableParties.minWidth(600);
		this.minWidth(700);
		
		GridPane.setHalignment(tableParties, HPos.CENTER);
		this.add(tableParties, 0, 1, 3, 1);
		
		btnDeconnecter = new Button("Déconnexion");
		GridPane.setHalignment(btnDeconnecter, HPos.CENTER);
		this.add(btnDeconnecter, 0, 2, 1, 1);
		btnDeconnecter.addEventHandler(ActionEvent.ACTION, this);
		
		btnRecommencer = new Button("Nouvelle Partie");
		GridPane.setHalignment(btnRecommencer, HPos.CENTER);
		this.add(btnRecommencer, 2, 2, 1, 1);
		btnRecommencer.addEventHandler(ActionEvent.ACTION, this);
	}
	
	@Override
	public void ajouterJoueur(Score j) {
		// TODO Auto-generated method stub
		System.out.println("Not implemented ajouterPartie");
	}
	
	@Override
	public void supprimerJoueur(Score j) {
		// TODO Auto-generated method stub
		System.out.println("Not implemented supprimerPartie");
	}

	@Override
	public void handle(ActionEvent event) {
		Object source = event.getSource();
		
		if (source == btnDeconnecter) {
			System.out.println("Demande de déconnexion reçue");
		}else if (source == btnRecommencer) {
			System.out.println("Demande de nouvelle partie reçue");
		}else {
			System.out.println("Demande non identifié reçue");
		}
	}

}
