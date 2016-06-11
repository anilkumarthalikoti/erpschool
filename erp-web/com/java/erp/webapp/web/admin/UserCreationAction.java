package com.java.erp.webapp.web.admin;

import java.util.List;

import com.java.erp.webapp.database.user.Users;
import com.java.erp.webapp.request.admin.UserCreationRequest;
import com.java.erp.webapp.server.implementers.services.admin.UserCreationBean;
import com.java.erp.webapp.server.implementers.services.user.LoginBean;
import com.java.erp.webapp.server.interfaces.services.admin.UserCreationI;
import com.java.erp.webapp.web.common.BaseAction;
import com.opensymphony.xwork2.ModelDriven;

public class UserCreationAction extends BaseAction implements ModelDriven<UserCreationRequest>{
	UserCreationRequest userCreationRequest;
	UserCreationI userCretionBean;
public UserCreationAction(){
	userCreationRequest=new UserCreationRequest();
	userCretionBean=(UserCreationBean)loadBean(UserCreationBean.class);
}
 public String userCreation() throws Exception{
	 this.response=userCretionBean.getUserList().getResponse();
	 getServletRequest().setAttribute("users", this.response.getResultList().get(0));
	 return"userweb";
 }
 public String saveUserCreation() throws Exception{
	 this.response=userCretionBean.saveUserDetails(getModel()).getResponse();
	 getServletRequest().setAttribute("users", this.response.getResultList().get(0));
	 return"userweb";
 }
@Override
public UserCreationRequest getModel() {

	return this.userCreationRequest;
}



}
