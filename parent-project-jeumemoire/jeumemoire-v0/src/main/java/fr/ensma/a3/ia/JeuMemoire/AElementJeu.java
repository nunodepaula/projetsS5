/**
 * 
 */
package fr.ensma.a3.ia.JeuMemoire;

/**
 * @author nunod
 *
 */
public abstract class AElementJeu {

	protected BaseJeu base;
	/**
	 * 
	 */
	public AElementJeu() {
		// TODO Auto-generated constructor stub
	}
	public AElementJeu(BaseJeu base) {
		// TODO Auto-generated constructor stub
		this.base = base;
	}
	
	public BaseJeu getBase() {
		return base;
	}
	public void setBase(BaseJeu base) {
		this.base = base;
	}
}
