package fr.ensma.a3.ia.rest;

public class PartieBean {
	private String nomCreateur;
	private String difficulte;
	private Integer nbPaires;
	private Integer longueurPlateau;
	private Integer nbJoueurs;
	private Integer identifiant;

	public PartieBean(String createur, Integer taillePlateau, Integer nbPaires, String difficulte, Integer nbJoueurs,
			Integer id) {
		this.nomCreateur = createur;
		this.longueurPlateau = taillePlateau;
		this.nbPaires = nbPaires;
		this.difficulte = difficulte;
		this.nbJoueurs = nbJoueurs;
		this.identifiant = id;
	}

	public Integer getNbJoueurs() {
		return this.nbJoueurs;
	}

	public String getNomCreateur() {
		return nomCreateur;
	}

	public String getDifficulte() {
		return difficulte;
	}

	public Integer getIdentifiant() {
		return identifiant;
	}

	public Integer getNbPaires() {
		return nbPaires;
	}

	public Integer getLongueurPlateau() {
		return longueurPlateau;
	}

	public void setNbJoueurs(Integer nbjoueurs) {
		this.nbJoueurs = nbjoueurs;
	}

	public void setNomCreateur(String nomCreateur) {
		this.nomCreateur = nomCreateur;
	}

	public void setLongueurPlateau(Integer taille) {
		this.longueurPlateau = taille;
	}

	public void setIdentifiant(Integer id) {
		this.identifiant = id;
	}

	public void setNbPaires(Integer nbPaires) {
		this.nbPaires = nbPaires;
	}

	public void setDifficulte(String difficulte) {
		this.difficulte = difficulte;
	}
}
