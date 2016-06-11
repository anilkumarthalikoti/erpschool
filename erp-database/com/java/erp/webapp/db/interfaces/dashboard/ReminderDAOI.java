package com.java.erp.webapp.db.interfaces.dashboard;

import java.util.List;

import com.java.erp.webapp.database.dashboard.Reminders;
import com.java.erp.webapp.db.interfaces.common.BaseDAOI;

public interface ReminderDAOI extends BaseDAOI {
public Reminders  getReminder(Long reminderId) throws Exception;
public List<Object[]> getDashboardReminder(String loginId) throws Exception; 
}
