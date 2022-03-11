package ClientMessageJeuMemory;

public class ClientMessageJeuMemory {
	private String valeur;
	private Integer colonne;
	private Integer ligne;
	private Integer score;
	private String emailCreateur;
	private String emailScoreMaj;
	public String getValeur() {
		return valeur;
	}
	public String getEmailScoreMaj() {
		return emailScoreMaj;
	}
	public Integer getColonne() {
		return colonne;
	}
	public Integer getLigne() {
		return ligne;
	}
	public Integer getScore() {
		return score;
	}
	public String getEmailCreateur() {
		return emailCreateur;
	}
	public void setValeur(String uneValeur) {
		this.valeur=uneValeur;
	}
	public void setColonne(Integer colonne) {
		this.colonne=colonne;
	}
	public void setLigne(Integer ligne) {
		this.ligne=ligne;
	}
	public void setScore(Integer score) {
		this.score=score;
	}
	public void setEmailCreateur(String emailCreateur) {
		this.emailCreateur=emailCreateur;
	}
	public void setEmailScoreMaj(String emailScoreMaj) {
		this.emailScoreMaj=emailScoreMaj;
	}
}
