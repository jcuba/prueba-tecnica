package com.prueba.services.products.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class ApiException extends BillingException {

	private static final long serialVersionUID = -4787501325623567196L;
	
	public ApiException() {
		super();
	}
	
	public ApiException(String code, String readableMessage, Throwable cause) {
		super(code, readableMessage, cause);
	}
	
	public ApiException(String code, String readableMessage) {
		super(code, readableMessage);
	}

}
