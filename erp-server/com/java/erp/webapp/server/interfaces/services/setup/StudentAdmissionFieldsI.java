package com.java.erp.webapp.server.interfaces.services.setup;

import com.java.erp.webapp.request.setup.BatchDetailsRequest;
import com.java.erp.webapp.request.setup.StudentAdmissionFieldRequest;
import com.java.erp.webapp.server.interfaces.services.common.Response;


public interface StudentAdmissionFieldsI {
	public Response getStudentAdmissionFields() throws Exception;
	public Response saveStudentAdmissionFields(StudentAdmissionFieldRequest request) throws Exception;
 }
