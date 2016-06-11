package com.java.erp.webapp.web.common;

import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.java.erp.webapp.server.interfaces.services.common.Response;

import freemarker.template.Configuration;
import freemarker.template.Template;
@Component
public class BaseAction implements ApplicationContextAware, ServletRequestAware, ServletResponseAware {
	public static Configuration cfg;
	private HttpServletRequest httpRequest;
	private HttpServletResponse httpResponse;
	private HttpSession httpSession;
	public Response response;
	public String status;
	public String message;
 	public final HttpServletRequest getServletRequest() {
		return this.httpRequest;
	}
 	public final HttpServletResponse getServletResponse() {
		return this.httpResponse;
	}

	@Override
	public final void setServletRequest(final HttpServletRequest request) {
		this.httpRequest = request;

	}
	@Override
	public final void setServletResponse(final HttpServletResponse response) {
		this.httpResponse = response;

	}
	public final HttpSession getHttpSession() {
		httpSession = httpRequest.getSession(true);
		return this.httpSession;
	}
	public final void setHttpSession(final HttpSession httpSession) {
		this.httpSession = httpSession;
	}
	
	
	public Template loadTemplate(String filename,String subpath) {
		if (null == cfg) {
			cfg = new Configuration(Configuration.VERSION_2_3_22);
			try {
				cfg.setDirectoryForTemplateLoading(new File(
						ServletActionContext.getServletContext().getRealPath(
								"/")
								+subpath));
			} catch (Exception e) {

			}
		}
		Template _template = null;
		try {
			_template = cfg.getTemplate(filename);
		} catch (Exception e) {
		}
		return _template;
	}

	public String loadTemplateData(String filename, Map<Object,Object> data,String subpath) {
		if (null == cfg) {
			cfg = new Configuration(Configuration.VERSION_2_3_22);
			try {
				cfg.setDirectoryForTemplateLoading(new File(
						ServletActionContext.getServletContext().getRealPath(
								"/")
								+ subpath));
			} catch (Exception e) {

			}
		}
		Template _template = null;
		try {
			_template = cfg.getTemplate(filename);
		} catch (Exception e) {
		}
		Writer w = new StringWriter();
		try {
			_template.process(data, w);
		} catch (Exception e) {
		}
		return w.toString();
	}
	private static ApplicationContext CONTEXT;

	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
	   // System.out.println("LOADED APPLICAtion contEXT");
		CONTEXT = ctx;
	}

	public static Object getBean(String name) {
		//System.out.println(name);
	    return CONTEXT.getBean(name);
	}
	public Object loadBean(Class o){
		String name="";
		try{
			name=o.newInstance().getClass().getName();
		//System.out.println(name);
		}catch(Exception e){
			
		}
		return getBean(name);
	}
}