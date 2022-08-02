package com.grokkingTheCodingInterview.hotelmanagementsystem.Model;

public class CashTransaction extends BillTransaction{
	double cashTendered;

	public double getCashTendered() {
		return cashTendered;
	}

	public void setCashTendered(double cashTendered) {
		this.cashTendered = cashTendered;
	}
	
	
}
