package com.java.erp.webapp.db.interfaces.setup;

import java.util.List;

import com.java.erp.webapp.database.setup.CourseDetails;
import com.java.erp.webapp.db.interfaces.common.BaseDAOI;

public interface CourseDetailsDAOI extends BaseDAOI {
 public CourseDetails getCourseDetails(Object[] paramName ,Object[] paramVal) throws Exception;
 public List<CourseDetails> getAllCourseDetails() throws Exception;

}
