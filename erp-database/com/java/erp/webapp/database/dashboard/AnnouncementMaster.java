package com.java.erp.webapp.database.dashboard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.java.erp.webapp.database.project.BaseFields;


@Entity
@Table(name="announcements")
public class AnnouncementMaster extends BaseFields implements Serializable{
@Id
@Column(name="announcementId")
@GeneratedValue
private Long announcementId;
@Column(name="message")
private String announcementMessage;
@Column(name="repetation")
private String repetation;
@Column(name="startsOn")
private Date startsOn;
@Column(name="endsOn")
private Date endsOn;
@OneToMany
List<AnnouncementDtl> dtl=new ArrayList<AnnouncementDtl>();
public String getAnnouncementMessage() {
	return announcementMessage;
}
public void setAnnouncementMessage(String announcementMessage) {
	this.announcementMessage = announcementMessage;
}
public String getRepetation() {
	return repetation;
}
public void setRepetation(String repetation) {
	this.repetation = repetation;
}
public Date getStartsOn() {
	return startsOn;
}
public void setStartsOn(Date startsOn) {
	this.startsOn = startsOn;
}
public Date getEndsOn() {
	return endsOn;
}
public void setEndsOn(Date endsOn) {
	this.endsOn = endsOn;
}
public List<AnnouncementDtl> getDtl() {
	return dtl;
}
public void setDtl(List<AnnouncementDtl> dtl) {
	this.dtl = dtl;
}
public Long getAnnouncementId() {
	return announcementId;
}



}
