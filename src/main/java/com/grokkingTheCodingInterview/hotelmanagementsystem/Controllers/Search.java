package com.grokkingTheCodingInterview.hotelmanagementsystem.Controllers;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.Room;
import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.RoomStyle;

public interface Search {
	
	public List<Room> search(RoomStyle roomStyle, LocalDateTime startDate, int duration);
}
