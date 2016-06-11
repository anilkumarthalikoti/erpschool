package com.java.erp.webapp.server.interfaces.services.setup;

import com.java.erp.webapp.request.setup.BranchDetailsRequest;
import com.java.erp.webapp.server.interfaces.services.common.Response;


public interface BranchDetailsI {
	public Response getBranchDetails() throws Exception;
	public Response saveBranchDetails(BranchDetailsRequest request) throws Exception;
 }
