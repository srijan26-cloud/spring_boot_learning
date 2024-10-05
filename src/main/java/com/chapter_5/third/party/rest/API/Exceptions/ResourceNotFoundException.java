package com.chapter_5.third.party.rest.API.Exceptions;

public class ResourceNotFoundException extends RuntimeException{
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
