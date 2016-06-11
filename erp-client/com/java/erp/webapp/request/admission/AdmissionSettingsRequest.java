package com.java.erp.webapp.request.admission;

import com.java.erp.webapp.request.common.BaseRequest;

public class AdmissionSettingsRequest extends BaseRequest {
private Long acYearId;
private Long courseId;
private Long branchId;
private String mode;//NO INTERVIEW OR INTERVIEW OR EXAM 
private Long[] mappingId;
public Long getAcYearId() {
	return acYearId;
}
public void setAcYearId(Long acYearId) {
	this.acYearId = acYearId;
}
public Long getCourseId() {
	return courseId;
}
public void setCourseId(Long courseId) {
	this.courseId = courseId;
}
public Long getBranchId() {
	return branchId;
}
public void setBranchId(Long branchId) {
	this.branchId = branchId;
}
public String getMode() {
	return mode;
}
public void setMode(String mode) {
	this.mode = mode;
}
public Long[] getMappingId() {
	return mappingId;
}
public void setMappingId(Long[] mappingId) {
	this.mappingId = mappingId;
}

}
