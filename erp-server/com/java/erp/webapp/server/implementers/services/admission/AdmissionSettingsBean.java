package com.java.erp.webapp.server.implementers.services.admission;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.erp.webapp.database.admission.AdmissionSettings;
import com.java.erp.webapp.request.admission.AdmissionSettingsRequest;
import com.java.erp.webapp.server.implementers.services.common.BaseBean;
import com.java.erp.webapp.server.implementers.services.common.MessageConstants;
import com.java.erp.webapp.server.implementers.services.common.ProcessMessage;
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
	getResults(resultHolder);
	 		result.setResultList(resultHolder);
		return result;
	}

	@Override
	public Response saveAdmissionSettings(AdmissionSettingsRequest request)
			throws Exception {
	 
		Response result = new Result();
		for(Long acYearId:request.getAcyear()){
			for(Long mappingId:request.getMappingId()){
				AdmissionSettings settings=new AdmissionSettings();
				settings.getId().setAcYearId(acYearId);
				settings.getId().setMappingId(mappingId);
				settings.setAdmissionMode(request.getMode());
				getAdmissionAuthorizationDao().merge(settings);
				getAdmissionAuthorizationDao().flush();
				
			}
			
		}
		List<Object> resultHolder = new ArrayList<Object>();
		getResults(resultHolder);
ProcessMessage.addMessage(result, MessageConstants.SCHOOL_DETAILS_SUCCESS);
	 		result.setResultList(resultHolder);
		return result;
	}
 private void getResults(final List<Object> resultHolder) throws Exception{
	 resultHolder.add(0,getAdmissionAuthorizationDao().getActiveAcademicYear());
		resultHolder.add(1,getBatchDetailsDao().getAllBatchDetails());
		resultHolder.add(2,getAdmissionSettingsDao().getAdmissionSettingsList());
 }
}
