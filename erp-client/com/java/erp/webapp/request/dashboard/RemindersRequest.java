package com.java.erp.webapp.request.dashboard;

import com.java.erp.webapp.request.common.BaseRequest;

public class RemindersRequest extends BaseRequest {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Long reminderId;
private String reminderText;
private byte reminderType;
private String startFrom;
private String endsOn;
private Byte[] weekDays;
private Byte[] monthDays;
private String stauts;
private String reminderTitle;
public Long getReminderId() {
	return reminderId;
}
public void setReminderId(Long reminderId) {
	this.reminderId = reminderId;
}
public String getReminderText() {
	return reminderText;
}
public void setReminderText(String reminderText) {
	this.reminderText = reminderText;
}
public byte getReminderType() {
	return reminderType;
}
public void setReminderType(byte reminderType) {
	this.reminderType = reminderType;
}
public String getStartFrom() {
	return startFrom;
}
public void setStartFrom(String startFrom) {
	this.startFrom = startFrom;
}
public String getEndsOn() {
	return endsOn;
}
public void setEndsOn(String endsOn) {
	this.endsOn = endsOn;
}
public Byte[] getWeekDays() {
	return weekDays;
}
public void setWeekDays(Byte[] weekDays) {
	this.weekDays = weekDays;
}
public Byte[] getMonthDays() {
	return monthDays;
}
public void setMonthDays(Byte[] monthDays) {
	this.monthDays = monthDays;
}
public String getStauts() {
	return stauts;
}
public void setStauts(String stauts) {
	this.stauts = stauts;
}
public String getReminderTitle() {
	return reminderTitle;
}
public void setReminderTitle(String reminderTitle) {
	this.reminderTitle = reminderTitle;
}
 

}
