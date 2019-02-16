package com.atmik.springdemo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;	
	Object[] objects;

	public StudentNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	public StudentNotFoundException(String message,Object[] objects) {
		super();
		this.message = message;
		this.objects=objects;
	}
	
	

}
