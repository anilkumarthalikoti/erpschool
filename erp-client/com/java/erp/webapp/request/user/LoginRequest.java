package com.java.erp.webapp.request.user;

import com.java.erp.webapp.request.common.BaseRequest;

public class LoginRequest extends BaseRequest {
	private static final long serialVersionUID = 1L;
	
	String loginId;
	String loginPassword;
	boolean isValid;
	
	
	String errorMessage;
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	

}
