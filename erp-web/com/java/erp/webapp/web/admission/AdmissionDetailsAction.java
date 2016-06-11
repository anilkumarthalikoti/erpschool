package com.java.erp.webapp.web.admission;

import java.util.List;

import com.java.erp.webapp.request.admission.AdmissionDetailsRequest;
import com.java.erp.webapp.request.student.StudentDetailsRequest;
import com.java.erp.webapp.server.implementers.services.admission.AdmissionDetailsBean;
import com.java.erp.webapp.server.interfaces.services.admission.AdmissionDetailsI;
import com.java.erp.webapp.web.common.BaseAction;
import com.java.erp.webapp.web.common.ImageUpload;
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
	 getServletRequest().setAttribute("courseDetails", result.get(1));
	 return "admission";
}
public String getAdmissionAcceptRejectList() throws Exception{
	 this.response=bean.getAdmissionList(getModel()).getResponse();
	 List<Object> result=this.response.getResultList();
	 getServletRequest().setAttribute("studentlist", result.get(0));
	 getServletRequest().setAttribute("courseDetails", result.get(1));
	 getServletRequest().setAttribute("accRej", "true");
	 return "admission";
}
public String saveAdmissionStudent() throws Exception{
	this.response=bean.saveAdmissionDetails(getModel()).getResponse();
	if(null!=getModel().getStudentImg()){
		ImageUpload upload=new ImageUpload();
		upload.setWidth(80);
		upload.setHeight(100);
		upload.setActualFileName(getModel().getFileName());
		upload.setFileName(getModel().getApplicationNo());
		upload.setFileUpload(getModel().getStudentImg());
		upload.setRequest(getServletRequest());
		upload.setFolder("/docs/"+getModel().getApplicationNo()+"/");
		upload.uploadImageFile();
	}
	return "admission";
} 

public String saveAcceptRejectAdmission() throws Exception{
	this.response=bean.saveAcceptRejectAdmission(getModel()).getResponse();
	 
	return "admission";
} 
@Override
public AdmissionDetailsRequest getModel() {

	return this.admissionDetailsRequest;
}



}
