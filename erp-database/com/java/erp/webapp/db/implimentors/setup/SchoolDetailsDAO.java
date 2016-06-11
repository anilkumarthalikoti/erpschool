package com.java.erp.webapp.db.implimentors.setup;

import com.java.erp.webapp.database.setup.SchoolDetails;
import com.java.erp.webapp.database.user.Users;
import com.java.erp.webapp.db.implimentors.common.BaseDAO;
import com.java.erp.webapp.db.interfaces.setup.SchoolDetailsDAOI;

public class SchoolDetailsDAO extends BaseDAO implements SchoolDetailsDAOI {

	@Override
	public SchoolDetails getSchoolDetails() throws Exception {
		SchoolDetails details=null;
		try{
			details=(SchoolDetails)getSingleResult("select u from SchoolDetails u  ");
		}catch(Exception e){
			e.printStackTrace();
		}
		return details;
	}
 
}
