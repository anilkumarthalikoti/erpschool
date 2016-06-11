package com.java.erp.webapp.server.implementers.services.user;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.java.erp.webapp.database.project.ProjectModules;
import com.java.erp.webapp.database.project.ProjectPages;
import com.java.erp.webapp.database.setup.AcademicYears;
import com.java.erp.webapp.database.user.Users;
import com.java.erp.webapp.request.user.LoginRequest;
import com.java.erp.webapp.server.exception.ExceptionMessageHandler;
import com.java.erp.webapp.server.implementers.services.common.BaseBean;
import com.java.erp.webapp.server.implementers.services.common.Result;
import com.java.erp.webapp.server.interfaces.services.common.Response;
import com.java.erp.webapp.server.interfaces.services.user.LoginI;

@Service
public class LoginBean extends BaseBean implements LoginI {
	private static final long serialVersionUID = 1L;

	@Override
	public Response checkForAdmin() throws Exception {
		Response result = new Result();
		List<Object> resultHolder = new ArrayList<Object>();
		resultHolder.add(getLoginDao().checkForAdmin());
		result.setResultList(resultHolder);
		return result;
	}

	@Override
	public Response createAdmin(LoginRequest request) throws Exception {
		Response result = new Result();
		List<Object> resultHolder = new ArrayList<Object>();
		if (getLoginDao().checkForAdmin()) {
			Users u = new Users();
			u.setIsAdmin("Y");
			u.setUserId(request.getLoginId());
			u.setPassword(request.getLoginPassword());
			u.setName("ADMINSTRATOR");
			u.setDashboardView(new Byte(Byte.valueOf("1")));
			getLoginDao().merge(u);
			getLoginDao().flush();

		}
		Calendar c3 = Calendar.getInstance();
		c3.setTime(getLoginDao().getCurrentDate());
		int start = 2003;
		int next = 2004;
		for (int i = 0; i < 30; i++) {
			AcademicYears acyear = new AcademicYears();
			String nextAcyear = ((next + i) + "").substring(2, 4);
			acyear.setAcademicYear((start + i) + "-" + nextAcyear);
			acyear.setIsActive("N");
			acyear.setApplicationPrefix("");
			acyear.setSeriesFrom("0001");
			acyear.setSeriesTo("0009");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Calendar calendar = new GregorianCalendar(start + i, 2, 31);
			Calendar calendar1 = new GregorianCalendar(next + i, 2, 31);

			if (calendar1.after(c3) && calendar.before(c3)) {
				acyear.setIsActive("Y");
			}
			acyear.setAcceptFrom(calendar.getTime());
			acyear.setAcceptTo(calendar1.getTime());

			getLoginDao().merge(acyear);
			getLoginDao().flush();
		}
		updateModuels();
		resultHolder.add(getLoginDao().checkForAdmin());
		result.setResultList(resultHolder);
		return result;
	}

	@Override
	public Response validateLogin(LoginRequest request) throws Exception {
		Response result = new Result();
		List<Object> resultHolder = new ArrayList<Object>();
		Users u = getLoginDao().getUser(request);
		if (null != u && u.getPassword().equals(request.getLoginPassword())) {
			resultHolder.add(u);
		} else {
			throw new ExceptionMessageHandler("Invalid Login/Password");
		}

		result.setResultList(resultHolder);
		return result;
	}

