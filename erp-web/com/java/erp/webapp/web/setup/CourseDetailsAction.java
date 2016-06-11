package com.java.erp.webapp.web.setup;

import java.util.List;

import com.java.erp.webapp.request.setup.BranchDetailsRequest;
import com.java.erp.webapp.request.setup.CourseDetailsRequest;
import com.java.erp.webapp.server.implementers.services.setup.CourseDetailsBean;
import com.java.erp.webapp.server.interfaces.services.setup.CourseDetailsI;
import com.java.erp.webapp.web.common.BaseAction;
import com.opensymphony.xwork2.ModelDriven;

public class CourseDetailsAction extends BaseAction implements ModelDriven<CourseDetailsRequest>{
	CourseDetailsRequest courseDetailsRequest;
	CourseDetailsI bean;
public CourseDetailsAction(){
	courseDetailsRequest=new CourseDetailsRequest();
	bean=(CourseDetailsBean) loadBean(CourseDetailsBean.class);
}
public String getCourseDetails() throws Exception{
	 this.response=bean.getCourseDetails().getResponse();
	 List<Object> result=this.response.getResultList();
	 getServletRequest().setAttribute("courseDetails", result.get(0));
	 return "courseDetails";
}
public String saveCourseDetails() throws Exception{
	 this.response=bean.saveCourseDetails(getModel()).getResponse();
	 List<Object> result=this.response.getResultList();
	 getServletRequest().setAttribute("courseDetails", result.get(0));
	 return "courseDetails";
}
@Override
public CourseDetailsRequest getModel() {

	return this.courseDetailsRequest;
}



}
