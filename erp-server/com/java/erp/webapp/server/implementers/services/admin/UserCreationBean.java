package com.java.erp.webapp.server.implementers.services.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.erp.webapp.database.user.Users;
import com.java.erp.webapp.request.admin.UserCreationRequest;
import com.java.erp.webapp.request.user.LoginRequest;
import com.java.erp.webapp.server.implementers.services.common.BaseBean;
import com.java.erp.webapp.server.implementers.services.common.Result;
import com.java.erp.webapp.server.interfaces.services.admin.UserCreationI;
import com.java.erp.webapp.server.interfaces.services.common.Response;
@Service
public class UserCreationBean extends BaseBean implements UserCreationI {
	private static final long serialVersionUID = 1L;

	@Override
	public Response getUserList() throws Exception {
		Response result=new Result();
	List<Object> resultHolder=new ArrayList<Object>();
	resultHolder.add(getLoginDao().getUsers(new LoginRequest()));
	result.setResultList(resultHolder);
		return result;
	}
	@Override
	public Response saveUserDetails(UserCreationRequest request) throws Exception {
		Response result=new Result();
		Users u=null;
		LoginRequest l=new LoginRequest();
		l.setLoginId(request.getUserId());
		u=getLoginDao().getUser(l);
		if(null==u){
			u=new Users();
	u.setUserId(request.getUserId());
	u.setDashboardView(request.getDashBoardView());
	u.setIsActive(true);
	u.setIsAdmin("N");
	u.setName(request.getUserName());
	u.setMailId(request.getMailId());
	u.setPhoneNo(request.getMobileNo());
	u.setPassword(request.getLoginPassword());
	getLoginDao().persist(u);
	getLoginDao().flush();
	
		}else{
			
		}
	List<Object> resultHolder=new ArrayList<Object>();
	resultHolder.add(getLoginDao().getUsers(new LoginRequest()));
	result.setResultList(resultHolder);
		return result;
	}
	 
}
