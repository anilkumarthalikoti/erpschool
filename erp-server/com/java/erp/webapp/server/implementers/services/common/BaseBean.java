package com.java.erp.webapp.server.implementers.services.common;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.java.erp.webapp.db.implimentors.admission.AdmissionAuthorizationDAO;
import com.java.erp.webapp.db.implimentors.admission.AdmissionSettingsDAO;
import com.java.erp.webapp.db.implimentors.dashboard.DashBoardDAO;
import com.java.erp.webapp.db.implimentors.dashboard.ReminderDAO;
import com.java.erp.webapp.db.implimentors.finance.FeeStructureDAO;
import com.java.erp.webapp.db.implimentors.project.ProjectDetailsDAO;
import com.java.erp.webapp.db.implimentors.setup.BatchDetailsDAO;
import com.java.erp.webapp.db.implimentors.setup.BranchDetailsDAO;
import com.java.erp.webapp.db.implimentors.setup.CourseDetailsDAO;
import com.java.erp.webapp.db.implimentors.setup.SchoolDetailsDAO;
import com.java.erp.webapp.db.implimentors.setup.StudentAdmissionFieldsDAO;
import com.java.erp.webapp.db.implimentors.setup.SubjectDetailsDAO;
import com.java.erp.webapp.db.implimentors.student.StudentDetailsDAO;
import com.java.erp.webapp.db.implimentors.user.UserDAO;
import com.java.erp.webapp.db.interfaces.admission.AdmissionAuthorizationDAOI;
import com.java.erp.webapp.db.interfaces.admission.AdmissionSettingsDAOI;
import com.java.erp.webapp.db.interfaces.dashboard.DashBoardDAOI;
import com.java.erp.webapp.db.interfaces.dashboard.ReminderDAOI;
import com.java.erp.webapp.db.interfaces.finance.FeeStructureDAOI;
import com.java.erp.webapp.db.interfaces.project.ProjectDetailsDAOI;
import com.java.erp.webapp.db.interfaces.setup.BatchDetailsDAOI;
import com.java.erp.webapp.db.interfaces.setup.BranchDetailsDAOI;
import com.java.erp.webapp.db.interfaces.setup.CourseDetailsDAOI;
import com.java.erp.webapp.db.interfaces.setup.SchoolDetailsDAOI;
import com.java.erp.webapp.db.interfaces.setup.StudentAdmissionFieldsDAOI;
import com.java.erp.webapp.db.interfaces.setup.SubjectDetailsDAOI;
import com.java.erp.webapp.db.interfaces.student.StudentDetailsDAOI;
import com.java.erp.webapp.db.interfaces.user.LoginDAOI;

@Component
public class BaseBean implements Serializable {
	private static final long serialVersionUID = 1L;

	LoginDAOI loginDao;
	SchoolDetailsDAOI schoolDetailsDao;
	BranchDetailsDAOI branchDetailsDao;
	BatchDetailsDAOI batchDetailsDao;
	CourseDetailsDAOI courseDetailsDao;
	SubjectDetailsDAOI subjectDetailsDao;
	StudentDetailsDAOI studentDetailsDao;
	AdmissionAuthorizationDAOI admissionAuthorization;
	StudentAdmissionFieldsDAOI studentAdmissionFields;
	AdmissionSettingsDAOI admissionSettingdDao;
	DashBoardDAOI dashBoardDao;
	ReminderDAOI reminderDao;
	FeeStructureDAOI feeStructureDao;
	ProjectDetailsDAOI projectDetailsDao;

	public LoginDAOI getLoginDao() {
		if (null == loginDao) {
			loginDao = new UserDAO();
		}
		return loginDao;
	}

	public SchoolDetailsDAOI getSchoolDetailsDao() {
		if (null == schoolDetailsDao) {
			schoolDetailsDao = new SchoolDetailsDAO();
		}
		return schoolDetailsDao;
	}

	public BranchDetailsDAOI getBranchDetailsDao() {
		if (null == branchDetailsDao) {
			branchDetailsDao = new BranchDetailsDAO();
		}
		return branchDetailsDao;
	}

	public SubjectDetailsDAOI getSubjectDetailsDao() {
		if (null == subjectDetailsDao) {
			subjectDetailsDao = new SubjectDetailsDAO();
		}
		return subjectDetailsDao;
	}

	public CourseDetailsDAOI getCourseDetailsDao() {
		if (null == courseDetailsDao) {
			courseDetailsDao = new CourseDetailsDAO();
		}
		return courseDetailsDao;
	}

	public BatchDetailsDAOI getBatchDetailsDao() {
		if (null == batchDetailsDao) {
			batchDetailsDao = new BatchDetailsDAO();
		}
		return batchDetailsDao;
	}

	public StudentDetailsDAOI getStudentDetailsDao() {
		if (null == studentDetailsDao) {
			studentDetailsDao = new StudentDetailsDAO();
		}
		return studentDetailsDao;
	}

	public AdmissionAuthorizationDAOI getAdmissionAuthorizationDao() {
		if (null == admissionAuthorization) {
			admissionAuthorization = new AdmissionAuthorizationDAO();
		}
		return admissionAuthorization;
	}

	public StudentAdmissionFieldsDAOI getStudentAdmissionFieldsDao() {
		if (null == studentAdmissionFields) {
			studentAdmissionFields = new StudentAdmissionFieldsDAO();
		}
		return studentAdmissionFields;
	}

	public AdmissionSettingsDAOI getAdmissionSettingsDao() {
		if (null == admissionSettingdDao) {
			admissionSettingdDao = new AdmissionSettingsDAO();
		}
		return admissionSettingdDao;
	}

	public DashBoardDAOI getDashBoardDao() {
		if (null == dashBoardDao) {
			dashBoardDao = new DashBoardDAO();
		}
		return dashBoardDao;
	}

	public ReminderDAOI getReminderDao() {

		if (null == reminderDao) {
			reminderDao = new ReminderDAO();
		}
		return reminderDao;
	}

	public FeeStructureDAOI getFeeStructureDao() {

		if (null == feeStructureDao) {
			feeStructureDao = new FeeStructureDAO();
		}
		return feeStructureDao;
	}

	public ProjectDetailsDAOI getProjectDetailsDao() {

		if (null == projectDetailsDao) {
			projectDetailsDao = new ProjectDetailsDAO();
		}
		return projectDetailsDao;
	}
}
