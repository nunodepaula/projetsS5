package fr.ensma.a3.ia.JeuMemoire;

public class JeuDeCartePleinException extends Exception{
	private String monMessage;
	
	public JeuDeCartePleinException() {}
	
	public JeuDeCartePleinException(final String msg) {
		monMessage = msg;
	}
	
	public final String getMonMessage() {
		return monMessage;
	}
	
	@Override
	public String getMessage() {
		return monMessage + " : " + super.getMessage();
	}
	
	private static final long serialVersionUID = 1L;
}
