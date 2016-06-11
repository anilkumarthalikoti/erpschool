package com.java.erp.webapp.web.feepayments;

import java.util.List;

import com.java.erp.webapp.request.finance.FeeStructureRequest;
import com.java.erp.webapp.server.implementers.services.finance.FeeStructureBean;
import com.java.erp.webapp.server.interfaces.services.finance.FeeStructureBeanI;
import com.java.erp.webapp.web.common.BaseAction;
import com.opensymphony.xwork2.ModelDriven;

public class FeeStructureAction  extends BaseAction implements ModelDriven<FeeStructureRequest>{
	FeeStructureRequest feeStructureRequest;
	FeeStructureBeanI bean;
public FeeStructureAction(){
	feeStructureRequest=new FeeStructureRequest();
	bean=(FeeStructureBean)loadBean(FeeStructureBean.class);
}
public String getFeeStructure() throws Exception{
	this.response=bean.getFeeStrucutre(getModel()).getResponse();
	List result=this.response.getResultList();
		
	 getServletRequest().setAttribute("courseDetails", result.get(0));
	getServletRequest().setAttribute("academicYear",result.get(1));
	 return "feestructure";
}
public String saveFeeStructure() throws Exception{
	this.response=bean.saveFeeStrucutre(getModel()).getResponse();
	List result=this.response.getResultList();
		
	 getServletRequest().setAttribute("courseDetails", result.get(0));
	getServletRequest().setAttribute("academicYear",result.get(1));
	 return "feestructure";
}
@Override
public FeeStructureRequest getModel() {
	// TODO Auto-generated method stub
	return this.feeStructureRequest;
}
}
