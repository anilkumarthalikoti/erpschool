package com.java.erp.webapp.db.interfaces.student;

import java.util.List;

import com.java.erp.webapp.database.student.StudentDetails;
import com.java.erp.webapp.database.student.StudentHistory;
import com.java.erp.webapp.db.interfaces.common.BaseDAOI;

public interface StudentDetailsDAOI extends BaseDAOI {
 public List<Object[]> getStudentList(String keyword) throws Exception;
 public List<Object[]> getAdmissionList(String keyword) throws Exception;
public String getApplicationGen(Long acyear) throws Exception;
public StudentDetails getStudent(Long studentRefId) throws Exception;
public StudentDetails getStudent(String appliction) throws Exception;
public List<StudentHistory> getStudentHistory(Long refId) throws Exception;
}
