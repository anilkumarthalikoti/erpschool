package com.java.erp.webapp.server.implementers.services.setup;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.erp.webapp.database.setup.SchoolDetails;
import com.java.erp.webapp.request.setup.SchoolDetailsRequest;
import com.java.erp.webapp.server.implementers.services.common.BaseBean;
import com.java.erp.webapp.server.implementers.services.common.MessageConstants;
import com.java.erp.webapp.server.implementers.services.common.ProcessMessage;
import com.java.erp.webapp.server.implementers.services.common.Result;
import com.java.erp.webapp.server.interfaces.services.common.Response;
import com.java.erp.webapp.server.interfaces.services.setup.SchoolDetailsI;
@Service
public class SchoolDetailsBean extends BaseBean implements SchoolDetailsI {
	private static final long serialVersionUID = 1L;

	@Override
	public Response saveSchoolDetails(SchoolDetailsRequest request)
			throws Exception {
		Response result = new Result();
		List<Object> resultHolder = new ArrayList<Object>();
		SchoolDetails school = new SchoolDetails();
		school.setSchoolId(Long.valueOf("1"));
		school.setEmail(request.getEmail());
		school.setSchoolName(request.getSchoolName());
		school.setFaxNo(request.getFaxNo());
		school.setPhoneNo(request.getPhoneNo());
		school.setRegBy(request.getRegBy());
		school.setRegNo(request.getRegNo());
		school.setWebUrl(request.getWebUrl());
		getSchoolDetailsDao().merge(school);
		getSchoolDetailsDao().flush();
	resultHolder.add(0,getSchoolDetailsDao().getSchoolDetails());
	ProcessMessage.addMessage(result, MessageConstants.SCHOOL_DETAILS_SUCCESS);	
	result.setResultList(resultHolder);
		return result;
	}

	@Override
	public Response getSchoolDetails() throws Exception {
		// TODO Auto-generated method stub
		Response result = new Result();
		List<Object> resultHolder = new ArrayList<Object>();
		resultHolder.add(0,getSchoolDetailsDao().getSchoolDetails());
		result.setResultList(resultHolder);
		return result;
	}

}
