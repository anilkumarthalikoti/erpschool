package com.java.erp.webapp.db.implimentors.setup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.erp.webapp.database.setup.BatchDetails;
import com.java.erp.webapp.database.setup.StudentAdmissionFields;
import com.java.erp.webapp.db.implimentors.common.BaseDAO;
import com.java.erp.webapp.db.interfaces.setup.BatchDetailsDAOI;
import com.java.erp.webapp.db.interfaces.setup.StudentAdmissionFieldsDAOI;

public class StudentAdmissionFieldsDAO extends BaseDAO implements StudentAdmissionFieldsDAOI{

	@Override
	public StudentAdmissionFields getStudentAdmissionFields(Object[] paramName,Object[] paramVal) throws Exception {
		StudentAdmissionFields details=null;
		try{
			String query="select u from StudentAdmissionFields u";  
			Map params=new HashMap();
			if(null!=paramName && paramName.length==paramVal.length ){
				query=query+ " where ";
				for(int i=0;i<paramName.length;i++){
					query=query+" u."+paramName[i]+"=:"+paramName[i]+" and ";
					params.put(paramName[i], paramVal[i]);
				}
				query=query+ " 1=1 ";
			}
			details=(StudentAdmissionFields)getSingleResult(query,params);
		}catch(Exception e){
			e.printStackTrace();
		}
		return details;
	}
	
	@Override
	public List<StudentAdmissionFields> getAllStudentAdmissionFields() throws Exception {
		List<StudentAdmissionFields> details=null;
		try{
			details=(List<StudentAdmissionFields>)getResultList("select u from StudentAdmissionFields u  ");
		}catch(Exception e){
			e.printStackTrace();
		}
		return details;
	}
 
}
