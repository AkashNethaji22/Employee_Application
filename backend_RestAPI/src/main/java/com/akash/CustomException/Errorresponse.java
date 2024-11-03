package com.akash.CustomException;

public class Errorresponse {
	
	private String message;
	private int status;
	
	
	
	public Errorresponse(String message, int status) {
		super();
		this.message = message;
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
    
	
	
}
