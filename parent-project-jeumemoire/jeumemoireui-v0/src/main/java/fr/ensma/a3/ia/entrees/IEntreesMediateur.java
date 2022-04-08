/**
 * 
 */
package fr.ensma.a3.ia.entrees;

import java.util.HashMap;

/**
 * @author nunod
 *
 */
public interface IEntreesMediateur {

	public HashMap<String, String> action();
	public void ajouterChamps(HashMap<String,Integer> composNoms);
}
