package com.java.erp.webapp.web.setup;

import java.util.List;

import com.java.erp.webapp.request.setup.SubjectDetailsRequest;
import com.java.erp.webapp.server.implementers.services.setup.SubjectDetailsBean;
import com.java.erp.webapp.server.interfaces.services.setup.SubjectDetailsI;
import com.java.erp.webapp.web.common.BaseAction;
import com.opensymphony.xwork2.ModelDriven;

public class SubjectDetailsAction extends BaseAction implements ModelDriven<SubjectDetailsRequest>{
	SubjectDetailsRequest subjectDetailsRequest;
	SubjectDetailsI bean;
public SubjectDetailsAction(){
	subjectDetailsRequest=new SubjectDetailsRequest();
	bean=(SubjectDetailsBean)loadBean(SubjectDetailsBean.class);
}
public String getSubjectDetails() throws Exception{
	 this.response=bean.getSubjectDetails().getResponse();
	 List<Object> result=this.response.getResultList();
	 getServletRequest().setAttribute("subjectDetails", result.get(0));
	 return "subjectDetails";
}
public String saveSubjectDetails() throws Exception{
	 this.response=bean.saveSubjectDetails(getModel()).getResponse();
	 List<Object> result=this.response.getResultList();
	 getServletRequest().setAttribute("subjectDetails", result.get(0));
	 return "subjectDetails";
}
@Override
public SubjectDetailsRequest getModel() {

	return this.subjectDetailsRequest;
}



}
