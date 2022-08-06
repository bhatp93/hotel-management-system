package com.grokkingTheCodingInterview.hotelmanagementsystem.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Room {
	@Id
	@GeneratedValue
	//hidden value
	int id;
	String roomNumber;
	RoomStyle style;
	RoomStatus status;
	double bookingPrice;
	boolean isSmoking;
	int locationId;
	
	public boolean isRoomAvailable() {
		return status.equals(RoomStatus.Available);
	}
	
	public boolean checkIn() {
		return status.equals(RoomStatus.Occupied);
	}
	
	public boolean checkOut() {
		return status.equals(RoomStatus.BeingServiced);			
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public RoomStyle getStyle() {
		return style;
	}

	public void setStyle(RoomStyle style) {
		this.style = style;
	}

	public RoomStatus getStatus() {
		return status;
	}

	public void setStatus(RoomStatus status) {
		this.status = status;
	}

	public double getBookingPrice() {
		return bookingPrice;
	}

	public void setBookingPrice(double bookingPrice) {
		this.bookingPrice = bookingPrice;
	}

	public boolean isSmoking() {
		return isSmoking;
	}

	public void setSmoking(boolean isSmoking) {
		this.isSmoking = isSmoking;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	@Override
	public String toString() {
		return "Room [roomNumber=" + roomNumber + ", style=" + style + ", status=" + status + ", bookingPrice="
				+ bookingPrice + ", isSmoking=" + isSmoking + "]";
	}
	
	
}
