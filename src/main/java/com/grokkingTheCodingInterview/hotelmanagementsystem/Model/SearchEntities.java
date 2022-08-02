package com.grokkingTheCodingInterview.hotelmanagementsystem.Model;

import java.time.LocalDateTime;
import java.util.Date;

public class SearchEntities {
	RoomStyle roomStyle;
	LocalDateTime startDate;
	int duration;
	public RoomStyle getRoomStyle() {
		return roomStyle;
	}
	public void setRoomStyle(RoomStyle roomStyle) {
		this.roomStyle = roomStyle;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
}
