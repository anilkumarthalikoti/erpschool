package com.java.erp.webapp.db.implimentors.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.erp.webapp.database.user.Users;
import com.java.erp.webapp.db.implimentors.common.BaseDAO;
import com.java.erp.webapp.db.interfaces.user.LoginDAOI;
import com.java.erp.webapp.request.user.LoginRequest;

public class UserDAO extends BaseDAO implements LoginDAOI {

	@Override
	public List<Users> getUsers(LoginRequest loginRequest) throws Exception {
		// TODO Auto-generated method stub
		List<Users> users=new ArrayList<Users>();
		try{
			users=(List<Users>) getResultList("from Users");
		}catch(Exception e){
			
		}
		return users;
	}

	@Override
	public boolean checkForAdmin() throws Exception {
		Users u=null;
		try{
			u=(Users)getSingleResult("select u from Users u where u.isAdmin='Y'");
		}catch(Exception e){
			e.printStackTrace();
		}
		if(null==u){
			return true;
		}
		return false;
	}
	@Override
	public  Users   getUser (LoginRequest loginRequest) throws Exception {
		// TODO Auto-generated method stub
	 Users users=null;
		try{
			Map<Object,Object> params=new HashMap<Object,Object>();
			params.put("userLoginId",loginRequest.getLoginId());
			users=(Users) getSingleResult("from Users where userId=:userLoginId",params);
		}catch(Exception e){
			e.printStackTrace();
		}
		return users;
	}
}
