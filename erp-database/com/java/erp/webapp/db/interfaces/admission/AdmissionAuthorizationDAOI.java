package com.java.erp.webapp.db.interfaces.admission;

import java.util.List;

import com.java.erp.webapp.database.setup.AcademicYears;
import com.java.erp.webapp.database.setup.CourseDetails;
import com.java.erp.webapp.db.interfaces.common.BaseDAOI;

public interface AdmissionAuthorizationDAOI extends BaseDAOI {
 public List<AcademicYears> getAdmissionAuthorizationList() throws Exception;
 public  AcademicYears  getAcademicYear(Long id) throws Exception;
 

}
