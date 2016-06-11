package com.java.erp.webapp.server.implementers.services.setup;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.erp.webapp.database.setup.BatchDetails;
import com.java.erp.webapp.request.setup.BatchDetailsRequest;
import com.java.erp.webapp.server.implementers.services.common.BaseBean;
import com.java.erp.webapp.server.implementers.services.common.MessageConstants;
import com.java.erp.webapp.server.implementers.services.common.ProcessMessage;
import com.java.erp.webapp.server.implementers.services.common.Result;
import com.java.erp.webapp.server.interfaces.services.common.Response;
import com.java.erp.webapp.server.interfaces.services.setup.BatchDetailsI;
@Service
public class BatchDetailsBean extends BaseBean implements BatchDetailsI {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public Response saveBatchDetails(BatchDetailsRequest request)
			throws Exception {
		Response result = new Result();
		List<Object> resultHolder = new ArrayList<Object>();
		int i=0;
		for(Long branch:request.getBranch()){
			
			for(Long course:request.getCourse()){
				
				for(Long language:request.getLanguage()){
					BatchDetails batchDetails=null;
					batchDetails=new BatchDetails();
					 request.setActiveStatus("Y");
					 batchDetails.setBatchId(getBatchDetailsDao().getCurrentDate().getTime()+i);
					batchDetails.setIsActive(request.getActiveStatus());
					batchDetails.getBatchDetailsPk().setBranchId(branch);
					batchDetails.getBatchDetailsPk().setCourseId(course);
					batchDetails.getBatchDetailsPk().setSubjectId(language);
					getBatchDetailsDao().merge(batchDetails);
					getBatchDetailsDao().flush();
					i++;
					//batchDetails.set
				}
				
			}
		}
		
	 
		 
		resultHolder.add(0,getSubjectDetailsDao().getAllSubjectDetails());
		resultHolder.add(1,getBranchDetailsDao().getAllBranchDetails());
		resultHolder.add(2,getCourseDetailsDao().getAllCourseDetails());
		resultHolder.add(3,getBatchDetailsDao().getAllBatchDetails());
		ProcessMessage.addMessage(result, MessageConstants.MAPPING_DETAILS_SUCCESS);
		result.setResultList(resultHolder);
		 
		return result;
	}

	@Override
	public Response getBatchDetails() throws Exception {
		// TODO Auto-generated method stub
		Response result = new Result();
		List<Object> resultHolder = new ArrayList<Object>();
		resultHolder.add(0,getSubjectDetailsDao().getAllSubjectDetails());
		resultHolder.add(1,getBranchDetailsDao().getAllBranchDetails());
		resultHolder.add(2,getCourseDetailsDao().getAllCourseDetails());
		resultHolder.add(3,getBatchDetailsDao().getAllBatchDetails());
		result.setResultList(resultHolder);
		return result;
	}

 
}
