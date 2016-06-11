package com.java.erp.webapp.database.dashboard;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="announcement_roles")
public class AnnouncementDtl implements Serializable {
@Id
@GeneratedValue
private Long id;
@Column(name="roleId")
private Long roleId;
@ManyToOne
AnnouncementMaster master=new AnnouncementMaster();
public Long getRoleId() {
	return roleId;
}
public void setRoleId(Long roleId) {
	this.roleId = roleId;
}
public Long getId() {
	return id;
}
public AnnouncementMaster getMaster() {
	return master;
}
public void setMaster(AnnouncementMaster master) {
	this.master = master;
}

}
