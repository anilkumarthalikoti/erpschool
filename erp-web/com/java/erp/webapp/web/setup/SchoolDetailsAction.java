package com.java.erp.webapp.web.setup;

import java.util.List;

import com.java.erp.webapp.request.setup.SchoolDetailsRequest;
import com.java.erp.webapp.server.implementers.services.setup.SchoolDetailsBean;
import com.java.erp.webapp.server.interfaces.services.setup.SchoolDetailsI;
import com.java.erp.webapp.web.common.BaseAction;
import com.opensymphony.xwork2.ModelDriven;

public class SchoolDetailsAction extends BaseAction implements ModelDriven<SchoolDetailsRequest>{
	SchoolDetailsRequest schoolDetailsRequest;
	SchoolDetailsI bean;
public SchoolDetailsAction(){
	schoolDetailsRequest=new SchoolDetailsRequest();
	bean=(SchoolDetailsBean)loadBean(SchoolDetailsBean.class);
}
 public String getSchoolDetails() throws Exception{
	//	System.out.println(schoolDetailsRequest.getPreaction());
	 this.response=bean.getSchoolDetails().getResponse();
	 List<Object> result=this.response.getResultList();
	 getServletRequest().setAttribute("schoolDetails", result.get(0));
	 return "schoolDetails";
 }
 public String saveSchoolDetails() throws Exception{
	 this.response=bean.saveSchoolDetails(getModel()).getResponse();
	 List<Object> result=this.response.getResultList();
	 getServletRequest().setAttribute("schoolDetails", result.get(0));
	 return "schoolDetails";
 }

@Override
public SchoolDetailsRequest getModel() {

	return this.schoolDetailsRequest;
}



}
