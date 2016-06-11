package com.java.erp.webapp.server.implementers.services.setup;
 
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.erp.webapp.database.setup.SubjectDetails;
import com.java.erp.webapp.request.setup.SubjectDetailsRequest;
import com.java.erp.webapp.server.implementers.services.common.BaseBean;
import com.java.erp.webapp.server.implementers.services.common.MessageConstants;
import com.java.erp.webapp.server.implementers.services.common.ProcessMessage;
import com.java.erp.webapp.server.implementers.services.common.Result;
import com.java.erp.webapp.server.interfaces.services.common.Response;
import com.java.erp.webapp.server.interfaces.services.setup.SubjectDetailsI;
@Service
public class SubjectDetailsBean extends BaseBean implements SubjectDetailsI {
	private static final long serialVersionUID = 1L;
	@Override
	public Response saveSubjectDetails(SubjectDetailsRequest request)
			throws Exception {
		Response result = new Result();
		List<Object> resultHolder = new ArrayList<Object>();
		SubjectDetails subjectDetails=null;
		subjectDetails=getSubjectDetailsDao().getSubjectDetails(new Object[]{"subjectId"}, new Object[]{request.getSubjectId() });
		if(null==subjectDetails){
			 subjectDetails=new SubjectDetails();
			 
		 }
		subjectDetails.setSubjectName(request.getSubjectName());
		subjectDetails.setPrority(request.getPrority()); 
		
		getSubjectDetailsDao().merge(subjectDetails);
		getSubjectDetailsDao().flush();
	resultHolder.add(0,getSubjectDetailsDao().getAllSubjectDetails());
	ProcessMessage.addMessage(result, MessageConstants.LANGUAGE_DETAILS_SUCCESS);
	result.setResultList(resultHolder);
		return result;
	}

	@Override
	public Response getSubjectDetails() throws Exception {
		// TODO Auto-generated method stub
		Response result = new Result();
		List<Object> resultHolder = new ArrayList<Object>();
		resultHolder.add(0,getSubjectDetailsDao().getAllSubjectDetails());
		result.setResultList(resultHolder);
		return result;
	}

	 
}
