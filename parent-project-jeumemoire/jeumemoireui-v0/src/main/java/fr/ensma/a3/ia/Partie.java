package fr.ensma.a3.ia;

public class Partie {

	private String creePar;
	private String difficulte;
	private Integer taillePlateau;
	private Integer nbPaires;
	private Integer nbJoueurs;
	
	public Partie(String creePar, String difficulte,
			Integer taillePlateau, Integer nbPaires, Integer nbJoueurs) 
	{
		this.creePar = creePar;
		this.difficulte = difficulte;
		this.taillePlateau = taillePlateau;
		this.nbPaires = nbPaires;
		this.nbJoueurs = nbJoueurs;
	}

	public String getCreePar() {
		return creePar;
	}

	public void setCreePar(String creePar) {
		this.creePar = creePar;
	}

	public String getDifficulte() {
		return difficulte;
	}

	public void setDifficulte(String difficulte) {
		this.difficulte = difficulte;
	}

	public Integer getTaillePlateau() {
		return taillePlateau;
	}

	public void setTaillePlateau(Integer taillePlateau) {
		this.taillePlateau = taillePlateau;
	}

	public Integer getNbPaires() {
		return nbPaires;
	}

	public void setNbPaires(Integer nbPaires) {
		this.nbPaires = nbPaires;
	}

	public Integer getNbJoueurs() {
		return nbJoueurs;
	}

	public void setNbJoueurs(Integer nbJoueurs) {
		this.nbJoueurs = nbJoueurs;
	}

}
