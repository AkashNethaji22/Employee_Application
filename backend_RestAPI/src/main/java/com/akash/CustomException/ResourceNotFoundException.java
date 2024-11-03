package com.akash.CustomException;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L; // Unique ID for serialization
    public ResourceNotFoundException(String message){
		  super(message);
		}
}
