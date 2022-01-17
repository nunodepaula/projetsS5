/**
 * 
 */
package fr.ensma.a3.ia.dao.entity;

import java.util.Objects;

/**
 * @author alvaresn
 *
 */
public class PartieJoueursEntity {

	private int idPartie_fk;
	private String emailJoueur_fk;
	private int nbPairesGagnes;
	/**
	 * @return the idPartie_fk
	 */
	public int getIdPartie_fk() {
		return idPartie_fk;
	}
	/**
	 * @param idPartie_fk the idPartie_fk to set
	 */
	public void setIdPartie_fk(int idPartie_fk) {
		this.idPartie_fk = idPartie_fk;
	}
	/**
	 * @return the emailJoueur_fk
	 */
	public String getEmailJoueur_fk() {
		return emailJoueur_fk;
	}
	/**
	 * @param emailJoueur_fk the emailJoueur_fk to set
	 */
	public void setEmailJoueur_fk(String emailJoueur_fk) {
		this.emailJoueur_fk = emailJoueur_fk;
	}
	/**
	 * @return the nbPairesGagnes
	 */
	public int getNbPairesGagnes() {
		return nbPairesGagnes;
	}
	/**
	 * @param nbPairesGagnes the nbPairesGagnes to set
	 */
	public void setNbPairesGagnes(int nbPairesGagnes) {
		this.nbPairesGagnes = nbPairesGagnes;
	}
	@Override
	public String toString() {
		return "Relation entre parties et joueurs, partie numéro : " + idPartie_fk + "joueur de email = " + emailJoueur_fk
				+ " - nombre de paires gagnés : " + nbPairesGagnes;
	}
	@Override
	public int hashCode() {
		return Objects.hash(emailJoueur_fk, idPartie_fk, nbPairesGagnes);
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PartieJoueursEntity)) {
			return false;
		}
		PartieJoueursEntity relation = (PartieJoueursEntity) obj;
		return (Objects.equals(emailJoueur_fk, relation.emailJoueur_fk) && idPartie_fk == relation.idPartie_fk
				&& nbPairesGagnes == relation.nbPairesGagnes);
	}
	
	

}
