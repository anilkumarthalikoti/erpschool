package com.java.erp.webapp.request.setup;

import com.java.erp.webapp.request.common.BaseRequest;

public class StudentAdmissionFieldRequest extends BaseRequest {
	private static final long serialVersionUID = 1L;
	 private String fieldName;
	 private String isRequired="N";
	 private String isActive="N";
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getIsRequired() {
		return isRequired;
	}
	public void setIsRequired(String isRequired) {
		this.isRequired = isRequired;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	 
}
