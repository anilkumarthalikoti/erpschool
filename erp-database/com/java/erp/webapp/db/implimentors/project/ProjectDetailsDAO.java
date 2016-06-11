package com.java.erp.webapp.db.implimentors.project;

import java.util.List;

import com.java.erp.webapp.db.implimentors.common.BaseDAO;
import com.java.erp.webapp.db.interfaces.project.ProjectDetailsDAOI;

public class ProjectDetailsDAO extends BaseDAO implements ProjectDetailsDAOI {

	@Override
	public List<Object[]> getActiveLinks() throws Exception {
		List<Object[]> details = null;
		try {
			details = (List<Object[]>) getResultList("select pm.moduleId,pm.moduleName,pp.pageId,pp.pageName,pp.pageAction from ProjectModules pm, ProjectPages pp where pm.enabled='Y' and pm.moduleId = pp.moduleId and pp.pageEnabled='Y' order by pm.moduleId ,pp.pagePriority ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return details;
	}

}
