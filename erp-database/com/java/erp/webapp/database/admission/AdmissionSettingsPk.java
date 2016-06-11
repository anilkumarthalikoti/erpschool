package com.java.erp.webapp.database.admission;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AdmissionSettingsPk implements Serializable {
@Column(name="acyear_id",nullable=false)
private Long acYearId;
@Column(name="mappingId",nullable=false)
private Long mappingId;
public Long getAcYearId() {
	return acYearId;
}
public void setAcYearId(Long acYearId) {
	this.acYearId = acYearId;
}
public Long getMappingId() {
	return mappingId;
}
public void setMappingId(Long mappingId) {
	this.mappingId = mappingId;
}
 



}
