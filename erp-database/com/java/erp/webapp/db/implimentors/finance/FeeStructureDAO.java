package com.java.erp.webapp.db.implimentors.finance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.java.erp.webapp.database.finance.FeeStructure;
import com.java.erp.webapp.database.setup.AcademicYears;
import com.java.erp.webapp.db.implimentors.common.BaseDAO;
import com.java.erp.webapp.db.interfaces.finance.FeeStructureDAOI;

public class FeeStructureDAO extends BaseDAO implements FeeStructureDAOI {

	@Override
	public FeeStructure getFeeStructure(Long batchId, Long acyearId)
			throws Exception {
		FeeStructure feeStructure=null;
		Map params=new HashMap();
		params.put("mappingId", batchId);
		params.put("acYearId", acyearId);
		String query="select u from FeeStructure u where u.id.mappingId=:mappingId and u.id.acYearId=:acYearId";
		feeStructure=(FeeStructure) getSingleResult(query, params);
		return feeStructure;
	}

	 
}
