package com.java.erp.webapp.database.dashboard;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.java.erp.webapp.database.project.BaseFields;

@Entity
@Table(name = "reminders")
public class Reminders extends BaseFields implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "reminder_id")
	private Long reminderId;
	@Column(name="title")
	private String reminderTitle;
	@Column(name = "reminder",nullable=false)
	private String reminder;
	@Column(name = "loginid")
	private String loginId;
	@Column(name="reminderType")
	private Byte reminderType;
	@Column(name="startsOn",nullable=false)
	private Date startsOn;
	@Column(name="endsOn")
	private Date endsOn;
	@OneToMany(cascade = CascadeType.ALL, targetEntity = ReminderDtl.class, mappedBy = "reminderMaster", fetch = FetchType.EAGER)
	Set<ReminderDtl> dtl = new HashSet<ReminderDtl>();
	public String getReminderTitle() {
		return reminderTitle;
	}
	public void setReminderTitle(String reminderTitle) {
		this.reminderTitle = reminderTitle;
	}
	public String getReminder() {
		return reminder;
	}
	public void setReminder(String reminder) {
		this.reminder = reminder;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public Byte getReminderType() {
		return reminderType;
	}
	public void setReminderType(Byte reminderType) {
		this.reminderType = reminderType;
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
	 
	public Long getReminderId() {
		return reminderId;
	}
	public Set<ReminderDtl> getDtl() {
		return dtl;
	}
	public void setDtl(Set<ReminderDtl> dtl) {
		this.dtl = dtl;
	}
	
	
 
}
