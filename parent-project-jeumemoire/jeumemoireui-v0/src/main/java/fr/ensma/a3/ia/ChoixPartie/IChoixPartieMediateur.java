/**
 * 
 */
package fr.ensma.a3.ia.ChoixPartie;

import fr.ensma.a3.ia.Details.DetailsVue;
import fr.ensma.a3.ia.ListePartie.ListePartieVue;

/**
 * @author nunod
 *
 */
public interface IChoixPartieMediateur {

	public void setTitle(String title);
	
	public void setCompoParties(ListePartieVue vueParties);
	public void setCompoDetails(DetailsVue vueDetails);
}
