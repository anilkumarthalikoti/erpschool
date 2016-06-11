package com.java.erp.webapp.server.implementers.services.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.java.erp.webapp.server.interfaces.services.common.Response;

public class Result implements Response,Serializable {
List<Object> result=null;
List<String> errorMessages=null;
List<String> successMessages=null;
 public Result(){
	 result=new ArrayList<Object>();
	  errorMessages=new ArrayList<String>();
	  successMessages=new ArrayList<String>();
 }
@Override
public final void setResultList(final List<Object> result) {
	this.result.clear();
	this.result.addAll(result);
	
}
@Override
public final void setErrors(final List<String> result) {
	this.errorMessages.clear();
	this.errorMessages.addAll(result);
	
}
@Override
public final void setSuccess(final List<String> result) {
	this.successMessages.clear();
	this.successMessages.addAll(result);
}
@Override
public final List<Object> getResultList() {
	return this.result;
}
@Override
public final List<String> getErrors() {
	return this.errorMessages;
}
@Override
public final List<String> getSuccess() {
	return this.successMessages;
}
@Override
public Response getResponse() {
	// TODO Auto-generated method stub
	return this;
} 
 
}
