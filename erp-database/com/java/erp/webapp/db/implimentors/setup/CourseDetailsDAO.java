package com.java.erp.webapp.db.implimentors.setup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.erp.webapp.database.setup.CourseDetails;
import com.java.erp.webapp.db.implimentors.common.BaseDAO;
import com.java.erp.webapp.db.interfaces.setup.CourseDetailsDAOI;

public class CourseDetailsDAO extends BaseDAO implements CourseDetailsDAOI {

	@Override
	public CourseDetails getCourseDetails(Object[] paramName,Object[] paramVal) throws Exception {
		CourseDetails details=null;
		try{
			String query="select u from CourseDetails u";  
			Map params=new HashMap();
			if(null!=paramName && paramName.length==paramVal.length ){
				query=query+ " where ";
				for(int i=0;i<paramName.length;i++){
					query=query+" u."+paramName[i]+"=:"+paramName[i]+" and ";
					params.put(paramName[i], paramVal[i]);
				}
				query=query+ " 1=1 ";
			}
			details=(CourseDetails)getSingleResult(query,params);
		}catch(Exception e){
			e.printStackTrace();
		}
		return details;
	}
	
	@Override
	public List<CourseDetails> getAllCourseDetails() throws Exception {
		List<CourseDetails> details=null;
		try{
			details=(List<CourseDetails>)getResultList("select u from CourseDetails u  ");
		}catch(Exception e){
			e.printStackTrace();
		}
		return details;
	}
 
}
