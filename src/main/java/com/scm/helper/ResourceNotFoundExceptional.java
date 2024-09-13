package com.scm.helper;

public class ResourceNotFoundExceptional extends RuntimeException {

	public ResourceNotFoundExceptional() {
		super("Resource not found");
		
	}




	public ResourceNotFoundExceptional(String message) {
		super(message);
		
	}

	

	
	
}
