package com.java.erp.webapp.database.student;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import com.java.erp.webapp.database.project.BaseFields;
@Entity
@Table(name="gen_student_history")
public class StudentHistory extends BaseFields implements Serializable {
private static final long serialVersionUID = 1L;
@Id	
@Column(name="history_id")
@GeneratedValue
private Long historyId;
@Column(name="ref_no",nullable=false)
private Long refId;
@Column(name="acd_id",nullable=false)
private Long acedemicYear;
@Column(name="batchId",nullable=false)
private Long batchId;
public Long getRefId() {
	return refId;
}
public void setRefId(Long refId) {
	this.refId = refId;
}
public Long getAcedemicYear() {
	return acedemicYear;
}
public void setAcedemicYear(Long acedemicYear) {
	this.acedemicYear = acedemicYear;
}
public Long getBatchId() {
	return batchId;
}
public void setBatchId(Long batchId) {
	this.batchId = batchId;
}
public Long getHistoryId() {
	return historyId;
}







}
