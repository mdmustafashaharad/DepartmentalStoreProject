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

public class InvalidProductIdException extends  RuntimeException {
	private String message;
	
	public InvalidProductIdException (String message ) {
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}
	
}
