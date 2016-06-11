package com.java.erp.webapp.db.interfaces.finance;

import java.util.List;

import com.java.erp.webapp.database.finance.FeeStructure;
import com.java.erp.webapp.db.interfaces.common.BaseDAOI;

public interface FeeStructureDAOI extends BaseDAOI {
 public FeeStructure getFeeStructure(Long batchId,Long acyearId) throws Exception; 
}
