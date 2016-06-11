package com.java.erp.webapp.web.project;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.java.erp.webapp.request.user.LoginRequest;
import com.java.erp.webapp.server.implementers.services.user.LoginBean;
import com.java.erp.webapp.web.common.BaseAction;

public class ApplicationListener extends BaseAction implements
		ServletContextListener {

	LoginBean loginBean;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("ServletContextListener destroyed");
	}

	// Run this before web application is started
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			loginBean = (LoginBean) loadBean(LoginBean.class);
			LoginRequest request = new LoginRequest();
			request.setLoginId("ADMINISTRATOR");
			request.setLoginPassword("erpAdmin");
			loginBean.createAdmin(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
