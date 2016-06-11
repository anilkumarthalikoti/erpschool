package com.java.erp.webapp.db.implimentors.dashboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.java.erp.webapp.database.setup.AcademicYears;
import com.java.erp.webapp.db.implimentors.common.BaseDAO;
import com.java.erp.webapp.db.interfaces.dashboard.DashBoardDAOI;

public class DashBoardDAO extends BaseDAO implements DashBoardDAOI {

	@Override
	public List getFeePaymentsBranch() throws Exception {
		 
		AcademicYears acyear =getActiveAcademicYear().get(0);
		Map params=new HashMap<Object, Object>();
		params.put("paidFrom", acyear.getAcceptFrom());
		params.put("paidTo", acyear.getAcceptTo());
		String query=" select bd.branchName, (select sum(fp.paidAmount) from FeePayments fp where  fp.receivedBranch= bd.branchId and fp.paidDate>=:paidFrom and fp.paidDate<=:paidTo )   from BranchDetails  bd      ";
		List<Object[]> data=(List<Object[]>)getResultList(query, params);
		Vector branchs=new Vector();
		Vector amounts=new Vector();
		if(null!=data && !data.isEmpty()){
		Iterator i=data.iterator();
		while(i.hasNext()){
			Object[] row=(Object[])i.next();
			branchs.add(row[0]);
			if(null==row[1]){
				amounts.add(0);
			}else{
				amounts.add(row[1]);
			}
		}
		}
		List result=new ArrayList();
		result.add(branchs);
		result.add(amounts);
		return result;
	}

	@Override
	public Object[] getStudentCountBranch() throws Exception {
		Object[] result = null;
		return result;
	}

	@Override
	public Object[] getAdmissionCountBranch() throws Exception {
		Object[] result = null;
		AcademicYears acyear =getActiveAcademicYear().get(0);
		return result;
	}

}
