package com.java.erp.webapp.database.feepayments;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="fin_feestructure")
public class FeeStructure {
@EmbeddedId
FeeStructurePk id=new FeeStructurePk();
@Column
private Double apr;
@Column
private Double may;
@Column
private Double jun;
@Column
private Double jul;
@Column
private Double aug;
@Column
private Double sep;
@Column
private Double oct;
@Column
private Double nov;
@Column
private Double dec;
@Column
private Double jan;
@Column
private Double feb;
@Column
private Double mar;
public FeeStructurePk getId() {
	return id;
}
public void setId(FeeStructurePk id) {
	this.id = id;
}
public Double getApr() {
	return apr;
}
public void setApr(Double apr) {
	this.apr = apr;
}
public Double getMay() {
	return may;
}
public void setMay(Double may) {
	this.may = may;
}
public Double getJun() {
	return jun;
}
public void setJun(Double jun) {
	this.jun = jun;
}
public Double getJul() {
	return jul;
}
public void setJul(Double jul) {
	this.jul = jul;
}
public Double getAug() {
	return aug;
}
public void setAug(Double aug) {
	this.aug = aug;
}
public Double getSep() {
	return sep;
}
public void setSep(Double sep) {
	this.sep = sep;
}
public Double getOct() {
	return oct;
}
public void setOct(Double oct) {
	this.oct = oct;
}
public Double getNov() {
	return nov;
}
public void setNov(Double nov) {
	this.nov = nov;
}
public Double getDec() {
	return dec;
}
public void setDec(Double dec) {
	this.dec = dec;
}
public Double getJan() {
	return jan;
}
public void setJan(Double jan) {
	this.jan = jan;
}
public Double getFeb() {
	return feb;
}
public void setFeb(Double feb) {
	this.feb = feb;
}
public Double getMar() {
	return mar;
}
public void setMar(Double mar) {
	this.mar = mar;
}

}
