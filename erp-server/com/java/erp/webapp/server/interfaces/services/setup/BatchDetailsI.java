package com.java.erp.webapp.server.interfaces.services.setup;

import com.java.erp.webapp.request.setup.BatchDetailsRequest;
import com.java.erp.webapp.server.interfaces.services.common.Response;


public interface BatchDetailsI {
	public Response getBatchDetails() throws Exception;
	public Response saveBatchDetails(BatchDetailsRequest request) throws Exception;
 }
