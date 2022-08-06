package com.grokkingTheCodingInterview.hotelmanagementsystem.Model;

import java.util.Date;

public class BillTransaction {
	Date creationDate;
	double amount;
	PaymentStatus status;
	static int transactionId = 0;
	public boolean initiateTransaction() {
		return true;
	}
}
