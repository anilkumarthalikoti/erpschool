package com.java.erp.webapp.web.admission;

import java.util.List;

import com.java.erp.webapp.request.admission.AdmissionSettingsRequest;
import com.java.erp.webapp.server.implementers.services.admission.AdmissionSettingsBean;
import com.java.erp.webapp.server.interfaces.services.admission.AdmissionSettingsI;
import com.java.erp.webapp.web.common.BaseAction;
import com.opensymphony.xwork2.ModelDriven;

public class AdmissionSettingsAction extends BaseAction implements ModelDriven<AdmissionSettingsRequest>{
	AdmissionSettingsRequest admissionSettingsRequest;
	AdmissionSettingsI bean;
public AdmissionSettingsAction(){
	 admissionSettingsRequest=new AdmissionSettingsRequest();
	 bean=(AdmissionSettingsBean)loadBean(AdmissionSettingsBean.class);
}
public String getAdmissionSettingsList() throws Exception{
	 this.response=bean.getAdmissionSettingsList(getModel()).getResponse();
	 List<Object> result=this.response.getResultList();
	 getServletRequest().setAttribute("academicYear", result.get(0));
	 getServletRequest().setAttribute("batchDetails", result.get(1));
	 return "admissionsettings";
}
 
public String saveAdmissionSettings() throws Exception{
	 this.response=bean.saveAdmissionSettings(getModel()).getResponse();
	 List<Object> result=this.response.getResultList();
	 getServletRequest().setAttribute("academicYear", result.get(0));
	 getServletRequest().setAttribute("batchDetails", result.get(1));
	 return "admissionsettings";
}

@Override
public AdmissionSettingsRequest getModel() {

	return this.admissionSettingsRequest;
}



}
