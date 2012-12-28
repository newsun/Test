package com.symbio.sbtm.exceptions;

public class SecurityBreachException extends Exception {

	private static final long serialVersionUID = -1232121594261703341L;

	public SecurityBreachException() {
		super("Security Exception");
	}

	public SecurityBreachException(String message) {
		super(message);
	}
}
