/**
 * 
 */
package fr.ensma.a3.ia.ListePartie;

import fr.ensma.a3.ia.Partie;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * @author nunod
 *
 */
public class ListePartieVue extends VBox implements IListePartieMediateur {

	private ListePartiePresentation presentation;
	
	private Label title;
	
	private TableView<Partie> tableParties;
	/**
	 * 
	 */
	public ListePartieVue(ListePartiePresentation presentation) {
		this.presentation = presentation;
		
		this.setSpacing(10);
		this.setPadding(new Insets(15,20,10,10));
		
		// Ajout du label pour le titre de la section
		title = new Label(this.presentation.getTitle());
		title.setFont(Font.font(16));
		
		this.getChildren().add(title);
		
		tableParties = new TableView<Partie>();
		
		TableColumn<Partie,String> pseudoCol = new TableColumn<Partie,String>("Créé par");
		tableParties.getColumns().add(pseudoCol);
		tableParties.resizeColumn(pseudoCol, 35);
		TableColumn<Partie,String> difficulteCol = new TableColumn<Partie,String>("Difficulté");
		tableParties.getColumns().add(difficulteCol);
		TableColumn<Partie,Integer> plateauCol = new TableColumn<Partie,Integer>("Taille Plateau");
		tableParties.getColumns().add(plateauCol);
		tableParties.resizeColumn(plateauCol, 30);
		TableColumn<Partie,Integer> pairesCol = new TableColumn<Partie,Integer>("Nombre Paires");
		tableParties.getColumns().add(pairesCol);
		tableParties.resizeColumn(pairesCol, 30);
		TableColumn<Partie,Integer> joueursCol = new TableColumn<Partie,Integer>("Nombre Joueurs");
		tableParties.getColumns().add(joueursCol);
		tableParties.resizeColumn(joueursCol, 30);
		
		tableParties.minWidth(600);
		this.minWidth(700);
		
		this.getChildren().add(tableParties);
	}
	
	@Override
	public void ajouterPartie(Partie p) {
		// TODO Auto-generated method stub
		System.out.println("Not implemented ajouterPartie");
	}
	
	@Override
	public void supprimerPartie(Partie p) {
		// TODO Auto-generated method stub
		System.out.println("Not implemented supprimerPartie");
	}

}
