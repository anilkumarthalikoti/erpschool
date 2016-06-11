package com.java.erp.webapp.db.implimentors.setup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.erp.webapp.database.setup.SubjectDetails;
import com.java.erp.webapp.db.implimentors.common.BaseDAO;
import com.java.erp.webapp.db.interfaces.setup.SubjectDetailsDAOI;

public class SubjectDetailsDAO extends BaseDAO implements SubjectDetailsDAOI {

	@Override
	public SubjectDetails getSubjectDetails(Object[] paramName,Object[] paramVal) throws Exception {
		SubjectDetails details=null;
		try{
			String query="select u from SubjectDetails u";  
			Map params=new HashMap();
			if(null!=paramName && paramName.length==paramVal.length ){
				query=query+ " where ";
				for(int i=0;i<paramName.length;i++){
					query=query+" u."+paramName[i]+"=:"+paramName[i]+" and ";
					params.put(paramName[i], paramVal[i]);
				}
				query=query+ " 1=1 ";
			}
			details=(SubjectDetails)getSingleResult(query,params);
		}catch(Exception e){
			e.printStackTrace();
		}
		return details;
	}
	
	@Override
	public List<SubjectDetails> getAllSubjectDetails() throws Exception {
		List<SubjectDetails> details=null;
		try{
			details=(List<SubjectDetails>)getResultList("select u from SubjectDetails u  ");
		}catch(Exception e){
			e.printStackTrace();
		}
		return details;
	}
 
}
