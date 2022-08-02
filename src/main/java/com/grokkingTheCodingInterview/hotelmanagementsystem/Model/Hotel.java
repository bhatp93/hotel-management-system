package com.grokkingTheCodingInterview.hotelmanagementsystem.Model;

import java.util.List;



public class Hotel {
	  private String name;
	  private List<HotelLocation> locations;

	  public boolean addLocation(HotelLocation location) {
		  return locations.add(location);
	  }	  

	public List<HotelLocation> getLocations() {
		return locations;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

	@Override
	public String toString() {
		return "Hotel [name=" + name + ", locations=" + locations + "]";
	}
	  
	  
}
