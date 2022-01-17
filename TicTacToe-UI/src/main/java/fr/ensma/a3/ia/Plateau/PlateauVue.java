/**
 * 
 */
package fr.ensma.a3.ia.Plateau;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

/**
 * @author alvaresn
 *
 */
public class PlateauVue extends GridPane implements IPlateauMediateur {

	private PlateauPresentation plateauPresentation;
	/**
	 * 
	 */
	public PlateauVue(PlateauPresentation plateauPresentation) {
		this.plateauPresentation = plateauPresentation;
		setAlignment(Pos.CENTER);
	}

	@Override
	public void ajouterComposant(Node e, int column, int row) {
		add(e, column, row);
	}

}