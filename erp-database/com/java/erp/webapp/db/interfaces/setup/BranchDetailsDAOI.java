package com.java.erp.webapp.db.interfaces.setup;

import java.util.List;

import com.java.erp.webapp.database.setup.BranchDetails;
import com.java.erp.webapp.db.interfaces.common.BaseDAOI;

public interface BranchDetailsDAOI extends BaseDAOI {
 public BranchDetails getBranchDetails(Object[] paramName ,Object[] paramVal) throws Exception;
 public List<BranchDetails> getAllBranchDetails() throws Exception;

}
