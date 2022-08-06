package com.grokkingTheCodingInterview.hotelmanagementsystem.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CheckTransaction extends BillTransaction{
	@Id
	int transactionId;
	String bankName;
	String checkNumber;
	int invoiceId; 

	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getCheckNumber() {
		return checkNumber;
	}
	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId() {
		this.transactionId = BillTransaction.transactionId++;
	}
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	//complete this
	@Override
	public boolean initiateTransaction() {
		return true;
	}
	
}
