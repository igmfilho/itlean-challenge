package com.github.igmfilho.challenge.itlean.exception;

public class EmailAlreadyRegisteredException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String messageIndex = "error.email.registered";
	
	public EmailAlreadyRegisteredException() {
		super();
	}
	
	public String getMessageIndex() {
		return messageIndex;
	}
}
