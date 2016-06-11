package com.java.erp.webapp.web.admission;

import java.util.List;

import com.java.erp.webapp.request.admission.AdmissionAuthorizationRequest;
import com.java.erp.webapp.server.implementers.services.admission.AdmissionAuthorizationBean;
import com.java.erp.webapp.server.interfaces.services.admission.AdmissionAuthorizationI;
import com.java.erp.webapp.web.common.BaseAction;
import com.opensymphony.xwork2.ModelDriven;

public class AdmissionAuthorizationAction extends BaseAction implements ModelDriven<AdmissionAuthorizationRequest>{
	AdmissionAuthorizationRequest admissionDetailsRequest;
	AdmissionAuthorizationI bean;
public AdmissionAuthorizationAction(){
	 admissionDetailsRequest=new AdmissionAuthorizationRequest();
	 bean=(AdmissionAuthorizationBean)loadBean(AdmissionAuthorizationBean.class);
}
public String getAdmissionAuthorizationList() throws Exception{
	 this.response=bean.getAdmissionAuthorizationList(getModel()).getResponse();
	 List<Object> result=this.response.getResultList();
	 getServletRequest().setAttribute("academicYear", result.get(0));
	 return "admissionauthorization";
}
 
public String saveAdmissionAuthorizationList() throws Exception{
	 this.response=bean.saveAdmissionAuthorizationList(getModel()).getResponse();
	 List<Object> result=this.response.getResultList();
	 getServletRequest().setAttribute("academicYear", result.get(0));
	 return "admissionauthorization";
}

@Override
public AdmissionAuthorizationRequest getModel() {

	return this.admissionDetailsRequest;
}



}
