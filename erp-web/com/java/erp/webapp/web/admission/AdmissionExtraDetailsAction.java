package com.java.erp.webapp.web.admission;

import java.util.List;

import com.java.erp.webapp.request.admission.AdmissionDetailsRequest;
import com.java.erp.webapp.request.admission.AdmissionExtraDetailsRequest;
import com.java.erp.webapp.server.implementers.services.admission.AdmissionDetailsBean;
import com.java.erp.webapp.server.interfaces.services.admission.AdmissionDetailsI;
import com.java.erp.webapp.web.common.BaseAction;
import com.opensymphony.xwork2.ModelDriven;

public class AdmissionExtraDetailsAction extends BaseAction implements ModelDriven<AdmissionExtraDetailsRequest>{
	AdmissionExtraDetailsRequest admissionDetailsRequest;
	AdmissionDetailsI bean;
public AdmissionExtraDetailsAction(){
	 admissionDetailsRequest=new AdmissionExtraDetailsRequest();
	 bean= (AdmissionDetailsBean)loadBean(AdmissionDetailsBean.class);
}
public String getAdmissionExtraList() throws Exception{
	 
	 return "getAdmissionExtraList";
}
 
@Override
public AdmissionExtraDetailsRequest getModel() {

	return this.admissionDetailsRequest;
}



}
