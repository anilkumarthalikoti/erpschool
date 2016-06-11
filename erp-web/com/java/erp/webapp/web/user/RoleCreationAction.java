package com.java.erp.webapp.web.user;

import java.util.List;

import com.java.erp.webapp.database.user.Users;
import com.java.erp.webapp.request.user.LoginRequest;
import com.java.erp.webapp.server.implementers.services.user.LoginBean;
import com.java.erp.webapp.server.interfaces.services.user.LoginI;
import com.java.erp.webapp.web.common.BaseAction;
import com.opensymphony.xwork2.ModelDriven;

public class RoleCreationAction extends BaseAction implements ModelDriven<LoginRequest>{
	LoginRequest loginRequest;
	LoginI user;
public RoleCreationAction(){
	loginRequest=new LoginRequest();
	user=(LoginBean)loadBean(LoginBean.class);
}
public String home(){
	return "success";
}
public String validateLogin() throws Exception{
	loginRequest.setValid(false);

	this.response=user.validateLogin(getModel()).getResponse();
	if(!this.response.getResultList().isEmpty()){
		Users u=(Users) this.response.getResultList().get(0);
		loginRequest.setValid(true);
 		getHttpSession().setAttribute("LOGIN_DETAILS", u);
		
	}
	if(!this.response.getErrors().isEmpty())
	 loginRequest.setErrorMessage(this.response.getErrors().get(0));
	 getServletRequest().setAttribute("loadDashBoard", "Y");
	return "success";
}
public String logout() throws Exception{
	loginRequest.setValid(false);
	getHttpSession().invalidate();
	 
	 
	return "relogin";
}

public String checkForAdmin() throws Exception{
	 this.response=user.checkForAdmin().getResponse();
	 List<Object> result=this.response.getResultList();
	
	 if(Boolean.valueOf(result.get(0).toString())){
		 return "createAdmin";
	 }
	 if(getHttpSession().getAttribute("LOGIN_DETAILS")!=null){
		 return "home";
	 }
	return "login";
}

public String createAdmin() throws Exception{
	 this.response=user.createAdmin(getModel()).getResponse();
	 List<Object> result=this.response.getResultList();
	 
	 if(Boolean.valueOf(result.get(0).toString())){
		 loginRequest.setValid(false);
		 return "createAdmin";
	 }
	 loginRequest.setValid(true);
	return "login";
}


@Override
public LoginRequest getModel() {

	return this.loginRequest;
}



}
