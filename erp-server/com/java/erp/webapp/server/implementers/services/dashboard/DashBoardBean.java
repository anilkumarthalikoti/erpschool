package com.java.erp.webapp.server.implementers.services.dashboard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.erp.webapp.database.user.Users;
import com.java.erp.webapp.server.implementers.services.common.BaseBean;
import com.java.erp.webapp.server.implementers.services.common.Result;
import com.java.erp.webapp.server.interfaces.services.common.Response;
import com.java.erp.webapp.server.interfaces.services.dashboard.DashBoardBeanI;
@Service
public class DashBoardBean extends BaseBean implements DashBoardBeanI {

	@Override
	public Response getDashBoard(Byte viewType,Object o) throws Exception {
		// TODO Auto-generated method stub
		Response result=new Result();
		List<Object>resultHolder=new ArrayList<Object>();
String userId=null;
		 
if(1==viewType){
//admin	
	resultHolder.add(getDashBoardDao().getFeePaymentsBranch());
	Users u=(Users)o;
	userId=u.getUserId();
		}
if(2==viewType){
	//teacher
}
if(3==viewType){
	//staff
}
resultHolder.add(null);
resultHolder.add(getReminderDao().getDashboardReminder(userId));
		result.setResultList(resultHolder);
		return result;
	}

}
