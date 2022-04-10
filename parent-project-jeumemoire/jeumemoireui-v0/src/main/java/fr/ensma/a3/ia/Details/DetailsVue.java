/**
 * 
 */
package fr.ensma.a3.ia.Details;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 * @author nunod
 *
 */
public class DetailsVue extends GridPane implements IDetailsMediateur {

	private DetailsPresentation presentation;

	private Label title;
	private List<Label> labels;
	private List<ComboBox<String>> infos;
	private Button actionBtn;

	/**
	 * 
	 */
	public DetailsVue(DetailsPresentation presentation) {
		// TODO Auto-generated constructor stub
		super();
		this.presentation = presentation;

		// Set gaps
		this.setHgap(5);
		this.setVgap(5);

		// Ajout du label pour le titre de la section
		title = new Label(this.presentation.getTitle());
		title.setFont(Font.font(16));

		GridPane.setHalignment(title, HPos.CENTER);
		this.add(title, 0, 0, 2, 1);

		labels = new ArrayList<Label>();
		infos = new ArrayList<ComboBox<String>>();

		//this.addEventHandler(ActionEvent.ACTION, this);
	}

	@Override
	public void ajouterChamps(HashMap<String, Integer> composNoms) {
		Label label;
		ComboBox<String> cb;
		Integer index;

		for (String compoNom : composNoms.keySet()) {
			index = composNoms.get(compoNom);

			label = new Label(compoNom);
			GridPane.setHalignment(label, HPos.LEFT);
			labels.add(label);
			this.add(label, 0, index + 1);

			cb = new ComboBox<String>();
			GridPane.setHalignment(cb, HPos.RIGHT);
			infos.add(cb);
			this.add(cb, 1, index + 1);
		}

		actionBtn = new Button("Commencer");
		GridPane.setHalignment(actionBtn, HPos.CENTER);
		this.add(actionBtn, 0, composNoms.size() + 1, 2, 1);
		
		actionBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// Calls presentation action method
				presentation.action();
			}
		});
	}

	@Override
	public void ajouterInfoCB(String labelName, String datum) {
		Integer index = 0;
		Label lb;
		for (int i = 0; i < labels.size(); i++) {
			lb = labels.get(i);
			if (lb.getText().compareTo(labelName) == 0) {
				index = i;
				break;
			}
		}
		ComboBox<String> cb = infos.get(index);

		cb.getItems().add(datum);
	}
	
	@Override
	public HashMap<String,String> getCBValues(){
		HashMap<String,String> cbValues = new HashMap<String,String>();
		
		for (int i = 0; i < labels.size(); i++) {
			cbValues.put(labels.get(i).getText(), infos.get(i).getValue());
		}
		
		return cbValues;
	}

}
