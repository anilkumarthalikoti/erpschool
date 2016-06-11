package com.java.erp.webapp.server.implementers.services.admission;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.erp.webapp.request.admission.AdmissionSettingsRequest;
import com.java.erp.webapp.server.implementers.services.common.BaseBean;
import com.java.erp.webapp.server.implementers.services.common.Result;
import com.java.erp.webapp.server.interfaces.services.admission.AdmissionSettingsI;
import com.java.erp.webapp.server.interfaces.services.common.Response;
@Service
public class AdmissionSettingsBean extends BaseBean implements AdmissionSettingsI {
	private static final long serialVersionUID = 1L;

	@Override
	public Response getAdmissionSettingsList(AdmissionSettingsRequest request)
			throws Exception {
	 
		Response result = new Result();
		List<Object> resultHolder = new ArrayList<Object>();
	resultHolder.add(0,getAdmissionAuthorizationDao().getAdmissionAuthorizationList());
	resultHolder.add(1,getBatchDetailsDao().getAllBatchDetails());
	 		result.setResultList(resultHolder);
		return result;
	}

	@Override
	public Response saveAdmissionSettings(AdmissionSettingsRequest request)
			throws Exception {
	 
		Response result = new Result();
		List<Object> resultHolder = new ArrayList<Object>();
		resultHolder.add(0,getAdmissionAuthorizationDao().getAdmissionAuthorizationList());
		resultHolder.add(1,getBatchDetailsDao().getAllBatchDetails());

	 		result.setResultList(resultHolder);
		return result;
	}
 
}
