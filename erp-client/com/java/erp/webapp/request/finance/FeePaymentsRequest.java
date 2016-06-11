package com.java.erp.webapp.request.finance;

import com.java.erp.webapp.request.common.BaseRequest;

public class FeePaymentsRequest extends BaseRequest {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 private String studentId;
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	 
}
