package fr.ensma.a3.ia.JeuMemoire;

public class PartiePleineException extends Exception{

	private String monMessage;
	
	public PartiePleineException() {}
	
	public PartiePleineException(final String msg) {
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


