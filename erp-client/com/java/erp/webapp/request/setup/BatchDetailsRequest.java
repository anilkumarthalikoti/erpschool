package com.java.erp.webapp.request.setup;

import com.java.erp.webapp.request.common.BaseRequest;

public class BatchDetailsRequest extends BaseRequest {
	private static final long serialVersionUID = 1L;
	private Long[] branch;
	private Long[] course;
	private Long[] language;
	private String activeStatus;
	public Long[] getBranch() {
		return branch;
	}
	public void setBranch(Long[] branch) {
		this.branch = branch;
	}
	public Long[] getCourse() {
		return course;
	}
	public void setCourse(Long[] course) {
		this.course = course;
	}
	public Long[] getLanguage() {
		return language;
	}
	public void setLanguage(Long[] language) {
		this.language = language;
	}
	public String getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}
 
}
