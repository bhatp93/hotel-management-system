package com.grokkingTheCodingInterview.hotelmanagementsystem.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CreditCardTransaction extends BillTransaction {
	@Id
	int transactionId;
	String nameOnCard;
	String zipCode;
	int invoiceId;
	
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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
