package com.java.erp.webapp.web.dashboard;

import com.java.erp.webapp.database.user.Users;
import com.java.erp.webapp.server.implementers.services.dashboard.DashBoardBean;
import com.java.erp.webapp.server.interfaces.services.dashboard.DashBoardBeanI;
import com.java.erp.webapp.web.common.BaseAction;

public class DashBoardAction extends BaseAction{
	DashBoardBeanI bean;
	public DashBoardAction() {
		bean=(DashBoardBean)loadBean(DashBoardBean.class);
	}
public String dashboard() throws Exception{
	String response="default";
	Users u=(Users)getHttpSession().getAttribute("LOGIN_DETAILS");
	this.response=bean.getDashBoard(u.getDashboardView(),u);
	getServletRequest().setAttribute("result", this.response.getResultList());
	if(1==u.getDashboardView()){
		 
		response="admin";
	}
	if(2==u.getDashboardView()){
		response="teacher";
	}
	if(3==u.getDashboardView()){
		response="staff";
	}
	return response;
}
}
