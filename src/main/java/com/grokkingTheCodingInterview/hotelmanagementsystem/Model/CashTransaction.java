package com.grokkingTheCodingInterview.hotelmanagementsystem.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CashTransaction extends BillTransaction{
	@Id
	int transactionId;
	int invoiceId; 
	double cashTendered;

	
	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId() {
		this.transactionId = BillTransaction.transactionId++;
	}

	public double getCashTendered() {
		return cashTendered;
	}

	public void setCashTendered(double cashTendered) {
		this.cashTendered = cashTendered;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

}
