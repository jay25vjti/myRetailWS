package com.myretail.exception;

public class InvalidProductException extends RuntimeException {

	public InvalidProductException(String id){
		super(String.format("No entry found with id: <%s>", id));
		
	}
}
