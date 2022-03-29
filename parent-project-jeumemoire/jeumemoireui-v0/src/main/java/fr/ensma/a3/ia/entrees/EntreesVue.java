/**
 * 
 */
package fr.ensma.a3.ia.entrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 * @author nunod
 *
 */
public class EntreesVue extends GridPane implements IEntreesMediateur, EventHandler<ActionEvent> {

	private EntreesPresentation presentation;
	
	private Label title;
	private List<Label> labels;
	private List<TextField> champs;
	private Button actionBtn;
	
	/**
	 * 
	 */
	public EntreesVue(EntreesPresentation presentation) {
		// TODO Auto-generated constructor stub
		super();
		
		this.presentation = presentation;
		
		this.setHgap(5);
		this.setVgap(5);
		
		// Ajout du label pour le titre de la section
		title = new Label(this.presentation.getSection());
		title.setFont(Font.font(18));
		
		GridPane.setHalignment(title, HPos.CENTER);
		this.add(title, 0, 0, 2, 1);
		
		labels = new ArrayList<Label>();
		champs = new ArrayList<TextField>();
		
		this.addEventHandler(ActionEvent.ACTION, this);
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ajouterChamps(HashMap<String,Integer> composNoms) {
		Label label;
		TextField tf;
		Integer index;
		for(String compoNom : composNoms.keySet()) {
			index = composNoms.get(compoNom);
			
			label = new Label(compoNom);
			GridPane.setHalignment(label, HPos.LEFT);
			labels.add(label);
			this.add(label, 0, index+1);
			
			tf = new TextField();
			GridPane.setHalignment(tf, HPos.RIGHT);
			champs.add(tf);
			this.add(tf, 1, index+1);
		}
		
		actionBtn = new Button(title.getText());
		GridPane.setHalignment(actionBtn, HPos.CENTER);
		this.add(actionBtn, 0, composNoms.size()+1, 2, 1);
	}

	@Override
	public void handle(ActionEvent event) {
		// Calls presentation action method
		presentation.action();
	}

}
