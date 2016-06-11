package com.java.erp.webapp.web.interceptors;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class ExceptionHandler implements Interceptor {
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		ActionContext context = actionInvocation.getInvocationContext();
		String actionResult = "login";
		String className=actionInvocation.getProxy().getConfig().getClassName();
		 
		return actionInvocation.invoke();
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init() {
	}

}
