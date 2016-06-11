package com.java.erp.webapp.db.interfaces.setup;

import java.util.List;

import com.java.erp.webapp.database.setup.SubjectDetails;
import com.java.erp.webapp.db.interfaces.common.BaseDAOI;

public interface SubjectDetailsDAOI extends BaseDAOI {
 public SubjectDetails getSubjectDetails(Object[] paramName ,Object[] paramVal) throws Exception;
 public List<SubjectDetails> getAllSubjectDetails() throws Exception;

}
