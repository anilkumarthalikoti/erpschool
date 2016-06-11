package com.java.erp.webapp.database.finance;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FeeStructurePk implements Serializable {
@Column(name="mapping_id")
private Long mappingId;
@Column(name="acyear")
private Long acYearId;

public Long getMappingId() {
	return mappingId;
}
public void setMappingId(Long mappingId) {
	this.mappingId = mappingId;
}
public Long getAcYearId() {
	return acYearId;
}
public void setAcYearId(Long acYearId) {
	this.acYearId = acYearId;
}
 

}
