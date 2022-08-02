package com.grokkingTheCodingInterview.hotelmanagementsystem.Model;

import java.util.Date;

public class RoomService extends RoomCharge{
	boolean isChargable;
	Date requestTime;
	
	public boolean isChargable() {
		return isChargable;
	}
	public void setChargable(boolean isChargable) {
		this.isChargable = isChargable;
	}
	public Date getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}
	
	
}
