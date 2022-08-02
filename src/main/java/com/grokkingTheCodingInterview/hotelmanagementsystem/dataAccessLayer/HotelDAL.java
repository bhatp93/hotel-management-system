package com.grokkingTheCodingInterview.hotelmanagementsystem.dataAccessLayer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.AddressDAL;
import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.HotelLocation;
import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.Room;

@Component
public class HotelDAL {
	List<HotelLocation> hotelLocation = new ArrayList<HotelLocation>();
	
	public HotelDAL() {
		AddressDAL addressDal = new AddressDAL();
		HotelLocation hotelLocation1 = new HotelLocation("The Leela Palace New Delhi", addressDal.getAddressMap("New Delhi"));
		HotelLocation hotelLocation2 = new HotelLocation("The Leela Palace Udaipur", addressDal.getAddressMap("Udaipur"));
		HotelLocation hotelLocation3 = new HotelLocation("The Leela Palace Bengaluru", addressDal.getAddressMap("Bengaluru"));
		HotelLocation hotelLocation4 = new HotelLocation("The Leela Palace Chennai", addressDal.getAddressMap("Chennai"));
		
		hotelLocation.add(hotelLocation1);
		hotelLocation.add(hotelLocation2);
		hotelLocation.add(hotelLocation3);
		hotelLocation.add(hotelLocation4);
	}
	
	public int getHotelLocationId(String userName) {
		return 1;
	}
	
}
