package com.java.erp.webapp.database.admission;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="adm_settings")
public class AdmissionSettings implements Serializable {
@EmbeddedId
private AdmissionSettingsPk id=new AdmissionSettingsPk();
@Column(name="adm_mode")
private String admissionMode;
public AdmissionSettingsPk getId() {
	return id;
}
public void setId(AdmissionSettingsPk id) {
	this.id = id;
}
public String getAdmissionMode() {
	return admissionMode;
}
public void setAdmissionMode(String admissionMode) {
	this.admissionMode = admissionMode;
}





}
