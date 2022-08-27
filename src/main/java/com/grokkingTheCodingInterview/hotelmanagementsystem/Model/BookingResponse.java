package com.grokkingTheCodingInterview.hotelmanagementsystem.Model;

import java.time.LocalDateTime;

public class BookingResponse {
	String reservationNumber;
	LocalDateTime startDate;
	int durationInDays;
	RoomStyle roomStyle;
	BookingStatus status;
	int roomId;
	String message;

	
	
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
	public BookingStatus getStatus() {
		return status;
	}
	public void setStatus(BookingStatus status) {
		this.status = status;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public RoomStyle getRoomStyle() {
		return roomStyle;
	}
	public void setRoomStyle(RoomStyle roomStyle) {
		this.roomStyle = roomStyle;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
