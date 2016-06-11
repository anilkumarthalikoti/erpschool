package com.java.erp.webapp.server.interfaces.services.finance;

import com.java.erp.webapp.request.finance.FeeStructureRequest;
import com.java.erp.webapp.server.interfaces.services.common.Response;

public interface FeeStructureBeanI {
public Response getFeeStrucutre(FeeStructureRequest request) throws Exception;
public Response saveFeeStrucutre(FeeStructureRequest request) throws Exception;
}
