package com.java.erp.webapp.request.admission;

import com.java.erp.webapp.request.common.BaseRequest;

public class AdmissionSettingsRequest extends BaseRequest {
private Long[] acyear;
private String mode;//NO INTERVIEW OR INTERVIEW OR EXAM 
private Long[] mappingId;
public Long[] getAcyear() {
	return acyear;
}
public void setAcyear(Long[] acyear) {
	this.acyear = acyear;
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
