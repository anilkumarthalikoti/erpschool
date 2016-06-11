package com.java.erp.webapp.server.implementers.services.setup;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.erp.webapp.database.setup.BatchDetails;
import com.java.erp.webapp.database.setup.StudentAdmissionFields;
import com.java.erp.webapp.request.setup.BatchDetailsRequest;
import com.java.erp.webapp.request.setup.StudentAdmissionFieldRequest;
import com.java.erp.webapp.server.implementers.services.common.BaseBean;
import com.java.erp.webapp.server.implementers.services.common.MessageConstants;
import com.java.erp.webapp.server.implementers.services.common.ProcessMessage;
import com.java.erp.webapp.server.implementers.services.common.Result;
import com.java.erp.webapp.server.interfaces.services.common.Response;
import com.java.erp.webapp.server.interfaces.services.setup.BatchDetailsI;
import com.java.erp.webapp.server.interfaces.services.setup.StudentAdmissionFieldsI;
@Service
public class StudentAdmissionFieldsBean extends BaseBean implements StudentAdmissionFieldsI {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public Response saveStudentAdmissionFields(StudentAdmissionFieldRequest request)
			throws Exception {
		Response result = new Result();
		List<Object> resultHolder = new ArrayList<Object>();
		StudentAdmissionFields studentAdmissionFeild=new StudentAdmissionFields();
		studentAdmissionFeild.setFieldName(request.getFieldName());
		studentAdmissionFeild.setIsActive(request.getIsActive());
		studentAdmissionFeild.setIsRequired(request.getIsRequired());
		getStudentAdmissionFieldsDao().merge(studentAdmissionFeild);
		getStudentAdmissionFieldsDao().flush();
		
resultHolder.add(0,getStudentAdmissionFieldsDao().getAllStudentAdmissionFields());
ProcessMessage.addMessage(result, MessageConstants.STUDENT_ADMISSION_DETAILS_SUCCESS);		
result.setResultList(resultHolder);
		return result;
	}

	@Override
	public Response getStudentAdmissionFields() throws Exception {
		// TODO Auto-generated method stub
		Response result = new Result();
		List<Object> resultHolder = new ArrayList<Object>();
		resultHolder.add(0,getStudentAdmissionFieldsDao().getAllStudentAdmissionFields());
		 	result.setResultList(resultHolder);
		return result;
	}

 
}
