package com.java.erp.webapp.request.finance;

import com.java.erp.webapp.request.common.BaseRequest;

public class FeeStructureRequest extends BaseRequest {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 private Long[] batchs;
	 private Long[] financialYears;
	 private float apr,may,jun,jul,aug,sep,oct,nov,dec,jan,feb,mar,admissionFee,refundAmount;
	 
	public Long[] getBatchs() {
		return batchs;
	}
	public void setBatchs(Long[] batchs) {
		this.batchs = batchs;
	}
	public Long[] getFinancialYears() {
		return financialYears;
	}
	public void setFinancialYears(Long[] financialYears) {
		this.financialYears = financialYears;
	}
	public float getApr() {
		return apr;
	}
	public void setApr(float apr) {
		this.apr = apr;
	}
	public float getMay() {
		return may;
	}
	public void setMay(float may) {
		this.may = may;
	}
	public float getJun() {
		return jun;
	}
	public void setJun(float jun) {
		this.jun = jun;
	}
	public float getJul() {
		return jul;
	}
	public void setJul(float jul) {
		this.jul = jul;
	}
	public float getAug() {
		return aug;
	}
	public void setAug(float aug) {
		this.aug = aug;
	}
	public float getSep() {
		return sep;
	}
	public void setSep(float sep) {
		this.sep = sep;
	}
	public float getOct() {
		return oct;
	}
	public void setOct(float oct) {
		this.oct = oct;
	}
	public float getNov() {
		return nov;
	}
	public void setNov(float nov) {
		this.nov = nov;
	}
	public float getDec() {
		return dec;
	}
	public void setDec(float dec) {
		this.dec = dec;
	}
	public float getJan() {
		return jan;
	}
	public void setJan(float jan) {
		this.jan = jan;
	}
	public float getFeb() {
		return feb;
	}
	public void setFeb(float feb) {
		this.feb = feb;
	}
	public float getMar() {
		return mar;
	}
	public void setMar(float mar) {
		this.mar = mar;
	}
	public float getAdmissionFee() {
		return admissionFee;
	}
	public void setAdmissionFee(float admissionFee) {
		this.admissionFee = admissionFee;
	}
	public float getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(float refundAmount) {
		this.refundAmount = refundAmount;
	}

}
