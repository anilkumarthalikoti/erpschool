package com.java.erp.webapp.request.common;

import java.io.Serializable;
import java.util.List;

public  class BaseRequest implements Serializable{
	public String preaction="";
	public static final long serialVersionUID = 1L;
int pageId;
 
public BaseRequest(){
	
}
public int getPageId() {
	return pageId;
}

public void setPageId(int pageId) {
	this.pageId = pageId;
}

public String getPreaction() {
	return preaction;
}

public void setPreaction(String preaction) {
	this.preaction = preaction;
}
 

}
