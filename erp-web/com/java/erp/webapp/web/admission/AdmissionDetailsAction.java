package com.java.erp.webapp.web.admission;

import java.util.List;

import com.java.erp.webapp.request.admission.AdmissionDetailsRequest;
import com.java.erp.webapp.request.student.StudentDetailsRequest;
import com.java.erp.webapp.server.implementers.services.admission.AdmissionDetailsBean;
import com.java.erp.webapp.server.interfaces.services.admission.AdmissionDetailsI;
import com.java.erp.webapp.web.common.BaseAction;
import com.opensymphony.xwork2.ModelDriven;

public class AdmissionDetailsAction extends BaseAction implements ModelDriven<AdmissionDetailsRequest>{
	AdmissionDetailsRequest admissionDetailsRequest;
	AdmissionDetailsI bean;
public AdmissionDetailsAction(){
	 admissionDetailsRequest=new AdmissionDetailsRequest();
	 bean= (AdmissionDetailsBean)loadBean(AdmissionDetailsBean.class);
}
public String getAdmissionList() throws Exception{
	 this.response=bean.getAdmissionList(getModel()).getResponse();
	 List<Object> result=this.response.getResultList();
	 getServletRequest().setAttribute("studentlist", result.get(0));
	 return "admission";
}
 
@Override
public AdmissionDetailsRequest getModel() {

	return this.admissionDetailsRequest;
}



}
