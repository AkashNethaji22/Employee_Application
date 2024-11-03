package com.akash.CustomException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceNotFoundExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Errorresponse> handle( ResourceNotFoundException r){
			Errorresponse er = new Errorresponse
					(r.getMessage(), HttpStatus.NOT_FOUND.value());
	        return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
		
	}

}
