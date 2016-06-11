package com.java.erp.webapp.web.interceptors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.java.erp.webapp.web.common.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.interceptor.PreResultListener;
import com.opensymphony.xwork2.util.ValueStack;
 

public class LoginInterceptor implements Interceptor {
private static int count=0;
	/**
	 * 
	 */
	private static final Logger logger = Logger.getLogger(LoginInterceptor.class);
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {

	}

	@Override
	public void init() {

	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		ActionContext context = actionInvocation.getInvocationContext();
		 
		String actionResult = "login";
		 String status="0";
		 String message="";
		String tempActionResult = "";
		StringBuffer requestFrom = new StringBuffer();
		requestFrom.append("\nRequest Url\t\t:\t");
		requestFrom.append(actionInvocation.getProxy().getActionName()+".action");
		requestFrom.append("\nRequest Class\t\t:\t");
		requestFrom.append(actionInvocation.getProxy().getConfig().getClassName());
		requestFrom.append("\nRequest Class Method\t:\t");
		requestFrom.append( actionInvocation.getProxy().getConfig().getMethodName());
		HttpSession session = ServletActionContext.getRequest().getSession(true);
	 session.removeAttribute("status_code");
	 session.removeAttribute("message_code");
		Map<String, Object> sessionMap = context.getSession();
		
		System.out.println(requestFrom);
 if(null!=ServletActionContext.getRequest().getParameter("preaction")){
	 session.setAttribute("preaction", ServletActionContext.getRequest().getParameter("preaction"));
	 session.setAttribute("reload","true");
 } 
		 if(count>1){
			 
			 System.out.println(count);
			 count=0;
		 }else{
			 count++;
		 }
		tempActionResult = actionInvocation.getInvocationContext().getName();
		List<String> skipUrl = new ArrayList<String>();
		skipUrl.add("login");
		skipUrl.add("validatelogin");
		skipUrl.add("index");
		skipUrl.add("createadmin");
		skipUrl.add("logout");
		skipUrl.add("onLoadForgotPwd");
actionInvocation.addPreResultListener(new PreResultListener() {
	
	@Override
	public void beforeResult(ActionInvocation arg0, String arg1) {
	 String status="0",message="";
	 	ValueStack vs=arg0.getStack();
		BaseAction params =(BaseAction) vs.getContext().get("action");
		if(null!=params.response && null!=params.response.getSuccess()   ){
			if(params.response.getSuccess().size()>0){
				status="1";
				message=params.response.getSuccess().get(0);
		}
		}
		if(null!=params.response && null!=params.response.getErrors()   ){
			if(params.response.getErrors().size()>0){
				status="-1";
				 message=params.response.getErrors().get(0);
		}
		}
		 
		ServletActionContext.getRequest().setAttribute("status_code", status);
		ServletActionContext.getRequest().setAttribute("message_code", message);
 
	}
});
		if ((null == sessionMap) || (sessionMap.isEmpty())) {
			if (skipUrl.contains(tempActionResult)) {
				try {
					actionResult = actionInvocation.invoke();
				} catch (Exception e) {
					logger.error(e.getMessage());
					session.setAttribute("ERROR_MSG", e.getMessage());
					return "error_msg";
 
				}
			} else {
				actionResult = "relogin";
			}
			session.setAttribute("preaction", ServletActionContext.getRequest().getParameter("preaction"));
			 session.setAttribute("reload","false");
		} else {
			try {
				actionResult = actionInvocation.invoke();
				
			} catch (Exception e) {
				//logger.error(e.getMessage());
				e.printStackTrace();
				session.setAttribute("ERROR_MSG", e.getMessage());
				return "error_msg";
//e.printStackTrace();
			}
		}
	 
		return actionResult;
	}

}
