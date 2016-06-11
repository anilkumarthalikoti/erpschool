package com.java.erp.webapp.database.dashboard;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.java.erp.webapp.database.project.BaseFields;


@Entity
@Table(name="reminders_dtl")
public class ReminderDtl extends BaseFields implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue
@Column(name="reminder_dtl_id")
private Long reminderDtlId;
 @Column(name="week_month_days")
 private byte weekMonthDays;
@ManyToOne
@JoinColumn(referencedColumnName = "reminder_id")
Reminders reminderMaster;
 
public byte getWeekMonthDays() {
	return weekMonthDays;
}
public void setWeekMonthDays(byte weekMonthDays) {
	this.weekMonthDays = weekMonthDays;
}
public Reminders getReminderMaster() {
	return reminderMaster;
}
public void setReminderMaster(Reminders reminderMaster) {
	this.reminderMaster = reminderMaster;
}
public Long getReminderDtlId() {
	return reminderDtlId;
}
 public String toString(){
	 return this.weekMonthDays+"";
 }
}
