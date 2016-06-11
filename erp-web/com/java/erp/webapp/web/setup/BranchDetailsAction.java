package com.java.erp.webapp.web.setup;

import java.util.List;

import com.java.erp.webapp.request.setup.BranchDetailsRequest;
import com.java.erp.webapp.request.setup.SchoolDetailsRequest;
import com.java.erp.webapp.server.implementers.services.setup.BranchDetailsBean;
import com.java.erp.webapp.server.interfaces.services.setup.BranchDetailsI;
import com.java.erp.webapp.web.common.BaseAction;
import com.opensymphony.xwork2.ModelDriven;

public class BranchDetailsAction extends BaseAction implements ModelDriven<BranchDetailsRequest>{
	BranchDetailsRequest branchDetailsRequest;
	BranchDetailsI bean;
public BranchDetailsAction(){
	branchDetailsRequest=new BranchDetailsRequest();
	bean=(BranchDetailsBean)loadBean(BranchDetailsBean.class);
}
 public String getBranchDetails() throws Exception{
	 this.response=bean.getBranchDetails().getResponse();
	 List<Object> result=this.response.getResultList();
	 getServletRequest().setAttribute("branchDetails", result.get(0));
	 return "branchDetails";
 }
 public String saveBranchDetails() throws Exception{
	 this.response=bean.saveBranchDetails(getModel()).getResponse();
	 List<Object> result=this.response.getResultList();
	 getServletRequest().setAttribute("branchDetails", result.get(0));
	 System.out.println("-------------Result----------");
	 System.out.println(getServletRequest().getSession().getAttribute("status_code"));
	 System.out.println(getServletRequest().getSession().getAttribute("message_code"));
	 return "branchDetails";
 }

@Override
public BranchDetailsRequest getModel() {

	return this.branchDetailsRequest;
}



}
