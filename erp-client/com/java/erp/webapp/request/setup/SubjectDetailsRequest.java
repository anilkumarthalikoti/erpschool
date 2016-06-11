package com.java.erp.webapp.request.setup;

import com.java.erp.webapp.request.common.BaseRequest;

public class SubjectDetailsRequest extends BaseRequest {
	private static final long serialVersionUID = 1L;
	private Long subjectId;
	 private String subjectName;
	 private Integer prority;
	public Long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public Integer getPrority() {
		return prority;
	}
	public void setPrority(Integer prority) {
		this.prority = prority;
	}
	 
		 
	 

}
