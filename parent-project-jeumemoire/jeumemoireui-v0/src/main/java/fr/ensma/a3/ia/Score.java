/**
 * 
 */
package fr.ensma.a3.ia;

/**
 * @author nunod
 *
 */
public class Score {

	private String pseudo;
	private Integer score;
	private Integer nbParties;
	
	public Score() {
	}
	
	/**
	 * @param pseudo
	 * @param score
	 * @param nbParties
	 */
	public Score(String pseudo, Integer score, Integer nbParties) {
		super();
		this.pseudo = pseudo;
		this.score = score;
		this.nbParties = nbParties;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getNbParties() {
		return nbParties;
	}

	public void setNbParties(Integer nbParties) {
		this.nbParties = nbParties;
	}

}
