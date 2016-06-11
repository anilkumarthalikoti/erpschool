package com.java.erp.webapp.web.dashboard;

import com.java.erp.webapp.request.dashboard.RemindersRequest;
import com.java.erp.webapp.server.implementers.services.dashboard.ReminderBean;
import com.java.erp.webapp.server.interfaces.services.dashboard.ReminderBeanI;
import com.java.erp.webapp.web.common.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
public class ReminderAction extends BaseAction implements ModelDriven<RemindersRequest> {

	RemindersRequest reminderRequest=null;
	ReminderBeanI bean=null;
	public ReminderAction(){
		reminderRequest=new RemindersRequest();
		bean=(ReminderBean)loadBean(ReminderBean.class);
	}
	public String addReminder() throws Exception{
	return "reminder";
} 
public String saveReminder() throws Exception{
	response=bean.saveReminders(getModel()).getResponse();
	return "reminder";
}
@Override
public RemindersRequest getModel() {
	// TODO Auto-generated method stub
	return reminderRequest;
}
}
