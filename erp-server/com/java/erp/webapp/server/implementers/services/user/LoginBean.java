package com.java.erp.webapp.server.implementers.services.user;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.java.erp.webapp.database.project.ProjectModules;
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
		Response result=new Result();
	List<Object> resultHolder=new ArrayList<Object>();
	resultHolder.add(getLoginDao().checkForAdmin());
	result.setResultList(resultHolder);
		return result;
	}

	@Override
	public Response createAdmin(LoginRequest request) throws Exception {
		Response result=new Result();
		List<Object> resultHolder=new ArrayList<Object>();
		if(getLoginDao().checkForAdmin()){
		Users u=new Users();
		u.setIsAdmin("Y");
		u.setUserId(request.getLoginId());
		u.setPassword(request.getLoginPassword());
		u.setName("ADMINSTRATOR");
		getLoginDao().merge(u);
		getLoginDao().flush();
		updateModuels();
		}
		int start=2003;
		int next=2004;
		for(int i=0;i<30;i++){
			AcademicYears acyear=new AcademicYears();
			String nextAcyear=((next+i)+"").substring(2, 4);
			acyear.setAcademicYear((start+i)+"-"+nextAcyear);
			acyear.setIsActive("N");
			acyear.setApplicationPrefix("");
			acyear.setSeriesFrom("0001");
			acyear.setSeriesTo("0009");
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			Calendar calendar = new GregorianCalendar(start+i,2,31);
			Calendar calendar1 = new GregorianCalendar(next+i,2,31);
			Calendar c3=new GregorianCalendar();
			if(calendar1.after(c3) && calendar.before(c3)){
				acyear.setIsActive("Y");
			}
			acyear.setAcceptFrom( calendar.getTime());
			acyear.setAcceptTo(calendar1.getTime());

			getLoginDao().persist(acyear);
			getLoginDao().flush();
		}
		resultHolder.add(getLoginDao().checkForAdmin());
		result.setResultList(resultHolder);
			return result;
	}

	@Override
	public Response validateLogin(LoginRequest request) throws Exception {
		Response result=new Result();
		List<Object> resultHolder=new ArrayList<Object>();
		Users u=getLoginDao().getUser(request);
		if(null!=u && u.getPassword().equals(request.getLoginPassword())){
			resultHolder.add(u);
		}else{
			throw new ExceptionMessageHandler("Invalid Login/Password");
		}
		
		result.setResultList(resultHolder);
			return result;
	}
private void updateModuels(){
	Map<Integer,Object[]> modules=new HashMap<Integer,Object[]>();
	modules.put(1, new Object[]{1,"ADMISSION","admission.action","N",1,"admission.png"});
	modules.put(2, new Object[]{2,"FINANCE","finance.action","N",2,"finance.png"});
	modules.put(3, new Object[]{3,"STUDENT","academics.action","N",3,"student.png"});
	modules.put(4, new Object[]{4,"ACADEMICS","academics.action","N",4,"academics"});
	modules.put(5, new Object[]{5,"LIBRARY","academics.action","N",5,"library.png"});
	modules.put(6, new Object[]{6,"TRANSPORT","academics.action","N",6,"transport.png"});
	modules.put(7, new Object[]{7,"SETTINGS","administrative.action","Y",50,"settings.png"});
	
	for(Map.Entry<Integer, Object[]> module:modules.entrySet()){
		Object[] m=module.getValue();
		ProjectModules pm=new ProjectModules();
		pm.setModuleId(Integer.valueOf(m[0].toString()));
		pm.setModuleName(m[1].toString());
		pm.setActionName(m[2].toString());
		if("Y".equals(m[3].toString())){
			pm.setEnabled('Y');
		}else{
			pm.setEnabled('N');
		}
		pm.setPriority(Integer.valueOf(m[4].toString()));
		pm.setImageUrl(m[5].toString());
		try{
		getLoginDao().persist(pm);
		getLoginDao().flush();
		}catch(Exception e){
			
		}
	}






}
}
