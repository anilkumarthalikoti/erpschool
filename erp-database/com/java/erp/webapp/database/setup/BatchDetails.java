package com.java.erp.webapp.database.setup;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.java.erp.webapp.database.project.BaseFields;
@Entity
@Table(name="erp_batchs")
public class BatchDetails extends BaseFields implements Serializable {
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="batchId",updatable=false,unique=true,nullable=false)
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
	 
	
	
	
	
	 
}
