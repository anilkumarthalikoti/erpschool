package com.java.erp.webapp.request.setup;

import com.java.erp.webapp.request.common.BaseRequest;

public class BranchDetailsRequest extends BaseRequest {
	private static final long serialVersionUID = 1L;
	private Long branchId;
	 private String branchName;
	 private String location;
	 private String address;
	 private String phoneNo;
	 	 private String faxNo;
	 	private String email;
	 	 
		public Long getBranchId() {
			return branchId;
		}
		public void setBranchId(Long branchId) {
			this.branchId = branchId;
		}
		public String getBranchName() {
			return branchName;
		}
		public void setBranchName(String branchName) {
			this.branchName = branchName;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
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
	 
		 
	 

}
