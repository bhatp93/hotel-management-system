package com.grokkingTheCodingInterview.hotelmanagementsystem.Model;

import java.util.Date;

public class RoomKey {
	String keyId;
	String barcode;
	Date issuedAt;
	boolean active;
	boolean isMaster;
	
	public boolean assignRoom() {
		return true;
	}
	
	
	public boolean isActive() {
		return true;
	}
}
