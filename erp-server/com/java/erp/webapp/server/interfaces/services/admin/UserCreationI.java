package com.java.erp.webapp.server.interfaces.services.admin;

import com.java.erp.webapp.request.admin.UserCreationRequest;
import com.java.erp.webapp.request.user.LoginRequest;
import com.java.erp.webapp.server.interfaces.services.common.Response;

public interface UserCreationI {
public Response getUserList() throws Exception;
public Response saveUserDetails(UserCreationRequest request) throws Exception;
}
