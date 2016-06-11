package com.java.erp.webapp.web.setup;

import java.util.List;

import com.java.erp.webapp.request.setup.BatchDetailsRequest;
import com.java.erp.webapp.request.setup.StudentAdmissionFieldRequest;
import com.java.erp.webapp.server.implementers.services.setup.BatchDetailsBean;
import com.java.erp.webapp.server.implementers.services.setup.StudentAdmissionFieldsBean;
import com.java.erp.webapp.server.interfaces.services.setup.BatchDetailsI;
import com.java.erp.webapp.server.interfaces.services.setup.StudentAdmissionFieldsI;
import com.java.erp.webapp.web.common.BaseAction;
import com.opensymphony.xwork2.ModelDriven;

public class StudentAdmissionFieldsAction extends BaseAction implements ModelDriven<StudentAdmissionFieldRequest>{
	StudentAdmissionFieldRequest studentAdmissionFieldsRequest;
	StudentAdmissionFieldsI bean;
public StudentAdmissionFieldsAction(){
	studentAdmissionFieldsRequest=new StudentAdmissionFieldRequest();
	bean=(StudentAdmissionFieldsBean)loadBean(StudentAdmissionFieldsBean.class);
}
public String getStudentAdmissionFields() throws Exception{
	 this.response=bean.getStudentAdmissionFields().getResponse();
	 List<Object> result=this.response.getResultList();
	 getServletRequest().setAttribute("studentadmissionfields", result.get(0));
	  	 return "studentadmissionfields";
}
public String saveStudentAdmissionFields() throws Exception{
	 this.response=bean.saveStudentAdmissionFields(getModel()).getResponse();
	 List<Object> result=this.response.getResultList();
	 getServletRequest().setAttribute("studentadmissionfields", result.get(0));
	 return "studentadmissionfields";
}

@Override
public StudentAdmissionFieldRequest getModel() {

	return this.studentAdmissionFieldsRequest;
}



}
