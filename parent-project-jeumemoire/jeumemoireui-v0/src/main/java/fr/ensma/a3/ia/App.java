package fr.ensma.a3.ia;

import fr.ensma.a3.ia.Bienvenue.BienvenuePresentation;
import fr.ensma.a3.ia.Bienvenue.BienvenueVue;
import fr.ensma.a3.ia.ChoixPartie.ChoixPartiePresentation;
import fr.ensma.a3.ia.ChoixPartie.ChoixPartieVue;
import fr.ensma.a3.ia.hallFame.HallFamePresentation;
import fr.ensma.a3.ia.hallFame.HallFameVue;
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
	private Stage stage;
	
	private String title;
	
	private BienvenuePresentation bienvenuePresentation;
	private ChoixPartiePresentation choixPresentation;
	private HallFamePresentation hallOfFame;
	// Repeter pour les autres fenêtres ici
	
	@Override
	public void start(Stage stage) {
		title = "Jeu Memoire";
		stage.setTitle(title);
		
		
		this.stage = stage;
		
		fenetreInscription();
		//partieFinie();
	}
	
	public static void main( String[] args )
    {
		launch();
    }

	public void fenetreInscription() {
		root = new FlowPane(Orientation.HORIZONTAL,10,10);
        root.setMinWidth(600);
		root.setAlignment(Pos.TOP_CENTER);
		
		// TODO: Implementation des composants
		bienvenuePresentation = new BienvenuePresentation(title);
		bienvenuePresentation.addObserver(this);
		BienvenueVue bienvenueVue = new BienvenueVue(bienvenuePresentation);
		bienvenuePresentation.setMediateur(bienvenueVue);
			
		
		root.getChildren().add(bienvenueVue);
		
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setMinWidth(600);
		stage.setMinHeight(300);
		stage.show();
	}
	
	@Override
	public void choixPartie() {
		// TODO Auto-generated method stub
		choixPresentation = new ChoixPartiePresentation();
		ChoixPartieVue choixVue = new ChoixPartieVue(choixPresentation);
		choixPresentation.setMediateur(choixVue);
		
		root = new FlowPane(Orientation.HORIZONTAL,10,10);
        //root.setMinWidth(600);
		root.setAlignment(Pos.TOP_CENTER);
		
		root.getChildren().add(choixVue);
		stage.setWidth(800);
		stage.setHeight(600);
		scene.setRoot(root);
	}
	
	@Override
	public void partieFinie() {
		hallOfFame = new HallFamePresentation();
		HallFameVue HOFVue = new HallFameVue(hallOfFame);
		hallOfFame.setMediateur(HOFVue);
		
		root = new FlowPane(Orientation.HORIZONTAL,10,10);
        //root.setMinWidth(600);
		root.setAlignment(Pos.TOP_CENTER);
		
		root.getChildren().add(HOFVue);
		stage.setWidth(800);
		stage.setHeight(600);
		scene.setRoot(root);
	}
}
