package com.java.erp.webapp.database.project;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="pageId")
public class ProjectPages extends BaseFields implements Serializable {
@Id
@Column(name="page_id")
private int pageId;
@Column(name="pageName",nullable=false)
private String pageName;
@Column(name="page_action")
String pageAction;
@Column(name="page_enabled")
String pageEnabled;
@Column(name="page_priority")
private Integer pagePriority;
@Column(name="module_id")
private Integer moduleId;
@Column(name="head_under")
private Byte subHeader;
public int getPageId() {
	return pageId;
}
public void setPageId(int pageId) {
	this.pageId = pageId;
}
public String getPageName() {
	return pageName;
}
public void setPageName(String pageName) {
	this.pageName = pageName;
}
public String getPageAction() {
	return pageAction;
}
public void setPageAction(String pageAction) {
	this.pageAction = pageAction;
}
public String getPageEnabled() {
	return pageEnabled;
}
public void setPageEnabled(String pageEnabled) {
	this.pageEnabled = pageEnabled;
}
public Integer getPagePriority() {
	return pagePriority;
}
public void setPagePriority(Integer pagePriority) {
	this.pagePriority = pagePriority;
}
public Integer getModuleId() {
	return moduleId;
}
public void setModuleId(Integer moduleId) {
	this.moduleId = moduleId;
}
public Byte getSubHeader() {
	return subHeader;
}
public void setSubHeader(Byte subHeader) {
	this.subHeader = subHeader;
}


}
