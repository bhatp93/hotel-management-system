package com.grokkingTheCodingInterview.hotelmanagementsystem.Model;

public class PaymentRequestInformation {
	PaymentType paymentType;
	String nameOnCard;
	String zipcode;
	String bankName;
	String checkNumber;
	double cashTendered;
	int bookingId; 
	public PaymentType getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
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
	public double getCashTendered() {
		return cashTendered;
	}
	public void setCashTendered(double cashTendered) {
		this.cashTendered = cashTendered;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	
	
}
