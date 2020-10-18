package com.digitalBank.projectApiBank.services.exceptions;

public class DefaultHandlerExceptionResolver extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DefaultHandlerExceptionResolver(String message) {
		super(message);
	}
}