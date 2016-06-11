package com.java.erp.webapp.database.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.java.erp.webapp.database.project.BaseFields;

@Entity
@Table(name = "usr_logins")
public class Users extends BaseFields implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "loginid")
	String userId;
	@Column(name = "loginPwd")
	String password;
	@Column(name = "userName")
	String name;
	@Column(name = "isActive")
	Boolean isActive=false;
	@Column(name = "emailId")
	String mailId;
	@Column(name = "phoneNo")
	String phoneNo;
	@Column(name = "isAdmin")
	String isAdmin="N";
	@Column(name="dashboardView")
	private Byte dashboardView;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	 
	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Byte getDashboardView() {
		return dashboardView;
	}

	public void setDashboardView(Byte dashboardView) {
		this.dashboardView = dashboardView;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	 
}
