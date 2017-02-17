package fr.univbrest.dosi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SpiException extends RuntimeException {
	String messageErreur;
	
	public SpiException() {
		super();
	}
	
	public SpiException(Throwable t) {
		super(t);
	}
	
	public SpiException(String errorMessage,Throwable t) {
		super(errorMessage, t);
	}
	
	public SpiException(String errorMessage) {
		super(errorMessage);
		this.messageErreur = errorMessage;
	}

	public String toString() {
		return messageErreur;
	}
}