package com.feedback.dto;

public class ErrorDTO implements MyDTO{
private String errorMsg;

	
	public ErrorDTO(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
