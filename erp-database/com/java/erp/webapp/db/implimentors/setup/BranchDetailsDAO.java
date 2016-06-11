package com.java.erp.webapp.db.implimentors.setup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.erp.webapp.database.setup.BranchDetails;
import com.java.erp.webapp.db.implimentors.common.BaseDAO;
import com.java.erp.webapp.db.interfaces.setup.BranchDetailsDAOI;

public class BranchDetailsDAO extends BaseDAO implements BranchDetailsDAOI {

	@Override
	public BranchDetails getBranchDetails(Object[] paramName,Object[] paramVal) throws Exception {
		BranchDetails details=null;
		try{
			String query="select u from BranchDetails u";  
			Map params=new HashMap();
			if(null!=paramName && paramName.length==paramVal.length ){
				query=query+ " where ";
				for(int i=0;i<paramName.length;i++){
					query=query+" u."+paramName[i]+"=:"+paramName[i]+" and ";
					params.put(paramName[i], paramVal[i]);
				}
				query=query+ " 1=1 ";
			}
			details=(BranchDetails)getSingleResult(query,params);
		}catch(Exception e){
			e.printStackTrace();
		}
		return details;
	}
	
	@Override
	public List<BranchDetails> getAllBranchDetails() throws Exception {
		List<BranchDetails> details=null;
		try{
			details=(List<BranchDetails>)getResultList("select u from BranchDetails u  ");
		}catch(Exception e){
			e.printStackTrace();
		}
		return details;
	}
 
}
