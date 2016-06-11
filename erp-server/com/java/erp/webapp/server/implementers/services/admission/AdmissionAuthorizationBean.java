package com.java.erp.webapp.server.implementers.services.admission;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.erp.webapp.database.setup.AcademicYears;
import com.java.erp.webapp.request.admission.AdmissionAuthorizationRequest;
import com.java.erp.webapp.server.implementers.services.common.BaseBean;
import com.java.erp.webapp.server.implementers.services.common.MessageConstants;
import com.java.erp.webapp.server.implementers.services.common.ProcessMessage;
import com.java.erp.webapp.server.implementers.services.common.Result;
import com.java.erp.webapp.server.interfaces.services.admission.AdmissionAuthorizationI;
import com.java.erp.webapp.server.interfaces.services.common.Response;

@Service
public class AdmissionAuthorizationBean extends BaseBean implements
		AdmissionAuthorizationI {
	private static final long serialVersionUID = 1L;

	@Override
	public Response getAdmissionAuthorizationList(
			AdmissionAuthorizationRequest request) throws Exception {

		Response result = new Result();
		List<Object> resultHolder = new ArrayList<Object>();
		resultHolder.add(0, getAdmissionAuthorizationDao()
				.getAdmissionAuthorizationList());
		result.setResultList(resultHolder);
		return result;
	}

	@Override
	public Response saveAdmissionAuthorizationList(
			AdmissionAuthorizationRequest request) throws Exception {

		Response result = new Result();
		AcademicYears ac = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		ac = getAdmissionAuthorizationDao().getAcademicYear(
				request.getAuthorizationId());
		if (null == ac) {
			ac = new AcademicYears();
		}
		ac.setApplicationPrefix(request.getPrefix());
		ac.setSeriesFrom(request.getSeriseStarts());
		ac.setSeriesTo(request.getSeriesEnds());
		ac.setAcceptFrom(new Date(sdf.parse(request.getAcceptDate()).getTime()));
		ac.setAcceptTo(new Date(sdf.parse(request.getAcceptTo()).getTime()));
		getAdmissionAuthorizationDao().merge(ac);
		getAdmissionAuthorizationDao().flush();

		List<Object> resultHolder = new ArrayList<Object>();
		ProcessMessage.addMessage(result,
				MessageConstants.MAPPING_DETAILS_SUCCESS);
		resultHolder.add(0, getAdmissionAuthorizationDao()
				.getAdmissionAuthorizationList());
		result.setResultList(resultHolder);
		return result;
	}
}
