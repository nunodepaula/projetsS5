/**
 * 
 */
package fr.ensma.a3.ia.Plateau;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.Case.CasePresentation;
import fr.ensma.a3.ia.Case.CaseVue;
import fr.ensma.a3.ia.Case.ICaseObserver;

/**
 * @author alvaresn
 *
 */
public class PlateauPresentation implements ICaseObserver {

	private IPlateauMediateur plateauVue;
	private List<CasePresentation> composCases;
	
	private String joueur1 = "croix";
	private String joueur2 = "rond";
	private String quiJoue = joueur1;
	
	/**
	 * 
	 */
	public PlateauPresentation() {
		composCases = new ArrayList<CasePresentation>();
	}
	
	public void setElementsTableau() {
		CasePresentation p;
		CaseVue v;
		
		for (int i = 0; i<3; i++) {
			for (int j = 0; j<3; j++) {
				
				p = new CasePresentation();
				p.addObserver(this);
				v = new CaseVue(p);
				p.setMediateur(v);
				
				composCases.add(p);
				
				plateauVue.ajouterComposant(v, i, j);;
			}
		}
	}
	
	public void setMediateur(IPlateauMediateur mediateur) {
		plateauVue = mediateur;
	}
	
	@Override
	public void actionEvent() {
		System.out.println("Action reçu par le plateau");
	}
}
