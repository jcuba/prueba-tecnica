package com.prueba.services.products.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "stackTrace", "localizedMessage" })
public class BillingException extends Exception {

	private String code;

	private String readableMessage;

	public BillingException() {
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -742227460526368486L;

	public BillingException(String code, String readableMessage, Throwable cause) {
		super(cause.getMessage(), cause);
		this.code = code;
		this.readableMessage = readableMessage;
	}

	public BillingException(String code, String readableMessage) {
		super(readableMessage);
		this.code = code;
		this.readableMessage = readableMessage;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getReadableMessage() {
		return readableMessage;
	}

	public void setReadableMessage(String readableMessage) {
		this.readableMessage = readableMessage;
	}

}

