package com.java.erp.webapp.database.finance;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.java.erp.webapp.database.project.BaseFields;

@Entity
@Table(name="fin_feestructure")
public class FeeStructure extends BaseFields implements Serializable {
@EmbeddedId
FeeStructurePk id=new FeeStructurePk();
@Column
private Float apr;
@Column
private Float may;
@Column
private Float jun;
@Column
private Float jul;
@Column
private Float aug;
@Column
private Float sep;
@Column
private Float oct;
@Column
private Float nov;
@Column
private Float december;
@Column
private Float jan;
@Column
private Float feb;
@Column
private Float mar;
@Column
private Float admissionFee;
@Column
private Float refundAmount;
public FeeStructurePk getId() {
	return id;
}
public void setId(FeeStructurePk id) {
	this.id = id;
}
public Float getApr() {
	return apr;
}
public void setApr(Float apr) {
	this.apr = apr;
}
public Float getMay() {
	return may;
}
public void setMay(Float may) {
	this.may = may;
}
public Float getJun() {
	return jun;
}
public void setJun(Float jun) {
	this.jun = jun;
}
public Float getJul() {
	return jul;
}
public void setJul(Float jul) {
	this.jul = jul;
}
public Float getAug() {
	return aug;
}
public void setAug(Float aug) {
	this.aug = aug;
}
public Float getSep() {
	return sep;
}
public void setSep(Float sep) {
	this.sep = sep;
}
public Float getOct() {
	return oct;
}
public void setOct(Float oct) {
	this.oct = oct;
}
public Float getNov() {
	return nov;
}
public void setNov(Float nov) {
	this.nov = nov;
}
 
public Float getJan() {
	return jan;
}
public void setJan(Float jan) {
	this.jan = jan;
}
public Float getFeb() {
	return feb;
}
public void setFeb(Float feb) {
	this.feb = feb;
}
public Float getMar() {
	return mar;
}
public void setMar(Float mar) {
	this.mar = mar;
}
public Float getDecember() {
	return december;
}
public void setDecember(Float december) {
	this.december = december;
}
public Float getAdmissionFee() {
	return admissionFee;
}
public void setAdmissionFee(Float admissionFee) {
	this.admissionFee = admissionFee;
}
public Float getRefundAmount() {
	return refundAmount;
}
public void setRefundAmount(Float refundAmount) {
	this.refundAmount = refundAmount;
}

}
