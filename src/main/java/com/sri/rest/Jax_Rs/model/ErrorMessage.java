package com.sri.rest.Jax_Rs.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {

	private String errorMessage;
	private int errorCode;
	private String documetation;

	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorMessage(String errorMessage, int errorCode, String documetation) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.documetation = documetation;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getDocumetation() {
		return documetation;
	}

	public void setDocumetation(String documetation) {
		this.documetation = documetation;
	}

	@Override
	public String toString() {
		return "ErrorMessage [errorMessage=" + errorMessage + ", errorCode=" + errorCode + ", documetation="
				+ documetation + "]";
	}

}
