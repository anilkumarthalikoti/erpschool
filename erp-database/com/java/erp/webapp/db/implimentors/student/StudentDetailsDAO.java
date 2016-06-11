package com.java.erp.webapp.db.implimentors.student;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.erp.webapp.database.student.StudentDetails;
import com.java.erp.webapp.database.student.StudentHistory;
import com.java.erp.webapp.db.implimentors.common.BaseDAO;
import com.java.erp.webapp.db.interfaces.student.StudentDetailsDAOI;

public class StudentDetailsDAO extends BaseDAO implements StudentDetailsDAOI {

	 
	@Override
	public List<Object[]> getStudentList(String keyWord) throws Exception {
		List<Object[]> details=null;
		Map params=new HashMap<Object, String>();
		params.put("keysearch", "%"+keyWord+"%");
		try{
			details=(List<Object[]>)getResultList("select u.id,u.applicationNo, u.studentId  ,u.studentName , u.fatherName , u.motherName , u.contactNo, '-' , u.address,u.applicationStatus,u.gender,u.dob,u.requestedCourse,'-'     from StudentDetails u where  u.studentId is not null and( u.studentName like :keysearch or u.fatherName like :keysearch or u.motherName like :keysearch or u.contactNo  like :keysearch or u.applicationNo like :keysearch or u.studentId like :keysearch or u.admissionNo like :keysearch  )   ",params);
		
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
			details=(List<Object[]>)getResultList("select u.id,u.applicationNo, u.studentId  ,u.studentName , u.fatherName , u.motherName , u.contactNo, '-' , u.address,u.applicationStatus,u.gender,u.dob,u.requestedCourse,(select bu.branchName||'-'||cd.courseName||'-'||sd.subjectName from BatchDetails bd, BranchDetails bu,CourseDetails cd, SubjectDetails sd where bd.batchDetailsPk.branchId=bu.branchId and bd.batchDetailsPk.courseId=cd.courseId and bd.batchDetailsPk.subjectId=sd.subjectId  and bd.batchId=u.requestedCourse)     from StudentDetails u where   u.studentId is null and (u.studentName like :keysearch or u.fatherName like :keysearch or u.motherName like :keysearch or u.contactNo  like :keysearch or u.applicationNo like :keysearch or u.studentId like :keysearch or u.admissionNo like :keysearch)     ",params);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return details;
	}
	public String getApplicationGen(Long acyear) throws Exception{
		
		String res="";
		 NumberFormat nf=new DecimalFormat("0000");
		 Map<Object,Object> params=new HashMap<Object, Object>();
		 params.put("acyear", acyear);
		 String query="select count(id) from StudentDetails where joinedAcYear=:acyear";
		List<Object[]> data=(List<Object[]>)getResultList(query, params);
		String number=((Object)data.get(0)).toString();
		res=nf.format(Integer.valueOf(number)+1);
		System.out.println(res);
		 return res;
	}
	public StudentDetails getStudent(Long refId) throws Exception{
		StudentDetails student=null;
		 Map<Object,Object> params=new HashMap<Object, Object>();
		 params.put("studentId", refId);
		 student=(StudentDetails)getSingleResult("select u from StudentDetails u where u.id=:studentId",params);
		return student;
	}
	public StudentDetails getStudent(String  applicationId) throws Exception{
		StudentDetails student=null;
		 Map<Object,Object> params=new HashMap<Object, Object>();
		 params.put("studentId", applicationId);
		 params.put("applicationNo", applicationId);
		 student=(StudentDetails)getSingleResult("select u from StudentDetails u where u.studentId=:studentId or u.applicationNo=:applicationNo",params);
		return student;
	}
	public List<StudentHistory> getStudentHistory(Long regId) throws Exception{
		List<StudentHistory> studentHistory=null;
		 Map<Object,Object> params=new HashMap<Object, Object>();
		 params.put("refId", regId);
		 studentHistory=(List<StudentHistory>) getResultList("select u from StudentHistory u where u.refId=:refId ",params);
		return studentHistory;
	}
}
