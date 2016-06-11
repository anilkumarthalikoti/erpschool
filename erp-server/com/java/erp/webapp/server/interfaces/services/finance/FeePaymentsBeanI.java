package com.java.erp.webapp.server.interfaces.services.finance;

import com.java.erp.webapp.request.finance.FeePaymentsRequest;
import com.java.erp.webapp.server.interfaces.services.common.Response;

public interface FeePaymentsBeanI {
public Response getFeePayments(FeePaymentsRequest request) throws Exception;
public Response fetchFeePayments(FeePaymentsRequest request) throws Exception;
public Response saveFeePayments(FeePaymentsRequest request) throws Exception;
}
