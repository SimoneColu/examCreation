package it.polito.temperatureControl;

@SuppressWarnings("serial")
public class InvalidControlException extends Exception {

	public InvalidControlException() {
		super("Error occured");
	}
	public InvalidControlException(String msg) {
		super(msg);
	}

}
