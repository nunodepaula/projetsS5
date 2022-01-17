package fr.ensma.a3.ia;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class simpleButton extends Button {

	private ImageView croix;
	
	public simpleButton(String text) {
		super(text);
		Image img = new Image(getClass().getResource("/croix.png").toString());
		croix = new ImageView(img);
		setGraphic(croix);
	}


}
