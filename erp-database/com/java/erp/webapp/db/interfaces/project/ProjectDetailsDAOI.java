package com.java.erp.webapp.db.interfaces.project;

import java.util.List;

import com.java.erp.webapp.db.interfaces.common.BaseDAOI;

public interface ProjectDetailsDAOI extends BaseDAOI {

	public List<Object[]> getActiveLinks() throws Exception;

}
