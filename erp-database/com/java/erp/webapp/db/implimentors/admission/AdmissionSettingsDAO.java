package com.java.erp.webapp.db.implimentors.admission;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.erp.webapp.database.setup.AcademicYears;
import com.java.erp.webapp.db.implimentors.common.BaseDAO;
import com.java.erp.webapp.db.interfaces.admission.AdmissionSettingsDAOI;

public class AdmissionSettingsDAO extends BaseDAO implements AdmissionSettingsDAOI {

	 
	@Override
	public List<Object[]> getAdmissionSettingsList() throws Exception {
		List<Object[]> details=null;
		Map params=new HashMap<Object, String>();
		//params.put("keysearch", "%"+keyWord+"%");
		params.put("dateNow",getCurrentDate());
		try{
			details=(List<Object[]>)getResultList("select bu.branchId,cd.courseId,sd.subjectId,bu.branchName,cd.courseName, sd.subjectName, bd.batchId,bd.isActive,ay.id,ay.academicYear,ads.admissionMode from AdmissionSettings ads,BatchDetails bd, BranchDetails bu,CourseDetails cd, SubjectDetails sd,AcademicYears ay where bd.batchDetailsPk.branchId=bu.branchId and bd.batchDetailsPk.courseId=cd.courseId and bd.batchDetailsPk.subjectId=sd.subjectId and ads.id.mappingId=bd.batchId and ads.id.acYearId= ay.id and ay.acceptFrom<:dateNow and ay.acceptTo>:dateNow",params);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return details;
	}
	
	 
 
}
