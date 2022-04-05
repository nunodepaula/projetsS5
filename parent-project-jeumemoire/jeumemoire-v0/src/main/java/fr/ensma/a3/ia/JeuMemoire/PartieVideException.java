package fr.ensma.a3.ia.JeuMemoire;

public class PartieVideException extends Exception{
	private String monMessage;
	
	public PartieVideException() {}
	
	public PartieVideException(final String msg) {
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
