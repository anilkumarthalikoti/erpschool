package com.java.erp.webapp.db.implimentors.setup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.erp.webapp.database.setup.BatchDetails;
import com.java.erp.webapp.db.implimentors.common.BaseDAO;
import com.java.erp.webapp.db.interfaces.setup.BatchDetailsDAOI;

public class BatchDetailsDAO extends BaseDAO implements BatchDetailsDAOI {

	@Override
	public BatchDetails getBatchDetails(Object[] paramName,Object[] paramVal) throws Exception {
		BatchDetails details=null;
		try{
			String query="select u from BatchDetails u";  
			Map params=new HashMap();
			if(null!=paramName && paramName.length==paramVal.length ){
				query=query+ " where ";
				for(int i=0;i<paramName.length;i++){
					query=query+" u."+paramName[i]+"=:"+paramName[i]+" and ";
					params.put(paramName[i], paramVal[i]);
				}
				query=query+ " 1=1 ";
			}
			details=(BatchDetails)getSingleResult(query,params);
		}catch(Exception e){
			e.printStackTrace();
		}
		return details;
	}
	
	@Override
	public List<Object[]> getAllBatchDetails() throws Exception {
		List<Object[]> details=null;
		try{
			details=(List<Object[]>)getResultList("select bu.branchId,cd.courseId,sd.subjectId,bu.branchName,cd.courseName, sd.subjectName, bd.batchId,bd.isActive from BatchDetails bd, BranchDetails bu,CourseDetails cd, SubjectDetails sd where bd.batchDetailsPk.branchId=bu.branchId and bd.batchDetailsPk.courseId=cd.courseId and bd.batchDetailsPk.subjectId=sd.subjectId  ");
		}catch(Exception e){
			e.printStackTrace();
		}
		return details;
	}

	 
}
