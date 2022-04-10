package fr.ensma.a3.ia.memoire.api.partie;

public class PartieBean {

	private String nomCreateur;
	private Integer mode;
	private Integer nbPaires;
	private Integer longueurPlateau;
	private Integer nbJoueurs;
	private Integer identifiant;

	public PartieBean(String createur, Integer taillePlateau, Integer nbPaires, Integer mode, Integer nbJoueurs)
	{
		this.nomCreateur = createur;
		this.longueurPlateau = taillePlateau;
		this.nbPaires = nbPaires;
		this.mode = mode;
		this.nbJoueurs = nbJoueurs;
	}
	
	public PartieBean(String createur, Integer taillePlateau, Integer nbPaires, Integer mode, Integer nbJoueurs,
			Integer id) {
		this.nomCreateur = createur;
		this.longueurPlateau = taillePlateau;
		this.nbPaires = nbPaires;
		this.mode = mode;
		this.nbJoueurs = nbJoueurs;
		this.identifiant = id;
	}

	public Integer getNbJoueurs() {
		return this.nbJoueurs;
	}

	public String getNomCreateur() {
		return nomCreateur;
	}

	public Integer getMode() {
		return mode;
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

	public void setMode(Integer difficulte) {
		this.mode = difficulte;
	}
}
