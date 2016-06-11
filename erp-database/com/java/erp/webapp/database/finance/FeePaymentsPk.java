package com.java.erp.webapp.database.finance;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class FeePaymentsPk implements Serializable {
@Column(name="receipt_no")
private String receiptNo;
@Column(name="ref_no")
private Long studentId;

public String getReceiptNo() {
	return receiptNo;
}
public void setReceiptNo(String receiptNo) {
	this.receiptNo = receiptNo;
}
public Long getStudentId() {
	return studentId;
}
public void setStudentId(Long studentId) {
	this.studentId = studentId;
}

}
