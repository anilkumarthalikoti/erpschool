package com.java.erp.webapp.web.student;

import java.util.List;

import com.java.erp.webapp.request.setup.CourseDetailsRequest;
import com.java.erp.webapp.request.student.StudentDetailsRequest;
import com.java.erp.webapp.server.implementers.services.student.StudentDetailsBean;
import com.java.erp.webapp.server.interfaces.services.student.StudentDetailsI;
import com.java.erp.webapp.web.common.BaseAction;
import com.opensymphony.xwork2.ModelDriven;

public class StudentDetailsAction extends BaseAction implements ModelDriven<StudentDetailsRequest>{
	StudentDetailsRequest studentDetailsRequest;
	StudentDetailsI bean;
public StudentDetailsAction(){
	 studentDetailsRequest=new StudentDetailsRequest();
	 bean=(StudentDetailsBean)loadBean(StudentDetailsBean.class);
}
public String getStudentList() throws Exception{
	 this.response=bean.getStudentList(getModel()).getResponse();
	 List<Object> result=this.response.getResultList();
	 getServletRequest().setAttribute("studentlist", result.get(0));
	 return "studentsearch";
}
 
@Override
public StudentDetailsRequest getModel() {

	return this.studentDetailsRequest;
}



}
