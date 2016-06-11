package com.java.erp.webapp.server.interfaces.services.admission;

import com.java.erp.webapp.request.admission.AdmissionDetailsRequest;
import com.java.erp.webapp.server.interfaces.services.common.Response;


public interface AdmissionDetailsI {
	public Response getAdmissionList(AdmissionDetailsRequest request) throws Exception;
	
 }
