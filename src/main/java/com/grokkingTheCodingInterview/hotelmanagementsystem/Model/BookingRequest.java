package com.grokkingTheCodingInterview.hotelmanagementsystem.Model;

import java.time.LocalDateTime;

public class BookingRequest {
	int roomId;
	String reservationNumber;  
	LocalDateTime startDate;
	int durationInDays;
		
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public int getDurationInDays() {
		return durationInDays;
	}
	public void setDurationInDays(int durationInDays) {
		this.durationInDays = durationInDays;
	}
	public String getReservationNumber() {
		return reservationNumber;
	}
	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}	
	
	
}
