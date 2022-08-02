package com.grokkingTheCodingInterview.hotelmanagementsystem.dataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.RoomBooking;

@Component
public interface RoomBookingRepository extends JpaRepository<RoomBooking, Integer>{

}
