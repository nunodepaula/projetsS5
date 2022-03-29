package fr.ensma.a3.ia;

import fr.ensma.a3.ia.Bienvenue.BienvenuePresentation;
import fr.ensma.a3.ia.Bienvenue.BienvenueVue;
import fr.ensma.a3.ia.ChoixPartie.ChoixPartiePresentation;
import fr.ensma.a3.ia.ChoixPartie.ChoixPartieVue;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application implements ISceneManager
{
    
	private FlowPane root;
	private Scene scene;
	
	private BienvenuePresentation bienvenuePresentation;
	private ChoixPartiePresentation choixPresentation;
	// Repeter pour les autres fenêtres ici
	
	@Override
	public void start(Stage stage) {
		String title = "Jeu Memoire";
		stage.setTitle(title);
		
		root = new FlowPane(Orientation.HORIZONTAL,10,10);
        root.setMinWidth(600);
		root.setAlignment(Pos.TOP_CENTER);
		
		// TODO: Implementation des composants
		bienvenuePresentation = new BienvenuePresentation(title);
		bienvenuePresentation.addObserver(this);
		BienvenueVue bienvenueVue = new BienvenueVue(bienvenuePresentation);
		bienvenuePresentation.setMediateur(bienvenueVue);
			
		
		root.getChildren().add(bienvenueVue);
		
		scene = new Scene(root, 600, 300);
		stage.setScene(scene);
		stage.setWidth(600);
		stage.setMinHeight(120);
		stage.show();
	}
	
	public static void main( String[] args )
    {
		launch();
    }

	@Override
	public void choixPartie() {
		// TODO Auto-generated method stub
		choixPresentation = new ChoixPartiePresentation();
		ChoixPartieVue choixVue = new ChoixPartieVue(choixPresentation);
		choixPresentation.setMediateur(choixVue);
		
		root = new FlowPane(Orientation.HORIZONTAL,10,10);
        root.setMinWidth(600);
		root.setAlignment(Pos.TOP_CENTER);
		
		root.getChildren().add(choixVue);
		scene.setRoot(root);
	}
}
