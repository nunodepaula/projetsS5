/**
 * 
 */
package fr.ensma.a3.ia.Case;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author alvaresn
 *
 */
public class CaseVue extends Button implements ICaseMediateur, EventHandler<ActionEvent> {

	private CasePresentation presentation;
	
	private ImageView croix;
	private ImageView rond;
	private ImageView vide;
	
	public CaseVue(CasePresentation presentation) {
		super("");
		this.presentation = presentation;
		
		getImages();
		
		setVide();
		this.addEventHandler(ActionEvent.ACTION, this);
	}
	
	public void setVide() {
		setGraphic(vide);
	}
	
	public void setCroix() {
		setGraphic(croix);
	}
	
	public void setRond() {
		setGraphic(rond);
	}
	
	private void getImages() {
		Image img = new Image(getClass().getResource("/croix.png").toString());
		croix = new ImageView(img);
		img = new Image(getClass().getResource("/rond.png").toString());
		rond = new ImageView(img);
		img = new Image(getClass().getResource("/vide.png").toString());
		vide = new ImageView(img);
	}

	@Override
	public void action(String etat) {
		if (etat == "croix") {
			setCroix();
		} else if (etat == "rond"){
			setRond();
		} else if (etat == "vide") {
			setVide();
		}
	}

	@Override
	public void handle(ActionEvent event) {
		// 
		presentation.action();
	}
}
