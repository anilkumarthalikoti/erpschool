package com.java.erp.webapp.request.admission;

import com.java.erp.webapp.request.common.BaseRequest;



public class AdmissionExtraDetailsRequest extends BaseRequest {

	
	private String fieldName;
	private String feildType;
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFeildType() {
		return feildType;
	}
	public void setFeildType(String feildType) {
		this.feildType = feildType;
	}
	
}
