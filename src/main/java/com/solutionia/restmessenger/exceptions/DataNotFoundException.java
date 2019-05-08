package com.solutionia.restmessenger.exceptions;

public class DataNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataNotFoundException() {
		
	}
	
public DataNotFoundException(String message) {
		super(message);
	}
}
