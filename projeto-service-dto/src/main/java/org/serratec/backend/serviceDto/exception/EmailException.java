package org.serratec.backend.serviceDto.exception;

public class EmailException extends RuntimeException {


	private static final long serialVersionUID = 8798546505747323684L;

	public EmailException(String message) {
        super(message);
    }
}
