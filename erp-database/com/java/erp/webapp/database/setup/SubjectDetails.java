package com.java.erp.webapp.database.setup;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.java.erp.webapp.database.project.BaseFields;
@Entity
@Table(name="erp_subjects")
public class SubjectDetails extends BaseFields implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long subjectId;
	@Column(name="subjectName",unique=true,nullable=false)
	 private String subjectName;
	 @Column(name="prority" ,unique=true,nullable=false)
	 private Integer prority ;
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public Integer getPrority() {
		return prority;
	}
	public void setPrority(Integer prority) {
		this.prority = prority;
	}
	public Long getSubjectId() {
		return subjectId;
	}
	 
	 
}
