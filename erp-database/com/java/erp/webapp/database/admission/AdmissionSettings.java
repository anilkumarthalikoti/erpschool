package com.java.erp.webapp.database.admission;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.java.erp.webapp.database.project.BaseFields;
@Entity
@Table(name="adm_settings")
public class AdmissionSettings extends BaseFields implements Serializable {
@EmbeddedId
private AdmissionSettingsPk id=new AdmissionSettingsPk();
@Column(name="adm_mode" ,length=1)
private String admissionMode;
@Column(name="interview_date_from")
private Date interviewDateFrom;
@Column(name="interview_date_to")
private Date interviewDateTo;
@Column(name="examAt")
private String examAt;
@Column(name="examLocation")
private String locationAt;
@Column(name="slot_capacity")
private Long slotCapacity;
@Column(name="interview_mode" ,length=1)
private String interviewMode;
public AdmissionSettingsPk getId() {
	return id;
}
public void setId(AdmissionSettingsPk id) {
	this.id = id;
}
public String getAdmissionMode() {
	return admissionMode;
}
public void setAdmissionMode(String admissionMode) {
	this.admissionMode = admissionMode;
}
public Date getInterviewDateFrom() {
	return interviewDateFrom;
}
public void setInterviewDateFrom(Date interviewDateFrom) {
	this.interviewDateFrom = interviewDateFrom;
}
public Date getInterviewDateTo() {
	return interviewDateTo;
}
public void setInterviewDateTo(Date interviewDateTo) {
	this.interviewDateTo = interviewDateTo;
}
public String getExamAt() {
	return examAt;
}
public void setExamAt(String examAt) {
	this.examAt = examAt;
}
public String getLocationAt() {
	return locationAt;
}
public void setLocationAt(String locationAt) {
	this.locationAt = locationAt;
}
public Long getSlotCapacity() {
	return slotCapacity;
}
public void setSlotCapacity(Long slotCapacity) {
	this.slotCapacity = slotCapacity;
}
public String getInterviewMode() {
	return interviewMode;
}
public void setInterviewMode(String interviewMode) {
	this.interviewMode = interviewMode;
}





}
