package com.java.erp.webapp.server.implementers.services.admission;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.erp.webapp.database.setup.AcademicYears;
import com.java.erp.webapp.database.student.StudentDetails;
import com.java.erp.webapp.request.admission.AdmissionDetailsRequest;
import com.java.erp.webapp.server.exception.ExceptionMessageHandler;
import com.java.erp.webapp.server.implementers.services.common.BaseBean;
import com.java.erp.webapp.server.implementers.services.common.MessageConstants;
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
		List<Object> resultHolder = getResults(request);
	
		 		 
	
	result.setResultList(resultHolder);
		return result;
	}
	
	
	@Override
	public Response saveAdmissionDetails(AdmissionDetailsRequest request)
			throws Exception {
		if(request.getSearchKey()==null){
			request.setSearchKey("");
		}
		Response result = new Result();
		
	
		 	StudentDetails student=null;
		 	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		 	if(request.getId()==-1){
		 		student=new StudentDetails();
		 		
		 		List<AcademicYears> data=getAdmissionSettingsDao().getActiveAcademicYear();
		 		AcademicYears acyear=(AcademicYears)data.get(0);
		 		String prefix=acyear.getApplicationPrefix();
		 		if(null==prefix || prefix.length()<1){
		 			prefix="EP";
		 		}
		 		String series=getStudentDetailsDao().getApplicationGen(acyear.getId());
		 		String applicationno=prefix+acyear.getAcademicYear().substring(2, 4)+series;
		 	student.setApplicationNo(applicationno);
		 	student.setAppliedDate(getStudentDetailsDao().getCurrentDate());
		 	student.setJoinedAcYear(acyear.getId());
		 	}else{
		 		student=getStudentDetailsDao().getStudent(request.getId());
		 		if(null==student){
		 			throw new ExceptionMessageHandler(MessageConstants.INVALID_USER);
		 		}
		 	}
		 	student.setApplicationStatus(request.getApplicationStatus());
		 	student.setGender(request.getGender());
		 	student.setAddress(request.getAddress());
		 	student.setStudentName(request.getStudentName());
		 	student.setRequestedCourse(request.getBatchId());
		 	student.setDob(sdf.parse(request.getDob()));
		 	student.setContactNo(request.getContactNo());
		 	student.setFatherName(request.getFatherName());
		 	student.setMotherName(request.getMotherName());
		 	//student.setApplicationNo(applicationNo);
	getStudentDetailsDao().merge(student);
	getSchoolDetailsDao().flush();
	List<Object> resultHolder = getResults(request);
	result.setResultList(resultHolder);
		return result;
	}
	
	
	@Override
	public Response saveAcceptRejectAdmission(AdmissionDetailsRequest request)
			throws Exception {
		if(request.getSearchKey()==null){
			request.setSearchKey("");
		}
		Response result = new Result();
 
	
		 	StudentDetails student=null;
		 	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		 	if(request.getId()==-1){
				throw new ExceptionMessageHandler(MessageConstants.ADM_APPLICATION_NOT_FOUND);
		 	}else{
		 		student=getStudentDetailsDao().getStudent(request.getId());
		 		if(null==student){
		 			throw new ExceptionMessageHandler(MessageConstants.ADM_APPLICATION_NOT_FOUND);
		 		}
		 	}
		 	student.setApplicationStatus(request.getApplicationStatus());
		 	getStudentDetailsDao().merge(student);
	getSchoolDetailsDao().flush();
	List<Object> resultHolder = getResults(request);
	result.setResultList(resultHolder);
		return result;
	}

	
	
	
	private List<Object> getResults(AdmissionDetailsRequest request) throws Exception{
	List<Object> resultHolder=new ArrayList<Object>();	
	resultHolder.add(0,getStudentDetailsDao().getAdmissionList(request.getSearchKey()));
	resultHolder.add(1,getBatchDetailsDao().getAllBatchDetails());
	return resultHolder;
	}


	 
}
