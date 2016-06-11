package com.java.erp.webapp.server.interfaces.services.admission;

import com.java.erp.webapp.request.admission.AdmissionSettingsRequest;
import com.java.erp.webapp.server.interfaces.services.common.Response;


public interface AdmissionSettingsI {
	public Response getAdmissionSettingsList(AdmissionSettingsRequest request) throws Exception;
	public Response saveAdmissionSettings(AdmissionSettingsRequest request) throws Exception;
	
 }
