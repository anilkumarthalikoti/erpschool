package com.java.erp.webapp.database.setup;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BatchDetailsPk implements Serializable{
	@Column(name="branchId")
	private Long branchId;
	@Column(name="courseId")
	private Long courseId;
	@Column(name="subjectId")
	private Long subjectId;
	
	public Long getBranchId() {
		return branchId;
	}
	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public Long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
}
