package com.java.erp.webapp.server.implementers.services.setup;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.erp.webapp.database.setup.CourseDetails;
import com.java.erp.webapp.request.setup.CourseDetailsRequest;
import com.java.erp.webapp.server.implementers.services.common.BaseBean;
import com.java.erp.webapp.server.implementers.services.common.MessageConstants;
import com.java.erp.webapp.server.implementers.services.common.ProcessMessage;
import com.java.erp.webapp.server.implementers.services.common.Result;
import com.java.erp.webapp.server.interfaces.services.common.Response;
import com.java.erp.webapp.server.interfaces.services.setup.CourseDetailsI;
@Service
public class CourseDetailsBean extends BaseBean implements CourseDetailsI {
	private static final long serialVersionUID = 1L;

	@Override
	public Response saveCourseDetails(CourseDetailsRequest request)
			throws Exception {
		Response result = new Result();
		List<Object> resultHolder = new ArrayList<Object>();
		CourseDetails courseDetails=null;
		courseDetails=getCourseDetailsDao().getCourseDetails(new Object[]{"courseId"}, new Object[]{request.getCourseId() });
		if(null==courseDetails){
			 courseDetails=new CourseDetails();
			 
		 }
		courseDetails.setCourseName(request.getCourseName());
		courseDetails.setPrority(request.getPrority()); 
		
		getCourseDetailsDao().merge(courseDetails);
		getCourseDetailsDao().flush();
	resultHolder.add(0,getCourseDetailsDao().getAllCourseDetails());
	ProcessMessage.addMessage(result, MessageConstants.COURSE_DETAILS_SUCCESS);	
	result.setResultList(resultHolder);
		return result;
	}

	@Override
	public Response getCourseDetails() throws Exception {
		// TODO Auto-generated method stub
		Response result = new Result();
		List<Object> resultHolder = new ArrayList<Object>();
		resultHolder.add(0,getCourseDetailsDao().getAllCourseDetails());
		result.setResultList(resultHolder);
		return result;
	}

}
