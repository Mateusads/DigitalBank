package com.digitalBank.projectApiBank.services.exceptions;

public class IllegalArgumentException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IllegalArgumentException(String message) {
		super(message);	
	}
}