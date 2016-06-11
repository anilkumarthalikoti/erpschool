package com.java.erp.webapp.db.interfaces.user;

import java.util.List;

import com.java.erp.webapp.database.user.Users;
import com.java.erp.webapp.db.interfaces.common.BaseDAOI;
import com.java.erp.webapp.request.user.LoginRequest;

public interface LoginDAOI extends BaseDAOI {
public List<Users> getUsers(LoginRequest loginRequest) throws Exception;
public  boolean checkForAdmin() throws Exception;
public  Users  getUser(LoginRequest loginRequest) throws Exception;


}
