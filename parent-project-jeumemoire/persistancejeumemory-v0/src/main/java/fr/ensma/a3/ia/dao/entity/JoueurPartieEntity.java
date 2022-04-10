package fr.ensma.a3.ia.dao.entity;

public class JoueurPartieEntity {
	private Integer idJP;
	private Integer idPartie;
	private Integer  idJoueur;
	private Integer nbPair; // Nombre de paires trouvés par le joueur
	
	public JoueurPartieEntity() {
		
	}
	
	public JoueurPartieEntity(Integer idPartie, Integer idJoueur, Integer nbPair) {
		this.idPartie = idPartie;
		this.idJoueur = idJoueur;
		this.nbPair = nbPair;
	}
	
	public Integer getIdJP() {
		return idJP;
	}
	public void setIdJP(Integer uneId) {
		idJP=uneId;
	}
	public Integer getIdPartie() {
		return idPartie;
	}
	public void setIdPartie(Integer nouvelId) {
		idPartie=nouvelId;
	}
	public Integer getJoueurId() {
		return idJoueur;
	}
	public void setJoueur(Integer unJoueur) {
		idJoueur=unJoueur;
	}
	public Integer getNbpair() {
		return nbPair;
	}
		
	public void setNbPair(Integer nPair) {
		nbPair=nPair;
	}
	
}
