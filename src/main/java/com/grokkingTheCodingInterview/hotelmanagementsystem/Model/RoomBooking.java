package com.grokkingTheCodingInterview.hotelmanagementsystem.Model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RoomBooking {	
	@Id
	@GeneratedValue	
	int bookingId; //Try not to send this back
	String reservationNumber;
	LocalDateTime startDate;
	int durationInDays;
	
	BookingStatus status;
	LocalDateTime checkin;
	LocalDateTime checkout;
	int invoiceId;
	
	//Try not to send this back
	int roomId;
	
	static int reservationint = 1000;
	
	
	//use this 
	public RoomBooking fetchDetails() {
		return this;
	}

	
	
	public int getInvoiceId() {
		return invoiceId;
	}



	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}



	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}



	public String getReservationNumber() {
		return reservationNumber;
	}

	//check how booking string is created
	public void setReservationNumber() {
		reservationNumber = "book" + String.valueOf(++reservationint);		
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

	public LocalDateTime getCheckin() {
		return checkin;
	}

	public void setCheckin(LocalDateTime checkin) {
		this.checkin = checkin;
	}

	public LocalDateTime getCheckout() {
		return checkout;
	}

	public void setCheckout(LocalDateTime checkout) {
		this.checkout = checkout;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	
	
}
