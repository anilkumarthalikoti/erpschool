package com.java.erp.webapp.server.implementers.services.dashboard;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.java.erp.webapp.database.dashboard.ReminderDtl;
import com.java.erp.webapp.database.dashboard.Reminders;
import com.java.erp.webapp.request.dashboard.RemindersRequest;
import com.java.erp.webapp.server.exception.ExceptionMessageHandler;
import com.java.erp.webapp.server.implementers.services.common.BaseBean;
import com.java.erp.webapp.server.implementers.services.common.MessageConstants;
import com.java.erp.webapp.server.implementers.services.common.Result;
import com.java.erp.webapp.server.interfaces.services.common.Response;
import com.java.erp.webapp.server.interfaces.services.dashboard.ReminderBeanI;
@Service
public class ReminderBean extends BaseBean implements ReminderBeanI {

	@Override
	public Response getReminders(Byte viewType) throws Exception {
		// TODO Auto-generated method stub
		Response result=new Result();
		return result;
	}

	@Override
	public Response getDashboardReminders(Byte viewType) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response saveReminders(RemindersRequest reminderRequest)
			throws Exception {
		Response result=new Result();
		Reminders reminder=null;
		if(reminderRequest.getReminderId()==-1){
			reminder=new Reminders();
		}else{
			reminder=getReminderDao().getReminder(reminderRequest.getReminderId());
			if(null==reminder){
				throw new ExceptionMessageHandler(MessageConstants.INVALID_USER);
			}
		}
		Set<ReminderDtl> dtl=new HashSet<ReminderDtl>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		reminder.setReminderTitle(reminderRequest.getReminderTitle());
		reminder.setReminder(reminderRequest.getReminderText());
		reminder.setStartsOn(sdf.parse(reminderRequest.getStartFrom()));
		reminder.setReminderType(reminderRequest.getReminderType());
		try{
		reminder.setEndsOn(sdf.parse(reminderRequest.getEndsOn()));
		}catch(Exception e){}
		switch(reminderRequest.getReminderType()){
		case 1:
			//Every Day
			 
			
			 
getReminderDao().merge(reminder);
getReminderDao().flush();
			break;
		case 2:
			//On Date
			
			reminder.setEndsOn(sdf.parse(reminderRequest.getStartFrom()));
			
			getReminderDao().merge(reminder);
			getReminderDao().flush();
			break;
		case 3:
			//Weeek days
		 
			for(int i=0;i<reminderRequest.getWeekDays().length;i++){
				ReminderDtl dtl1=new ReminderDtl();
				dtl1.setReminderMaster(reminder);
				dtl1.setWeekMonthDays((Byte)reminderRequest.getWeekDays()[i]);
				dtl.add(dtl1);
			}
			reminder.setDtl(dtl);
			getReminderDao().merge(reminder);
			getReminderDao().flush();
			break;
		case 4:
			//Month days
			for(int i=0;i<reminderRequest.getMonthDays().length;i++){
				ReminderDtl dtl1=new ReminderDtl();
				dtl1.setReminderMaster(reminder);
				dtl1.setWeekMonthDays((Byte)reminderRequest.getMonthDays()[i]);
				dtl.add(dtl1);
			}
			reminder.setDtl(dtl);
			getReminderDao().merge(reminder);
			getReminderDao().flush();
			break;
		}
		return result;
	}

 

}
