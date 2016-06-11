package com.java.erp.webapp.server.interfaces.services.user;

import com.java.erp.webapp.request.user.LoginRequest;
import com.java.erp.webapp.server.interfaces.services.common.Response;

public interface LoginI {
public Response checkForAdmin() throws Exception;
public Response createAdmin(LoginRequest request) throws Exception;
public Response validateLogin(LoginRequest request) throws Exception;
}
