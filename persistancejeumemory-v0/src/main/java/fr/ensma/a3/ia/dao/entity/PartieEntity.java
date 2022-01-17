/**
 * 
 */
package fr.ensma.a3.ia.dao.entity;

import java.util.Objects;

/**
 * @author alvaresn
 *
 */
public class PartieEntity {

	private int idPartie;
	private int difficulteJeu;
	private int taillePlateau;
	private int nbPaires;
	/**
	 * @return the idPartie
	 */
	public int getIdPartie() {
		return idPartie;
	}
	/**
	 * @param idPartie the idPartie to set
	 */
	public void setIdPartie(int idPartie) {
		this.idPartie = idPartie;
	}
	/**
	 * @return the difficulteJeu
	 */
	public int getDifficulteJeu() {
		return difficulteJeu;
	}
	/**
	 * @param difficulteJeu the difficulteJeu to set
	 */
	public void setDifficulteJeu(int difficulteJeu) {
		this.difficulteJeu = difficulteJeu;
	}
	/**
	 * @return the taillePlateau
	 */
	public int getTaillePlateau() {
		return taillePlateau;
	}
	/**
	 * @param taillePlateau the taillePlateau to set
	 */
	public void setTaillePlateau(int taillePlateau) {
		this.taillePlateau = taillePlateau;
	}
	/**
	 * @return the nbPaires
	 */
	public int getNbPaires() {
		return nbPaires;
	}
	/**
	 * @param nbPaires the nbPaires to set
	 */
	public void setNbPaires(int nbPaires) {
		this.nbPaires = nbPaires;
	}
	@Override
	public String toString() {
		return "PartieEntity pour la partie numéro :" + idPartie + ", difficulte du jeu :" + difficulteJeu + " - Taille Plateau="
				+ taillePlateau + " et nombre de paires=" + nbPaires;
	}
	@Override
	public int hashCode() {
		return Objects.hash(difficulteJeu, idPartie, nbPaires, taillePlateau);
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PartieEntity)) {
			return false;
		}
		PartieEntity partie = (PartieEntity) obj;
		return (difficulteJeu == partie.difficulteJeu && idPartie == partie.idPartie && nbPaires == partie.nbPaires
				&& taillePlateau == partie.taillePlateau);
	}
	
	

}
