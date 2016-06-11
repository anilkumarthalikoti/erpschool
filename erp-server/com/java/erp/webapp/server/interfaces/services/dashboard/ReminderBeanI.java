package com.java.erp.webapp.server.interfaces.services.dashboard;

import com.java.erp.webapp.request.dashboard.RemindersRequest;
import com.java.erp.webapp.server.interfaces.services.common.Response;

public interface ReminderBeanI {
public Response getReminders(Byte viewType) throws Exception;
public Response getDashboardReminders(Byte viewType) throws Exception;
public Response saveReminders(RemindersRequest reminderRequest) throws Exception;


}
