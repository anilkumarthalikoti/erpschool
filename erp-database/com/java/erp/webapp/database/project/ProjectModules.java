package com.java.erp.webapp.database.project;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "erp_modules")
public class ProjectModules extends BaseFields implements Serializable {
	@Id
	@Column(name = "module_id")
	private Integer moduleId;
	@Column(name = "module_name", unique = true, nullable = false)
	private String moduleName;
	@Column(name = "enabled")
	private char enabled;

	@Column(name = "priority", unique = true)
	private Integer priority;

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public char getEnabled() {
		return enabled;
	}

	public void setEnabled(char enabled) {
		this.enabled = enabled;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

}
