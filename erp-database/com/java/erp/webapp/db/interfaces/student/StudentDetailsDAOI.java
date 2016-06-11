package com.java.erp.webapp.db.interfaces.student;

import java.util.List;

import com.java.erp.webapp.database.setup.CourseDetails;
import com.java.erp.webapp.db.interfaces.common.BaseDAOI;

public interface StudentDetailsDAOI extends BaseDAOI {
 public List<Object[]> getStudentList(String keyword) throws Exception;
 public List<Object[]> getAdmissionList(String keyword) throws Exception;

}
