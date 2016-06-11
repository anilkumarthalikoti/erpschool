package com.java.erp.webapp.db.interfaces.setup;

import java.util.List;

import com.java.erp.webapp.database.setup.BatchDetails;
import com.java.erp.webapp.database.setup.BranchDetails;
import com.java.erp.webapp.db.interfaces.common.BaseDAOI;

public interface BatchDetailsDAOI extends BaseDAOI {
 public BatchDetails getBatchDetails(Object[] paramName ,Object[] paramVal) throws Exception;
 public List<Object[]> getAllBatchDetails() throws Exception;

}
