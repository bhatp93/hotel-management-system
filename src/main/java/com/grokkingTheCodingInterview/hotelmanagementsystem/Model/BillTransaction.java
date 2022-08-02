package com.grokkingTheCodingInterview.hotelmanagementsystem.Model;

import java.util.Date;

public class BillTransaction {
	Date creationDate;
	double amount;
	PaymentStatus status;
	
	public boolean initiateTransaction() {
		return true;
	}
}
