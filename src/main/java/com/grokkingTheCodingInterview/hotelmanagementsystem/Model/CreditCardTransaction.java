package com.grokkingTheCodingInterview.hotelmanagementsystem.Model;

public class CreditCardTransaction extends BillTransaction {
	String nameOnCard;
	String zipCode;
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
	
	
}
