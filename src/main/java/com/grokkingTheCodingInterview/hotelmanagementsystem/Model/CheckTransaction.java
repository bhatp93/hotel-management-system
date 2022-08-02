package com.grokkingTheCodingInterview.hotelmanagementsystem.Model;

public class CheckTransaction extends BillTransaction{
	String bankName;
	String checkNumber;
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
	
	
}
