package com.zee.demo.exception;

import org.springframework.http.HttpStatus;
public class CustomError {
    private final HttpStatus httpStatus;
    private final String message;
	public CustomError(HttpStatus httpStatus, String message) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
	}
    
    
}
