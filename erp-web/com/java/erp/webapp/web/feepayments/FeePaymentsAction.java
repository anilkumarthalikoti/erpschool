package com.java.erp.webapp.web.feepayments;

import com.java.erp.webapp.request.finance.FeePaymentsRequest;
import com.java.erp.webapp.server.implementers.services.finance.FeePaymentsBean;
import com.java.erp.webapp.server.interfaces.services.finance.FeePaymentsBeanI;
import com.java.erp.webapp.web.common.BaseAction;
import com.opensymphony.xwork2.ModelDriven;

public class FeePaymentsAction  extends BaseAction implements ModelDriven<FeePaymentsRequest>{
private FeePaymentsRequest feePaymentsRequest;
private FeePaymentsBeanI bean;
public FeePaymentsAction(){
	
	feePaymentsRequest=new FeePaymentsRequest();
	bean=(FeePaymentsBean)loadBean(FeePaymentsBean.class);
}

public String getFeePayments() throws Exception{
	
	return "feepayments";
}
public String fetchFeePayment() throws Exception{
	this.response=bean.fetchFeePayments(getModel()).getResponse();
	getServletRequest().setAttribute("result", this.response.getResultList());
	return "viewfeepayments";
}
public String saveFeePayment() throws Exception{
	this.response=bean.saveFeePayments(getModel()).getResponse();
	getServletRequest().setAttribute("result", this.response.getResultList());
	return "feepayments";
}
@Override
public FeePaymentsRequest getModel() {
	return this.feePaymentsRequest;
}	 
}
