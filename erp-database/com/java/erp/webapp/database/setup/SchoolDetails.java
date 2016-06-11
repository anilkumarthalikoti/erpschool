package com.java.erp.webapp.database.setup;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.java.erp.webapp.database.project.BaseFields;
@Entity
@Table(name="erp_school")
public class SchoolDetails extends BaseFields implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Long schoolId;
	@Column(name="schoolName",unique=true,nullable=false)
	 private String schoolName;
	@Column
	 private String regNo;
	@Column
	 private String webUrl;
	@Column
	private String phoneNo;
	@Column
	private String faxNo;
	@Column 	
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
		public Long getSchoolId() {
			return schoolId;
		}
		public void setSchoolId(Long schoolId) {
			this.schoolId = schoolId;
		}
	 	
		 
	 

}
