package com.java.erp.webapp.server.interfaces.services.setup;

import com.java.erp.webapp.request.setup.SchoolDetailsRequest;
import com.java.erp.webapp.request.user.LoginRequest;
import com.java.erp.webapp.server.interfaces.services.common.Response;


public interface SchoolDetailsI {
	public Response getSchoolDetails() throws Exception;
	public Response saveSchoolDetails(SchoolDetailsRequest request) throws Exception;
 }
