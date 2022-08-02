package com.grokkingTheCodingInterview.hotelmanagementsystem.Model;

import java.util.List;

public class HotelLocation {
	String name;
	Address location; 
	List<Room> rooms;
	
	public HotelLocation() {}
	
	public HotelLocation(String name, Address location) {
		this.name = name;
		this.location = location;
	}
	
	public List<Room> getRooms() {
		return rooms;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLocation(Address location) {
		this.location = location;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	@Override
	public String toString() {
		return "HotelLocation [name=" + name + ", location=" + location + ", rooms=" + rooms + "]";
	}
	
	
}
