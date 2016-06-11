package com.java.erp.webapp.server.implementers.services.finance;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.erp.webapp.database.finance.FeeStructure;
import com.java.erp.webapp.database.student.StudentDetails;
import com.java.erp.webapp.database.student.StudentHistory;
import com.java.erp.webapp.request.finance.FeePaymentsRequest;
import com.java.erp.webapp.server.exception.ExceptionMessageHandler;
import com.java.erp.webapp.server.implementers.services.common.BaseBean;
import com.java.erp.webapp.server.implementers.services.common.Result;
import com.java.erp.webapp.server.interfaces.services.common.Response;
import com.java.erp.webapp.server.interfaces.services.finance.FeePaymentsBeanI;
@Service
public class FeePaymentsBean extends BaseBean implements FeePaymentsBeanI {

	@Override
	public Response getFeePayments(FeePaymentsRequest request) throws Exception {
		Response result=new Result();
		List<Object>resultHolder=new ArrayList<Object>();
 resultHolder=getResult(resultHolder);
		result.setResultList(resultHolder);
		return result;
	}
	@Override
	public Response fetchFeePayments(FeePaymentsRequest request) throws Exception {
		Response result=new Result();
		List<Object>resultHolder=new ArrayList<Object>();
		StudentDetails student=null;
		
		student=getStudentDetailsDao().getStudent(request.getStudentId());
		if(null==student){
			throw new ExceptionMessageHandler("Invalid student/appliction no");
		}
		if(!("ACCEPT".equals(student.getApplicationStatus()))){
			throw new ExceptionMessageHandler("Student status with "+student.getApplicationStatus()+" can't be processed");
		}
		List<StudentHistory> studentHistory=getStudentDetailsDao().getStudentHistory(student.getId());
		resultHolder.add(0,student);
		FeeStructure fs=null;
		if(null==studentHistory || studentHistory.size()<1){
			//New Admission
			
			fs=getFeeStructureDao().getFeeStructure(student.getRequestedCourse(), student.getJoinedAcYear());
		}else{
			//fs
			fs.setAdmissionFee(Float.valueOf(0));
			fs.setRefundAmount(Float.valueOf(0));
		}
		if(fs==null){
			throw new ExceptionMessageHandler("Fee structure not created");
					
		}
 resultHolder.add(1, fs);
		result.setResultList(resultHolder);
		return result;
	}
	@Override
	public Response saveFeePayments(FeePaymentsRequest request) throws Exception {
		Response result=new Result();
		List<Object>resultHolder=new ArrayList<Object>();
 resultHolder=getResult(resultHolder);
		result.setResultList(resultHolder);
		return result;
	}
private List getResult(List resultHolder) throws Exception{
	resultHolder.add(0,getBatchDetailsDao().getAllBatchDetails());
	resultHolder.add(1, getAdmissionAuthorizationDao()
			.getAdmissionAuthorizationList());
	return resultHolder;
}
}
