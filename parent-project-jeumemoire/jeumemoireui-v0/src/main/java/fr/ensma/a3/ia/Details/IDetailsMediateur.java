/**
 * 
 */
package fr.ensma.a3.ia.Details;

import java.util.HashMap;

/**
 * @author nunod
 *
 */
public interface IDetailsMediateur {

	public void ajouterChamps(HashMap<String,Integer> composNoms);
	public void ajouterInfoCB(String labelName, String datum);
	public HashMap<String,String> getCBValues();
}