package com.java.erp.webapp.server.interfaces.services.setup;

import com.java.erp.webapp.request.setup.CourseDetailsRequest;
import com.java.erp.webapp.server.interfaces.services.common.Response;


public interface CourseDetailsI {
	public Response getCourseDetails() throws Exception;
	public Response saveCourseDetails(CourseDetailsRequest request) throws Exception;
 }
