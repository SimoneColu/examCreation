package it.polito.temperatureControl;

@SuppressWarnings("serial")
public class InvalidException extends Exception {

	public InvalidException() {
		super("Invali");
	}
	public InvalidException(String msg) {
		super(msg);
	}

}
