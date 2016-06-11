package com.java.erp.webapp.database.student;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import com.java.erp.webapp.database.project.BaseFields;
@Entity
@Table(name="stu_student_details")
public class StudentDetails extends BaseFields implements Serializable {
private static final long serialVersionUID = 1L;
@Id	
@Column(name="ref_no")
private Long id;
@Column(name="application_no",unique=true,nullable=false)
private String applicationNo;
@Column(name="student_id")
private String studentId;
@Column(name="admission_no")
private String admissionNo;
@Column(name="requested_course")
private Long requestedCourse;
@Column(name="application_date",insertable=false)
@Type(type="timestamp")
@Temporal(TemporalType.TIMESTAMP)
private Date appliedDate;
@Column(name="student_name",length=120)
private String studentName;
@Column(name="father_name",length=120)
private String fatherName;
@Column(name="mother_name",length=120)
private String motherName;
@Column(name="contactNo",length=13)
private String contactNo;
@Column(name="address")
private String address;
@Column(name="application_status")
private String applicationStatus;
public String getApplicationNo() {
	return applicationNo;
}
public void setApplicationNo(String applicationNo) {
	this.applicationNo = applicationNo;
}
public String getStudentId() {
	return studentId;
}
public void setStudentId(String studentId) {
	this.studentId = studentId;
}
public String getAdmissionNo() {
	return admissionNo;
}
public void setAdmissionNo(String admissionNo) {
	this.admissionNo = admissionNo;
}
 
public Date getAppliedDate() {
	return appliedDate;
}
public void setAppliedDate(Date appliedDate) {
	this.appliedDate = appliedDate;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public String getFatherName() {
	return fatherName;
}
public void setFatherName(String fatherName) {
	this.fatherName = fatherName;
}
public String getMotherName() {
	return motherName;
}
public void setMotherName(String motherName) {
	this.motherName = motherName;
}
public String getContactNo() {
	return contactNo;
}
public void setContactNo(String contactNo) {
	this.contactNo = contactNo;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Long getId() {
	return id;
}
public Long getRequestedCourse() {
	return requestedCourse;
}
public void setRequestedCourse(Long requestedCourse) {
	this.requestedCourse = requestedCourse;
}
public String getApplicationStatus() {
	return applicationStatus;
}
public void setApplicationStatus(String applicationStatus) {
	this.applicationStatus = applicationStatus;
}








}
