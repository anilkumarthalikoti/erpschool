package com.java.erp.webapp.db.implimentors.dashboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.java.erp.webapp.database.dashboard.Reminders;
import com.java.erp.webapp.database.setup.AcademicYears;
import com.java.erp.webapp.db.implimentors.common.BaseDAO;
import com.java.erp.webapp.db.interfaces.dashboard.ReminderDAOI;

public class ReminderDAO extends BaseDAO implements ReminderDAOI {

	@Override
	public Reminders getReminder(Long reminderId) throws Exception {
		 Reminders reminder=null;
		 Map params=new HashMap();
		 params.put("reminderId", reminderId);
		 String query="select r from Reminders r where r.reminderId=:reminderId";
		 try{
			 reminder=(Reminders)getSingleResult(query, params);
			 
		 }catch(Exception e){}
		 return reminder;
		 
	}

	@Override
	public List<Object[]> getDashboardReminder(String loginId) throws Exception {
		StringBuffer  query=new StringBuffer();
		query.append("select * from erp.reminders where (endsOn is null or endsOn>now()) and reminderType=1 and loginid=:loginId");
		query.append(" union ");
		query.append(" select * from erp.reminders where startsOn=DATE(now()) and reminderType=2  and loginid=:loginId ");
		query.append(" union ");
		query.append(" select * from reminders  where (endsOn is null or endsOn>now()) and reminderType=3 and exists (select 1 from reminders_dtl where reminderMaster_reminder_id= reminder_id and week_month_days=(select weekday(now())) )  and loginid=:loginId ");
		query.append(" union ");
		query.append(" select * from erp.reminders where (endsOn is null or endsOn>now()) and reminderType=4 and exists (select 1 from reminders_dtl where reminderMaster_reminder_id= reminder_id and week_month_days=(select dayofmonth(now())) )  and loginid=:loginId ");
		
		List<Object[]> reminder=null;
		 Map params=new HashMap();
		 params.put("loginId", loginId);
	 
		 try{
			 reminder= getNativeResultList(query.toString(), params);
			 
		 }catch(Exception e){}
		 return reminder;
		 
	}

}
