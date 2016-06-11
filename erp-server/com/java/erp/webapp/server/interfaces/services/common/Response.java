package com.java.erp.webapp.server.interfaces.services.common;

import java.util.List;

public interface Response {
public void setResultList(List<Object> result);
public void setErrors(List<String> result);
public void setSuccess(List<String> result);
public List<Object> getResultList();
public List<String> getErrors();
public  List<String> getSuccess();
public Response getResponse();
 
}
