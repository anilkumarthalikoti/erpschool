package com.java.erp.webapp.server.interfaces.services.setup;

import com.java.erp.webapp.request.setup.SubjectDetailsRequest;
import com.java.erp.webapp.server.interfaces.services.common.Response;


public interface SubjectDetailsI {
	public Response getSubjectDetails() throws Exception;
	public Response saveSubjectDetails(SubjectDetailsRequest request) throws Exception;
 }
