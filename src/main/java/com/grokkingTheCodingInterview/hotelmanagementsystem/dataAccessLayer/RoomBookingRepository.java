package com.grokkingTheCodingInterview.hotelmanagementsystem.dataAccessLayer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.RoomBooking;

@Component
public interface RoomBookingRepository extends JpaRepository<RoomBooking, Integer>{
	
	@Query("Select r from RoomBooking r from r.reservationNumber = :p")
	public List<RoomBooking> getBookingByReservationNumber(@Param("p") String reservationNumber);
		
	
}
