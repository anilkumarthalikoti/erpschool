package com.java.erp.webapp.request.setup;

import com.java.erp.webapp.request.common.BaseRequest;

public class CourseDetailsRequest extends BaseRequest {
	private static final long serialVersionUID = 1L;
	private Long courseId;
	 private String courseName;
	 private Integer prority;
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getPrority() {
		return prority;
	}
	public void setPrority(Integer prority) {
		this.prority = prority;
	}
	 	 
		 
	 

}
