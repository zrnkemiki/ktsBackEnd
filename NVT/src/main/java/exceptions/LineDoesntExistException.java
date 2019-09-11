package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class LineDoesntExistException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public LineDoesntExistException() {
		super("Linija sa tim ID-em ne postoji!");
	}

}
