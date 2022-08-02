package com.grokkingTheCodingInterview.hotelmanagementsystem.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class InvoiceItem {
	
	@Id
	@GeneratedValue
	int invoiceItemId;
	String itemDescription;
	double amount;
	int bookingId;
	PaymentStatus paymentStatus;
	
	public boolean updateAmount() {
		return true;
	}

	public int getInvoiceItemId() {
		return invoiceItemId;
	}

	public void setInvoiceItemId(int invoiceItemId) {
		this.invoiceItemId = invoiceItemId;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	
	
	
}
