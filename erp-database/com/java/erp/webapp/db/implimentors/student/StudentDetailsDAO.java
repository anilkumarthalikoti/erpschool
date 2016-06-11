package com.java.erp.webapp.db.implimentors.student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.erp.webapp.database.setup.CourseDetails;
import com.java.erp.webapp.db.implimentors.common.BaseDAO;
import com.java.erp.webapp.db.interfaces.student.StudentDetailsDAOI;

public class StudentDetailsDAO extends BaseDAO implements StudentDetailsDAOI {

	 
	@Override
	public List<Object[]> getStudentList(String keyWord) throws Exception {
		List<Object[]> details=null;
		Map params=new HashMap<Object, String>();
		params.put("keysearch", "%"+keyWord+"%");
		try{
			details=(List<Object[]>)getResultList("select u.id,u.applicationNo, u.studentId  ,u.studentName , u.fatherName , u.motherName , u.contactNo, '-' , u.address,u.applicationStatus     from StudentDetails u where  u.studentId is not null and( u.studentName like :keysearch or u.fatherName like :keysearch or u.motherName like :keysearch or u.contactNo  like :keysearch or u.applicationNo like :keysearch or u.studentId like :keysearch or u.admissionNo like :keysearch  )   ",params);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return details;
	}
	
	@Override
	public List<Object[]> getAdmissionList(String keyWord) throws Exception {
		List<Object[]> details=null;
		Map params=new HashMap<Object, String>();
		params.put("keysearch", "%"+keyWord+"%");
		try{
			details=(List<Object[]>)getResultList("select u.id,u.applicationNo, u.studentId  ,u.studentName , u.fatherName , u.motherName , u.contactNo, '-' , u.address,u.applicationStatus     from StudentDetails u where   u.studentId is null and (u.studentName like :keysearch or u.fatherName like :keysearch or u.motherName like :keysearch or u.contactNo  like :keysearch or u.applicationNo like :keysearch or u.studentId like :keysearch or u.admissionNo like :keysearch)     ",params);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return details;
	}
 
}
