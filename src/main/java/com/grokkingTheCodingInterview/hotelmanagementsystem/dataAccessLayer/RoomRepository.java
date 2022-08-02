package com.grokkingTheCodingInterview.hotelmanagementsystem.dataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.Room;

@Component
public interface RoomRepository extends JpaRepository<Room, Integer>{

}
