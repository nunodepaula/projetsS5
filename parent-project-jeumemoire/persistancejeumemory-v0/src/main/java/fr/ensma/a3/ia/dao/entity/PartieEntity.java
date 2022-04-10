package fr.ensma.a3.ia.dao.entity;

public class PartieEntity {
	private Integer idPartie;
	private Integer taillePlateau;
	private Integer difficuteDuJeu;

	public PartieEntity() {

	}

	public PartieEntity(Integer idPartie, Integer taillePlateau, Integer difficulte) {
		this.idPartie = idPartie;
		this.taillePlateau = taillePlateau;
		this.difficuteDuJeu = difficulte;
	}

	public Integer getId() {
		return idPartie;
	}

	public void setIdPartie(Integer nouvelId) {
		idPartie = nouvelId;
	}

	public Integer getTaille() {
		return taillePlateau;
	}

	public void setTaille(Integer uneTaille) {
		taillePlateau = uneTaille;
	}

	public Integer getDifficulte() {
		return difficuteDuJeu;
	}

	public void setDifficulte(Integer uneDifficulte) {
		difficuteDuJeu = uneDifficulte;
	}

}
