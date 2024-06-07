package com.prueba.services.products.exception;

public class UnauthorizedException extends BillingException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4569031173321156458L;

	public UnauthorizedException() {
	}

	public UnauthorizedException(String code, String readableMessage, Throwable cause) {
		super(code, readableMessage, cause);
	}

	public UnauthorizedException(String code, String readableMessage) {
		super(code, readableMessage);
	}

}
