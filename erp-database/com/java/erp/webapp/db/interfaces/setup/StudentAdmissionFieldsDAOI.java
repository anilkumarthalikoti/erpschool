package com.java.erp.webapp.db.interfaces.setup;

import java.util.List;

import com.java.erp.webapp.database.setup.BatchDetails;
import com.java.erp.webapp.database.setup.BranchDetails;
import com.java.erp.webapp.database.setup.StudentAdmissionFields;
import com.java.erp.webapp.db.interfaces.common.BaseDAOI;

public interface StudentAdmissionFieldsDAOI extends BaseDAOI {
 public StudentAdmissionFields getStudentAdmissionFields(Object[] paramName ,Object[] paramVal) throws Exception;
 public List<StudentAdmissionFields> getAllStudentAdmissionFields() throws Exception;

}
