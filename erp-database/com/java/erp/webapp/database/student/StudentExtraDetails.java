package com.java.erp.webapp.database.student;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import com.java.erp.webapp.database.project.BaseFields;
@Entity
@Table(name="stu_student_details_extra")
public class StudentExtraDetails extends BaseFields implements Serializable {
private static final long serialVersionUID = 1L;
@EmbeddedId
StudentExtraFieldId extraId=new StudentExtraFieldId();
@Column(name="field_value")
private String fieldValue;
public StudentExtraFieldId getExtraId() {
	return extraId;
}
public void setExtraId(StudentExtraFieldId extraId) {
	this.extraId = extraId;
}
public String getFieldValue() {
	return fieldValue;
}
public void setFieldValue(String fieldValue) {
	this.fieldValue = fieldValue;
}




}
