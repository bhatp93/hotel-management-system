package com.grokkingTheCodingInterview.hotelmanagementsystem.Controllers;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.BookingRequest;
import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.BookingResponse;
import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.BookingStatus;
import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.InvoiceItem;
import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.PaymentRequestInformation;
import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.PaymentStatus;
import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.PaymentType;
import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.Room;
import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.RoomBooking;
import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.RoomStyle;
import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.SearchEntities;
import com.grokkingTheCodingInterview.hotelmanagementsystem.dataAccessLayer.HotelDAL;
import com.grokkingTheCodingInterview.hotelmanagementsystem.dataAccessLayer.InvoiceItemRepository;
import com.grokkingTheCodingInterview.hotelmanagementsystem.dataAccessLayer.RoomBookingRepository;
import com.grokkingTheCodingInterview.hotelmanagementsystem.dataAccessLayer.RoomRepository;

@RestController
public class Receptionist implements Search{
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private HotelDAL hotelDAL;
	
	@Autowired
	private RoomBookingRepository roomBookingRepository;
	
	@Autowired
	private InvoiceItemRepository invoiceItemRepository;
	
	@PostMapping("/addRoom/{userName}")
	public ResponseEntity<Room> addRoom(@RequestBody Room room, @PathVariable String userName) {
		int locationId = hotelDAL.getHotelLocationId(userName);
		room.setLocationId(locationId);
		Room createdRoom =  roomRepository.save(room);				
		return new ResponseEntity(createdRoom, HttpStatus.CREATED);		
	}
	
	@PutMapping("/updateRoom/{userName}")
	public ResponseEntity<Room> updateRoom(@RequestBody Room room, @PathVariable String userName){
		int locationId = hotelDAL.getHotelLocationId(userName);
		room.setLocationId(locationId);
		Room createdRoom =  roomRepository.save(room);				
		return new ResponseEntity(createdRoom, HttpStatus.OK);	
	}

	@PostMapping("/searchRoom")
	public ResponseEntity<List<Room>> searchRoom(SearchEntities searchEntities){
		List<Room> availableRooms = search(searchEntities.getRoomStyle(), searchEntities.getStartDate(), searchEntities.getDuration());
		return new ResponseEntity(availableRooms, HttpStatus.OK);
	}
	
	
	@PostMapping("/bookRoom")
	public ResponseEntity<BookingResponse> bookRoom(@RequestBody BookingRequest bookingRequest){
		RoomBooking roomBooking = new RoomBooking();
		//look to map classes
		roomBooking.setRoomId(bookingRequest.getRoomId());
		roomBooking.setStartDate(bookingRequest.getStartDate());
		roomBooking.setDurationInDays(bookingRequest.getDurationInDays());
		roomBooking.setReservationNumber();				
		roomBooking.setStatus(BookingStatus.Requested);
		 
		RoomBooking bookedRoom = roomBookingRepository.save(roomBooking);
		
		BookingResponse bookingResponse = new BookingResponse();
		//look to map classes 
		bookingResponse.setReservationNumber(bookingResponse.getReservationNumber());
		bookingResponse.setStartDate(bookedRoom.getStartDate());
		bookingResponse.setDurationInDays(bookedRoom.getDurationInDays());
		bookingResponse.setStatus(bookedRoom.getStatus());
		bookingResponse.setRoomId(bookedRoom.getRoomId());				
		return new ResponseEntity(bookingResponse, HttpStatus.CREATED);
	}
	
	public void makePayment(@RequestBody PaymentRequestInformation paymentRequestInformation) {
		Optional<RoomBooking> roomBookingDB = roomBookingRepository.findById(paymentRequestInformation.getBookingId());
		Optional<Room> roomDB = roomRepository.findById(roomBookingDB.get().getRoomId());
		InvoiceItem invoiceItem = new InvoiceItem();
		invoiceItem.setItemDescription("Room Tariff");
		invoiceItem.setAmount(roomDB.get().getBookingPrice());
		invoiceItem.setBookingId(roomBookingDB.get().getBookingId());
		if(paymentRequestInformation.getPaymentType()== PaymentType.Cash) {
			
			receptionist booking you idiot, it is on the spot
			roomBookingDB.get().setStatus(BookingStatus.Pending);
			invoiceItem.setPaymentStatus(PaymentStatus.Pending);			
		}
		else if(paymentRequestInformation.getPaymentType()== PaymentType.Check) {
			tadiyana taderaneddddl;kkldfsllnksdfbljk
		}
			
	}
	
	@Override
	public List<Room> search(RoomStyle roomStyle, LocalDateTime startDate, int duration) {
		LocalDateTime endDate = startDate.plusDays(duration);
		List<RoomBooking> roomBookings = roomBookingRepository.findAll();
		List<Room> rooms = roomRepository.findAll();
		List<Room> roomsAvailable = null;
		for(int i=0; i<rooms.size();i++) {
			if(rooms.get(i).getStyle() == roomStyle) {
				for(int j=0; j<roomBookings.size();j++) {
					if(roomBookings.get(j).getRoomId() == rooms.get(i).getId()) {
						LocalDateTime currentRoomBookingDate = roomBookings.get(j).getStartDate();
						int currentDuration = roomBookings.get(j).getDurationInDays();
						
						//send bookedRooms with pending status
						if(startDate.isBefore(currentRoomBookingDate) || startDate.isAfter(currentRoomBookingDate.plusDays(currentDuration))) {
							roomsAvailable.add(rooms.get(i));							
		}}}}}
		return roomsAvailable;
	}
}
