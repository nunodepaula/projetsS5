package ClientMessagePartie;


public class ClientMessagePartie {
	private Integer mode;
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

	public void setMode(Integer mode) {
		this.mode = mode;
	}

	public void setLongueurPlateau(Integer longueurPlateau) {
		this.longueurPlateau = longueurPlateau;
	}

	public void setNbPaires(Integer nbPaires) {
		this.nbPaires = nbPaires;
	}

	public Integer getMode() {
		return mode;
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

