package com.java.erp.webapp.database.finance;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.java.erp.webapp.database.project.BaseFields;
@Entity
@Table(name="fee_payments")
public class FeePayments extends BaseFields implements Serializable{
	@EmbeddedId
	FeePaymentsPk id=new FeePaymentsPk();
	@Column(name="paidDate")
	@Type(type="timestamp")
	private Date paidDate;
	@Column(name="paidAmount")
	private Double paidAmount;
	@Column(name="receivedBy")
	private Long receivedBy;
	@Column(name="receivedBranch")
	private Long receivedBranch;
	@Column(name="acYearId")
	private Long acyearId;
	@Column(name="batchId")
	private Long batchId;
	public FeePaymentsPk getId() {
		return id;
	}
	public void setId(FeePaymentsPk id) {
		this.id = id;
	}
	public Date getPaidDate() {
		return paidDate;
	}
	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}
	public Double getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}
	public Long getReceivedBy() {
		return receivedBy;
	}
	public void setReceivedBy(Long receivedBy) {
		this.receivedBy = receivedBy;
	}
	public Long getReceivedBranch() {
		return receivedBranch;
	}
	public void setReceivedBranch(Long receivedBranch) {
		this.receivedBranch = receivedBranch;
	}
	public Long getAcyearId() {
		return acyearId;
	}
	public void setAcyearId(Long acyearId) {
		this.acyearId = acyearId;
	}
	public Long getBatchId() {
		return batchId;
	}
	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}

	
}
