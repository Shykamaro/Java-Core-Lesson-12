package lgs.hmwrk;

public class WrongInputConsoleParametersException extends Exception {
	private String message;

	public WrongInputConsoleParametersException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
