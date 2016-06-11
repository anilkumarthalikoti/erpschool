package com.java.erp.webapp.database.setup;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.java.erp.webapp.database.project.BaseFields;
@Entity
@Table(name="erp_course")
public class CourseDetails extends BaseFields implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long courseId;
	@Column(name="courseName",unique=true,nullable=false)
	 private String courseName;
	 @Column(name="prority" ,unique=true,nullable=false)
	 private Integer prority ;
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	 
	public Long getCourseId() {
		return courseId;
	}
	public Integer getPrority() {
		return prority;
	}
	public void setPrority(Integer prority) {
		this.prority = prority;
	}
	 
}
