package com.prueba.services.products.exception;

import org.springframework.http.HttpStatus;

import lombok.*;

@Getter
public class ApiException extends Exception{

	private static final long serialVersionUID = -4787501325623567196L;
	
	private String message;
	private HttpStatus httStatus;
	
	public ApiException(String message, HttpStatus httStatus) {
		super(message);
		this.message = message;
		this.httStatus = httStatus;
	}
	
	@Override
	public String toString() {
		return message;
	}

}
