package com.java.erp.webapp.request.admission;

import com.java.erp.webapp.request.common.BaseRequest;

public class AdmissionAuthorizationRequest extends BaseRequest {
	private static final long serialVersionUID = 1L;
	
	 private Long authorizationId;
	 private String acyear;
	 private String status;
	 private String prefix;
	 private String seriseStarts;
	 private String seriesEnds;
	 private String acceptDate;
	 private String acceptTo;
	public Long getAuthorizationId() {
		return authorizationId;
	}
	public void setAuthorizationId(Long authorizationId) {
		this.authorizationId = authorizationId;
	}
	public String getAcyear() {
		return acyear;
	}
	public void setAcyear(String acyear) {
		this.acyear = acyear;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getSeriseStarts() {
		return seriseStarts;
	}
	public void setSeriseStarts(String seriseStarts) {
		this.seriseStarts = seriseStarts;
	}
	public String getSeriesEnds() {
		return seriesEnds;
	}
	public void setSeriesEnds(String seriesEnds) {
		this.seriesEnds = seriesEnds;
	}
	public String getAcceptDate() {
		return acceptDate;
	}
	public void setAcceptDate(String acceptDate) {
		this.acceptDate = acceptDate;
	}
	public String getAcceptTo() {
		return acceptTo;
	}
	public void setAcceptTo(String acceptTo) {
		this.acceptTo = acceptTo;
	}
	 

}
