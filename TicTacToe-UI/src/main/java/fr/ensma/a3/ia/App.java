package fr.ensma.a3.ia;

import fr.ensma.a3.ia.Plateau.PlateauPresentation;
import fr.ensma.a3.ia.Plateau.PlateauVue;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

	private FlowPane root;
	private PlateauPresentation compoPlateau;
	
    @Override
    public void start(Stage stage) {
        stage.setTitle("TicTacToe");
        
        root = new FlowPane(Orientation.HORIZONTAL,10,10);
        root.setMinWidth(600);
		root.setAlignment(Pos.TOP_CENTER);
		
		compoPlateau = new PlateauPresentation();
		PlateauVue plateauVue = new PlateauVue(compoPlateau);
		compoPlateau.setMediateur(plateauVue);
		compoPlateau.setElementsTableau();
		
		root.getChildren().add(plateauVue);
		
		Scene scene = new Scene(root, 600, 600);
		stage.setScene(scene);
		stage.setWidth(600);
		stage.setMinHeight(120);
		stage.show();
		
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}