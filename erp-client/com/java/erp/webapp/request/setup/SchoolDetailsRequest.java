package com.java.erp.webapp.request.setup;

import com.java.erp.webapp.request.common.BaseRequest;

public class SchoolDetailsRequest extends BaseRequest {
	private static final long serialVersionUID = 1L;
	
	 private String schoolName;
	 private String regNo;
	 private String webUrl;
	 private String phoneNo;
	 	 private String faxNo;
	 	private String email;
	 	private String regBy;
		public String getSchoolName() {
			return schoolName;
		}
		public void setSchoolName(String schoolName) {
			this.schoolName = schoolName;
		}
		public String getRegNo() {
			return regNo;
		}
		public void setRegNo(String regNo) {
			this.regNo = regNo;
		}
		public String getWebUrl() {
			return webUrl;
		}
		public void setWebUrl(String webUrl) {
			this.webUrl = webUrl;
		}
		public String getPhoneNo() {
			return phoneNo;
		}
		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}
		public String getFaxNo() {
			return faxNo;
		}
		public void setFaxNo(String faxNo) {
			this.faxNo = faxNo;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getRegBy() {
			return regBy;
		}
		public void setRegBy(String regBy) {
			this.regBy = regBy;
		}
	 	
		 
	 

}
