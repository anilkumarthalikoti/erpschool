package com.java.erp.webapp.request.admin;

import com.java.erp.webapp.request.common.BaseRequest;

public class UserCreationRequest extends BaseRequest {
	private static final long serialVersionUID = 1L;
	
	private String userId;
	private String userName;
	private byte dashBoardView;
	private String mailId;
	private String isActive;
	private String mobileNo;
	private String loginPassword;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public byte getDashBoardView() {
		return dashBoardView;
	}
	public void setDashBoardView(byte dashBoardView) {
		this.dashBoardView = dashBoardView;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	
	
}
