package com.java.erp.webapp.server.interfaces.services.admission;

import com.java.erp.webapp.request.admission.AdmissionAuthorizationRequest;
import com.java.erp.webapp.server.interfaces.services.common.Response;


public interface AdmissionAuthorizationI {
	public Response getAdmissionAuthorizationList(AdmissionAuthorizationRequest request) throws Exception;
	public Response saveAdmissionAuthorizationList(AdmissionAuthorizationRequest request) throws Exception;
 }
