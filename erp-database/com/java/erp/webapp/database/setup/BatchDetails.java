package com.java.erp.webapp.database.setup;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.java.erp.webapp.database.project.BaseFields;
@Entity
@Table(name="gen_batchs")
public class BatchDetails extends BaseFields implements Serializable {
	private static final long serialVersionUID = 1L;
	 
@Column(name="batchId",updatable=false,unique=true)
	private Long batchId;
	@Column(name="isActive",length=1)
	private String isActive;
	@EmbeddedId
	BatchDetailsPk batchDetailsPk=new BatchDetailsPk();
	 
 
	public BatchDetailsPk getBatchDetailsPk() {
		return batchDetailsPk;
	}
	public void setBatchDetailsPk(BatchDetailsPk batchDetailsPk) {
		this.batchDetailsPk = batchDetailsPk;
	}
	public Long getBatchId() {
		return batchId;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}
	 
	
	
	
	
	 
}
