package com.java.erp.webapp.db.implimentors.admission;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.erp.webapp.database.setup.AcademicYears;
import com.java.erp.webapp.db.implimentors.common.BaseDAO;
import com.java.erp.webapp.db.interfaces.admission.AdmissionAuthorizationDAOI;

public class AdmissionAuthorizationDAO extends BaseDAO implements AdmissionAuthorizationDAOI {

	 
	@Override
	public List<AcademicYears> getAdmissionAuthorizationList() throws Exception {
		List<AcademicYears> details=null;
		Map params=new HashMap<Object, String>();
		//params.put("keysearch", "%"+keyWord+"%");
		try{
			details=(List<AcademicYears>)getResultList("select u  from AcademicYears u  ",params);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return details;
	}
	
	@Override
	public  AcademicYears  getAcademicYear(Long id) throws Exception {
		 AcademicYears  details=null;
		Map params=new HashMap<Object, String>();
		//params.put("keysearch", "%"+keyWord+"%");
		params.put("id",id);
		try{
			details=( AcademicYears )getSingleResult( "select u  from AcademicYears u where u.id=:id  ",params);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return details;
	}
 
	
}
