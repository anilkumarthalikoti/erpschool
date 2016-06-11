package com.java.erp.webapp.database.setup;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.java.erp.webapp.database.project.BaseFields;
@Entity
@Table(name="studetn_admission_fields")
public class StudentAdmissionFields extends BaseFields implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long fieldId;
	@Column(name="fieldName",unique=true,nullable=true)
	private String fieldName;
	@Column(name="isRequired",length=1)
	private String isRequired;
	@Column(name="isActiveField",length=1)
	private String isActive;
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getIsRequired() {
		return isRequired;
	}
	public void setIsRequired(String isRequired) {
		this.isRequired = isRequired;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public Long getFieldId() {
		return fieldId;
	}
	 
	
	 
}
