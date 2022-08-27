package com.grokkingTheCodingInterview.hotelmanagementsystem.Model;

import java.time.LocalDateTime;

public class UpdateBooking {
	String reservationNumber;  
	LocalDateTime startDate;
	RoomStyle roomStyle;
	int durationInDays;


	public String getReservationNumber() {
		return reservationNumber;
	}
	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
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
	public RoomStyle getRoomStyle() {
		return roomStyle;
	}
	public void setRoomStyle(RoomStyle roomStyle) {
		this.roomStyle = roomStyle;
	}
	
	
}
