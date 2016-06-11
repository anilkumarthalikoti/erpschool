package com.java.erp.webapp.request.admission;

import com.java.erp.webapp.request.common.BaseRequest;

public class AdmissionDetailsRequest extends BaseRequest {
	private static final long serialVersionUID = 1L;
	
	private String searchKey;

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	 

}
