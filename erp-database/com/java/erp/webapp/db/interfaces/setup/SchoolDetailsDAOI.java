package com.java.erp.webapp.db.interfaces.setup;

import java.util.List;

import com.java.erp.webapp.database.setup.SchoolDetails;
import com.java.erp.webapp.database.user.Users;
import com.java.erp.webapp.db.interfaces.common.BaseDAOI;
import com.java.erp.webapp.request.user.LoginRequest;

public interface SchoolDetailsDAOI extends BaseDAOI {
 public SchoolDetails getSchoolDetails() throws Exception;


}
