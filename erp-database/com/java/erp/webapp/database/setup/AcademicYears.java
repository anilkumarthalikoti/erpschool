package com.java.erp.webapp.database.setup;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
 

import com.java.erp.webapp.database.project.BaseFields;
@Entity
@Table(name="gen_acyears")
public class AcademicYears extends BaseFields implements Serializable {
	private static final long serialVersionUID = 1L;

@Id
 @GeneratedValue
 private Long id;
 
@Column(name="acyear",nullable=false,unique=true)
private String academicYear;
@Column(name="active",nullable=false)
private String isActive;
@Column(name="app_prefix")
private String applicationPrefix;
@Column(name="series_from")
private String seriesFrom;
@Column(name="series_to")
private String seriesTo;

@Column(name="accept_from")
@Type(type="timestamp")
private Date acceptFrom;
@Column(name="accept_to")
@Type(type="timestamp")
private Date acceptTo;

public String getAcademicYear() {
	return academicYear;
}
public void setAcademicYear(String academicYear) {
	this.academicYear = academicYear;
}
public String getIsActive() {
	return isActive;
}
public void setIsActive(String isActive) {
	this.isActive = isActive;
}
public Long getId() {
	return id;
}
public String getApplicationPrefix() {
	return applicationPrefix;
}
public void setApplicationPrefix(String applicationPrefix) {
	this.applicationPrefix = applicationPrefix;
}
public String getSeriesFrom() {
	return seriesFrom;
}
public void setSeriesFrom(String seriesFrom) {
	this.seriesFrom = seriesFrom;
}
public String getSeriesTo() {
	return seriesTo;
}
public void setSeriesTo(String seriesTo) {
	this.seriesTo = seriesTo;
}
public Date getAcceptFrom() {
	return acceptFrom;
}
public void setAcceptFrom(Date acceptFrom) {
	this.acceptFrom = acceptFrom;
}
public Date getAcceptTo() {
	return acceptTo;
}
public void setAcceptTo(Date acceptTo) {
	this.acceptTo = acceptTo;
}

}
