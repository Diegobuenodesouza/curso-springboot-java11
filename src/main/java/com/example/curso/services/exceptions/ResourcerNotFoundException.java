package com.example.curso.services.exceptions;

public class ResourcerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourcerNotFoundException(Object id) {
		super("Resourcer not found. Id " + id);
	}
	
	

}
