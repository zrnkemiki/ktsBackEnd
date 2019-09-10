package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class StopDoesntExistException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public StopDoesntExistException() {
		super("Stajaliste sa tim ID-em ne postoji!");
	}
}
