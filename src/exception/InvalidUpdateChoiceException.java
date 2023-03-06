package exception;

/**
 * 
 * @author Mohammad Mustafa
 * @since 2023
 * Contact : 900651340
 *  Email : mdmustafashaharad@gmail.com
 *
 */
// custom Exception

public class InvalidUpdateChoiceException extends RuntimeException {
private String message;
	
	public InvalidUpdateChoiceException (String message ) {
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}
}
