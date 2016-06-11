package com.java.erp.webapp.server.implementers.services.admission;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.erp.webapp.request.admission.AdmissionDetailsRequest;
import com.java.erp.webapp.server.implementers.services.common.BaseBean;
import com.java.erp.webapp.server.implementers.services.common.Result;
import com.java.erp.webapp.server.interfaces.services.admission.AdmissionDetailsI;
import com.java.erp.webapp.server.interfaces.services.common.Response;
@Service
public class AdmissionDetailsBean extends BaseBean implements AdmissionDetailsI {
	private static final long serialVersionUID = 1L;

	@Override
	public Response getAdmissionList(AdmissionDetailsRequest request)
			throws Exception {
		if(request.getSearchKey()==null){
			request.setSearchKey("");
		}
		Response result = new Result();
		List<Object> resultHolder = new ArrayList<Object>();
	
		 		 
	resultHolder.add(0,getStudentDetailsDao().getAdmissionList(request.getSearchKey()));
		result.setResultList(resultHolder);
		return result;
	}

	 
}
