package com.java.erp.webapp.server.implementers.services.setup;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.erp.webapp.database.setup.BranchDetails;
import com.java.erp.webapp.database.setup.SchoolDetails;
import com.java.erp.webapp.request.setup.BranchDetailsRequest;
import com.java.erp.webapp.server.implementers.services.common.BaseBean;
import com.java.erp.webapp.server.implementers.services.common.MessageConstants;
import com.java.erp.webapp.server.implementers.services.common.ProcessMessage;
import com.java.erp.webapp.server.implementers.services.common.Result;
import com.java.erp.webapp.server.interfaces.services.common.Response;
import com.java.erp.webapp.server.interfaces.services.setup.BranchDetailsI;
@Service
public class BranchDetailsBean extends BaseBean implements BranchDetailsI {
	private static final long serialVersionUID = 1L;

	@Override
	public Response saveBranchDetails(BranchDetailsRequest request)
			throws Exception {
		Response result = new Result();
		List<Object> resultHolder = new ArrayList<Object>();
		BranchDetails branchDetails=null;
		branchDetails=getBranchDetailsDao().getBranchDetails(new Object[]{"branchId"}, new Object[]{request.getBranchId() });
		if(null==branchDetails){
			 branchDetails=new BranchDetails();
			 
		 }
		branchDetails.setBranchName(request.getBranchName());
		branchDetails.setIsActive("Y");
		branchDetails.setLocation(request.getLocation());
		branchDetails.setPhoneNo(request.getPhoneNo());
		branchDetails.setFaxNo(request.getFaxNo());
		branchDetails.setBranchAddress(request.getAddress());
		branchDetails.setEmail(request.getEmail());
		getBranchDetailsDao().merge(branchDetails);
		getBranchDetailsDao().flush();
		resultHolder.add(0,getBranchDetailsDao().getAllBranchDetails());
		ProcessMessage.addMessage(result, MessageConstants.BRANCH_DETAILS_SUCCESS);
		result.setResultList(resultHolder);
		return result;
	}

	@Override
	public Response getBranchDetails() throws Exception {
		// TODO Auto-generated method stub
		Response result = new Result();
		List<Object> resultHolder = new ArrayList<Object>();
		resultHolder.add(0,getBranchDetailsDao().getAllBranchDetails());
		result.setResultList(resultHolder);
		return result;
	}

}
