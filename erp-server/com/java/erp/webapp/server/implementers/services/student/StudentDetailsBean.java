package com.java.erp.webapp.server.implementers.services.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.erp.webapp.request.student.StudentDetailsRequest;
import com.java.erp.webapp.server.implementers.services.common.BaseBean;
import com.java.erp.webapp.server.implementers.services.common.Result;
import com.java.erp.webapp.server.interfaces.services.common.Response;
import com.java.erp.webapp.server.interfaces.services.student.StudentDetailsI;
@Service
public class StudentDetailsBean extends BaseBean implements StudentDetailsI {
	private static final long serialVersionUID = 1L;

	@Override
	public Response getStudentList(StudentDetailsRequest request)
			throws Exception {
		Response result = new Result();
		List<Object> resultHolder = new ArrayList<Object>();
	
		 		 
	resultHolder.add(0,getStudentDetailsDao().getStudentList(request.getSearchKey()));
		result.setResultList(resultHolder);
		return result;
	}

	 
}
