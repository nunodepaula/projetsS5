package ClientMessagePartie;


public class ClientMessagePartie {
	private String difficulte;
	private Integer longueurPlateau;
	private Integer nbPaires;
	private String nomCreateur;
	private Integer nbJoueurs;
	private Integer identifiant;
	public ClientMessagePartie() {
	}

	public void setNomCreateur(String nomCreateur) {
		this.nomCreateur = nomCreateur;
	}
	
	public void setNbJoueurs(Integer nbJoueur) {
		this.nbJoueurs=nbJoueur;
	}
	
	public void setId(Integer ident) {
		this.identifiant=ident;
	}

	public void setDifficulte(String difficulte) {
		this.difficulte = difficulte;
	}

	public void setLongueurPlateau(Integer longueurPlateau) {
		this.longueurPlateau = longueurPlateau;
	}

	public void setNbPaires(Integer nbPaires) {
		this.nbPaires = nbPaires;
	}

	public String getDifficulte() {
		return difficulte;
	}

	public Integer getLongueurPlateau() {
		return longueurPlateau;
	}

	public Integer getNbPaires() {
		return nbPaires;
	}

	public String getNomCreateur() {
		return nomCreateur;
	}
	public Integer getNbJoueurs() {
		return nbJoueurs;
	}
	public Integer getId() {
		return identifiant;
	}
	}

