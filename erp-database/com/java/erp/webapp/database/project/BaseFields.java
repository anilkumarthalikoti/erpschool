package com.java.erp.webapp.database.project;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@MappedSuperclass
public class BaseFields implements Serializable {
@Column(name="updated_by")
	private Long updatedBy;
@Column(name="updated_time")
@Temporal(TemporalType.TIMESTAMP)
private Date updatedTime=new Date();
public Long getUpdatedBy() {
	return updatedBy;
}
public void setUpdatedBy(Long updatedBy) {
	this.updatedBy = updatedBy;
}
public Date getUpdatedTime() {
	 
 
	return updatedTime;
}
public void setUpdatedTime(Date updatedTime) {
	 
	this.updatedTime = new Date();
}
 
}
