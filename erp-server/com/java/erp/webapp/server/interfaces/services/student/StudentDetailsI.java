package com.java.erp.webapp.server.interfaces.services.student;

import com.java.erp.webapp.request.student.StudentDetailsRequest;
import com.java.erp.webapp.server.interfaces.services.common.Response;


public interface StudentDetailsI {
	public Response getStudentList(StudentDetailsRequest request) throws Exception;
	
 }