	private void updateModuels() {
		Map<Integer, Object[]> modules = new HashMap<Integer, Object[]>();
		modules.put(1, new Object[] { 1, "DASHBOARD", "Y", 1 });
		modules.put(2, new Object[] { 2, "ADMISSION", "Y", 2 });
		modules.put(3, new Object[] { 3, "FINANCE", "Y", 3 });
		modules.put(4, new Object[] { 4, "STUDENT", "Y", 4 });
		modules.put(5, new Object[] { 5, "ACADEMICS", "Y", 5 });
		modules.put(6, new Object[] { 6, "LIBRARY", "Y", 6 });
		modules.put(7, new Object[] { 7, "TRANSPORT", "Y", 7 });
		modules.put(8, new Object[] { 8, "USER", "Y", 8 });
		modules.put(9, new Object[] { 9, "SETUP", "Y", 9 });
		modules.put(10, new Object[] { 10, "ADMINISTRATOR", "Y", 10 });
		for (Map.Entry<Integer, Object[]> module : modules.entrySet()) {
			Object[] moduleData = module.getValue();
			ProjectModules pm = new ProjectModules();
			pm.setModuleId(Integer.valueOf(moduleData[0].toString()));
			pm.setModuleName(moduleData[1].toString());
			if ("Y".equals(moduleData[2].toString())) {
				pm.setEnabled('Y');
			} else {
				pm.setEnabled('N');
			}
			pm.setPriority(Integer.valueOf(moduleData[3].toString()));
			try {
				getLoginDao().merge(pm);
				getLoginDao().flush();
			} catch (Exception e) {

			}
		}
		Map<Integer, Object[]> subLinks = new HashMap<Integer, Object[]>();
		subLinks.put(1, new Object[] { "MY DASHBOARD", "Y", 1, 1, "dashboard" });
		subLinks.put(2, new Object[] { "REMINDERS", "Y", 2, 1, "addreminder" });
		subLinks.put(3, new Object[] { "ANNOUNCEMENT", "Y", 3, 1,
				"addannouncement" });
		subLinks.put(4, new Object[] { "ADMISSION AUTHORIZATION", "Y", 1, 2,
				"admissionauthorization" });
		subLinks.put(5, new Object[] { "ADMISSION SETTINGS", "Y", 2, 2,
				"admissionsettings" });
		subLinks.put(6, new Object[] { "INTERVIEW SCHEDULE", "Y", 3, 2,
				"interviewschedule" });
		subLinks.put(7, new Object[] { "INTERVIEWER SCHEDULE", "Y", 4, 2,
				"interviewerschedule" });
		subLinks.put(8, new Object[] { "EXAM SUBJECTS", "Y", 5, 2,
				"admissionexamsubjects" });
		subLinks.put(9, new Object[] { "EXAM SUBJECTS MARKS", "Y", 6, 2,
				"admissionexammarks" });
		subLinks.put(10, new Object[] { "APPLICATION FORM", "Y", 7, 2,
				"admission" });
		subLinks.put(11, new Object[] { "ACCEPT/REJECT APPLICATION", "Y", 8, 2,
				"admAcceptReject" });
		subLinks.put(12, new Object[] { "TEST", "N", 9, 2, "#" });
		subLinks.put(13, new Object[] { "FEE GROUPS", "Y", 1, 3, "feegroups" });
		subLinks.put(14, new Object[] { "FEE HEADS", "Y", 2, 3, "feeheads" });
		subLinks.put(15, new Object[] { "FEE STRUCTURE", "Y", 3, 3,
				"feestructure" });
		subLinks.put(16,
				new Object[] { "CONCESSIONS", "Y", 4, 3, "concession" });
		subLinks.put(17, new Object[] { "CONCESSION STRUCTURE", "Y", 5, 3,
				"concessionstructure" });
		subLinks.put(18, new Object[] { "APPLY CONCESSION", "Y", 6, 3,
				"applyconcession" });
		subLinks.put(19, new Object[] { "FEE PAYMENTS", "Y", 7, 3, "payments" });
		subLinks.put(20, new Object[] { "CANCEL PAYMENTS", "Y", 8, 3,
				"cancelpayments" });
		subLinks.put(21, new Object[] { "DUPLICATE RECEIPTS", "Y", 9, 3,
				"feeduplicatereceipt" });
		subLinks.put(22, new Object[] { "STUDENT DETAILS", "Y", 1, 4,
				"studentdetails" });
		subLinks.put(23, new Object[] { "TEST", "N", 2, 4, "#" });
		subLinks.put(24, new Object[] { "TEST", "N", 3, 4, "#" });
		subLinks.put(25, new Object[] { "TEST", "N", 4, 4, "#" });
		subLinks.put(26, new Object[] { "TEST", "N", 5, 4, "#" });
		subLinks.put(27, new Object[] { "TEST", "N", 6, 4, "#" });
		subLinks.put(28, new Object[] { "TEST", "N", 7, 4, "#" });
		subLinks.put(29, new Object[] { "TEST", "N", 8, 4, "#" });
		subLinks.put(30, new Object[] { "TEST", "N", 9, 4, "#" });
		subLinks.put(31, new Object[] { "TEST", "N", 1, 5, "#" });
		subLinks.put(32, new Object[] { "TEST", "N", 2, 5, "#" });
		subLinks.put(33, new Object[] { "TEST", "N", 3, 5, "#" });
		subLinks.put(34, new Object[] { "TEST", "N", 4, 5, "#" });
		subLinks.put(35, new Object[] { "TEST", "N", 5, 5, "#" });
		subLinks.put(36, new Object[] { "TEST", "N", 6, 5, "#" });
		subLinks.put(37, new Object[] { "TEST", "N", 7, 5, "#" });
		subLinks.put(38, new Object[] { "TEST", "N", 8, 5, "#" });
		subLinks.put(39, new Object[] { "TEST", "N", 9, 5, "#" });
		subLinks.put(40, new Object[] { "TEST", "N", 1, 6, "#" });
		subLinks.put(41, new Object[] { "TEST", "N", 2, 6, "#" });
		subLinks.put(42, new Object[] { "TEST", "N", 3, 6, "#" });
		subLinks.put(43, new Object[] { "TEST", "N", 4, 6, "#" });
		subLinks.put(44, new Object[] { "TEST", "N", 5, 6, "#" });
		subLinks.put(45, new Object[] { "TEST", "N", 6, 6, "#" });
		subLinks.put(46, new Object[] { "TEST", "N", 7, 6, "#" });
		subLinks.put(47, new Object[] { "TEST", "N", 8, 6, "#" });
		subLinks.put(48, new Object[] { "TEST", "N", 9, 6, "#" });
		subLinks.put(49, new Object[] { "TEST", "N", 1, 7, "#" });
		subLinks.put(50, new Object[] { "TEST", "N", 2, 7, "#" });
		subLinks.put(51, new Object[] { "TEST", "N", 3, 7, "#" });
		subLinks.put(52, new Object[] { "TEST", "N", 4, 7, "#" });
		subLinks.put(53, new Object[] { "TEST", "N", 5, 7, "#" });
		subLinks.put(54, new Object[] { "TEST", "N", 6, 7, "#" });
		subLinks.put(55, new Object[] { "TEST", "N", 7, 7, "#" });
		subLinks.put(56, new Object[] { "TEST", "N", 8, 7, "#" });
		subLinks.put(57, new Object[] { "TEST", "N", 9, 7, "#" });
		subLinks.put(58, new Object[] { "ROLES CREATION", "N", 1, 8, "#" });
		subLinks.put(59, new Object[] { "USER CREATION", "Y", 2, 8, "userweb" });
		subLinks.put(60, new Object[] { "TEST", "N", 3, 8, "#" });
		subLinks.put(61, new Object[] { "TEST", "N", 4, 8, "#" });
		subLinks.put(62, new Object[] { "TEST", "N", 5, 8, "#" });
		subLinks.put(63, new Object[] { "TEST", "N", 6, 8, "#" });
		subLinks.put(64, new Object[] { "TEST", "N", 7, 8, "#" });
		subLinks.put(65, new Object[] { "TEST", "N", 8, 8, "#" });
		subLinks.put(66, new Object[] { "TEST", "N", 9, 8, "#" });
		subLinks.put(67, new Object[] { "SCHOOL DETAILS", "Y", 1, 9,
				"schooldetails" });
		subLinks.put(68, new Object[] { "BRANCH DETAILS", "Y", 2, 9,
				"branchdetails" });
		subLinks.put(69, new Object[] { "COURSE DETAILS", "Y", 3, 9,
				"coursedetails" });
		subLinks.put(70, new Object[] { "LANGUAGES", "Y", 4, 9,
				"subjectdetails" });
		subLinks.put(71, new Object[] { "MAPPINGS(BRANCHS,COURSES,LANGUAGES)",
				"Y", 5, 9, "batchdetails" });
		subLinks.put(72, new Object[] { "STUDENT/ADMISSION FIELDS", "Y", 6, 9,
				"studentadmissionfields" });
		subLinks.put(73, new Object[] { "TEST", "N", 7, 9, "#" });
		subLinks.put(74, new Object[] { "TEST", "N", 8, 9, "#" });
		subLinks.put(75, new Object[] { "TEST", "N", 9, 9, "#" });
		subLinks.put(76, new Object[] { "TEST", "N", 1, 10, "#" });
		subLinks.put(77, new Object[] { "TEST", "N", 2, 10, "#" });
		subLinks.put(78, new Object[] { "TEST", "N", 3, 10, "#" });
		subLinks.put(79, new Object[] { "TEST", "N", 4, 10, "#" });
		subLinks.put(80, new Object[] { "TEST", "N", 5, 10, "#" });
		subLinks.put(81, new Object[] { "TEST", "N", 6, 10, "#" });
		subLinks.put(82, new Object[] { "TEST", "N", 7, 10, "#" });
		subLinks.put(83, new Object[] { "TEST", "N", 8, 10, "#" });
		subLinks.put(84, new Object[] { "TEST", "N", 9, 10, "#" });
		for (Map.Entry<Integer, Object[]> page : subLinks.entrySet()) {

			Object[] pageData = page.getValue();
			ProjectPages pm = new ProjectPages();
			pm.setPageId(page.getKey());
			pm.setPageName(pageData[0].toString());
			pm.setPageEnabled(pageData[1].toString());
			pm.setPagePriority(Integer.valueOf(pageData[2].toString()));
			pm.setModuleId(Integer.valueOf(pageData[3].toString()));
			pm.setPageAction(pageData[4].toString());
			try {
				getLoginDao().merge(pm);
				getLoginDao().flush();
			} catch (Exception e) {

			}
		}

	}

	@Override
	public Response homeData(LoginRequest request) throws Exception {
		Response result = new Result();
		List<Object> resultHolder = new ArrayList<Object>();
		resultHolder.add(getProjectDetailsDao().getActiveLinks());
		result.setResultList(resultHolder);
		return result;
	}
}
