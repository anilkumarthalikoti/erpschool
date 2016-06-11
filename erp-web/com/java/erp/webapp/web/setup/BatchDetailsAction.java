package com.java.erp.webapp.web.setup;

import java.util.List;

import com.java.erp.webapp.request.setup.BatchDetailsRequest;
import com.java.erp.webapp.server.implementers.services.setup.BatchDetailsBean;
import com.java.erp.webapp.server.interfaces.services.setup.BatchDetailsI;
import com.java.erp.webapp.web.common.BaseAction;
import com.opensymphony.xwork2.ModelDriven;

public class BatchDetailsAction extends BaseAction implements ModelDriven<BatchDetailsRequest>{
	BatchDetailsRequest batchDetailsRequest;
	BatchDetailsI bean;
public BatchDetailsAction(){
	batchDetailsRequest=new BatchDetailsRequest();
	bean=(BatchDetailsBean)loadBean(BatchDetailsBean.class);
}
public String getBatchDetails() throws Exception{
	 this.response=bean.getBatchDetails().getResponse();
	 List<Object> result=this.response.getResultList();
	 getServletRequest().setAttribute("subjectDetails", result.get(0));
	 getServletRequest().setAttribute("branchDetails", result.get(1));
	 getServletRequest().setAttribute("courseDetails", result.get(2));
	 getServletRequest().setAttribute("batchDetails", result.get(3));
	 return "batchDetails";
}
public String saveBatchDetails() throws Exception{
	 this.response=bean.saveBatchDetails(getModel()).getResponse();
	 List<Object> result=this.response.getResultList();
	 getServletRequest().setAttribute("subjectDetails", result.get(0));
	 getServletRequest().setAttribute("branchDetails", result.get(1));
	 getServletRequest().setAttribute("courseDetails", result.get(2));
	 getServletRequest().setAttribute("batchDetails", result.get(3));
	 return "batchDetails";
}

@Override
public BatchDetailsRequest getModel() {

	return this.batchDetailsRequest;
}



}
