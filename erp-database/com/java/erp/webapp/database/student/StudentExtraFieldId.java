package com.java.erp.webapp.database.student;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StudentExtraFieldId implements Serializable {
	@Column(name="ref_no")
	private Long id;
	@Column(name="field_id")
	private Long fieldId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getFieldId() {
		return fieldId;
	}
	public void setFieldId(Long fieldId) {
		this.fieldId = fieldId;
	}
	
}
