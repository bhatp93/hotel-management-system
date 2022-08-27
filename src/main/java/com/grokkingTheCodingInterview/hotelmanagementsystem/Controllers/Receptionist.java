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
import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.CashTransaction;
import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.CheckTransaction;
import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.CreditCardTransaction;
import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.Invoice;
import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.InvoiceItem;
import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.PaymentRequestInformation;
import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.PaymentStatus;
import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.PaymentType;
import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.Room;
import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.RoomBooking;
import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.RoomStyle;
import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.SearchEntities;
import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.UpdateBooking;
import com.grokkingTheCodingInterview.hotelmanagementsystem.dataAccessLayer.CashTransactionRepository;
import com.grokkingTheCodingInterview.hotelmanagementsystem.dataAccessLayer.CheckTransactionRepository;
import com.grokkingTheCodingInterview.hotelmanagementsystem.dataAccessLayer.CreditCardTransactionRepository;
import com.grokkingTheCodingInterview.hotelmanagementsystem.dataAccessLayer.HotelDAL;
import com.grokkingTheCodingInterview.hotelmanagementsystem.dataAccessLayer.InvoiceItemRepository;
import com.grokkingTheCodingInterview.hotelmanagementsystem.dataAccessLayer.InvoiceRepository;
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
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	@Autowired
	private CashTransactionRepository cashTransactionRepository;
	
	@Autowired
	private CreditCardTransactionRepository creditCardTransactionRepository;
	
	@Autowired
	private CheckTransactionRepository checkTransactionRepository;
	
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
		
		Invoice invoice = new Invoice();		
		invoice.setBookingId(bookedRoom.getBookingId());
		
		//Throw exception if needed
		invoiceRepository.save(invoice);
		
		Room room = roomRepository.findById(bookingRequest.getRoomId()).get();
		BookingResponse bookingResponse = new BookingResponse();
		//look to map classes 
		bookingResponse.setReservationNumber(bookedRoom.getReservationNumber());
		bookingResponse.setStartDate(bookedRoom.getStartDate());
		bookingResponse.setDurationInDays(bookedRoom.getDurationInDays());
		bookingResponse.setStatus(bookedRoom.getStatus());
		bookingResponse.setRoomId(bookedRoom.getRoomId());	
		bookingResponse.setRoomStyle(room.getStyle());
		return new ResponseEntity(bookingResponse, HttpStatus.CREATED);
	}
	
	@PostMapping("/makePayment")
	public HttpStatus makePayment(@RequestBody PaymentRequestInformation paymentRequestInformation) {
		Optional<RoomBooking> roomBookingDB = roomBookingRepository.findById(paymentRequestInformation.getBookingId());
		Optional<Room> roomDB = roomRepository.findById(roomBookingDB.get().getRoomId());
		Optional<Invoice> invoiceDB = invoiceRepository.findById(roomBookingDB.get().getInvoiceId());		
		invoiceDB.get().setAmount(roomDB.get().getBookingPrice());
		
		InvoiceItem invoiceItem = new InvoiceItem();
		invoiceItem.setItemDescription("Room Tariff");
		invoiceItem.setAmount(roomDB.get().getBookingPrice());
		invoiceItem.setInvoiceId(invoiceDB.get().getInvoiceId());		
		boolean paymentSuccess = false;
		//Make all transaction in one class - think
		if(paymentRequestInformation.getPaymentType()== PaymentType.Cash) {
			CashTransaction cashTransaction = new CashTransaction();
			cashTransaction.setTransactionId();
			cashTransaction.setInvoiceId(invoiceDB.get().getInvoiceId());
			cashTransaction.setCashTendered(paymentRequestInformation.getCashTendered());
			roomBookingDB.get().setStatus(BookingStatus.Confirmed);
			if(paymentRequestInformation.getCashTendered() < roomDB.get().getBookingPrice()) {
				invoiceItem.setPaymentStatus(PaymentStatus.Unpaid);
				paymentSuccess = true;
			}				
			else
				invoiceItem.setPaymentStatus(PaymentStatus.Completed);
			cashTransactionRepository.save(cashTransaction);			
		}
		else if(paymentRequestInformation.getPaymentType()== PaymentType.Check) {
			CheckTransaction checkTransaction = new CheckTransaction();
			checkTransaction.setBankName(paymentRequestInformation.getBankName());
			checkTransaction.setCheckNumber(paymentRequestInformation.getCheckNumber());
			checkTransaction.setInvoiceId(invoiceDB.get().getInvoiceId());
			if(checkTransaction.initiateTransaction()) {
				roomBookingDB.get().setStatus(BookingStatus.Confirmed);
				paymentSuccess = true;
			}
				
			else
				roomBookingDB.get().setStatus(BookingStatus.Canceled); // if cancelled completely. close invoice and booking 
			
			checkTransactionRepository.save(checkTransaction);
		}
		else if(paymentRequestInformation.getPaymentType()== PaymentType.CreditCard) {
			CreditCardTransaction creditCardTransaction = new CreditCardTransaction();
			creditCardTransaction.setInvoiceId(invoiceDB.get().getInvoiceId());
			creditCardTransaction.setNameOnCard(paymentRequestInformation.getNameOnCard());
			creditCardTransaction.setTransactionId();
			creditCardTransaction.setZipCode(paymentRequestInformation.getZipcode());
			if(creditCardTransaction.initiateTransaction()) {
				roomBookingDB.get().setStatus(BookingStatus.Confirmed);
				paymentSuccess = true;
			}				
			else
				roomBookingDB.get().setStatus(BookingStatus.Canceled);	// if cancelled completely. close invoice and booking 
			creditCardTransactionRepository.save(creditCardTransaction);
		}	
		roomBookingRepository.save(roomBookingDB.get());
		invoiceItemRepository.save(invoiceItem);
		if(paymentSuccess)
			return HttpStatus.OK;
		else
			return HttpStatus.BAD_GATEWAY;
	}
	
	@PostMapping("/updateBooking")
	public ResponseEntity<BookingResponse> updateBooking(@RequestBody UpdateBooking updateRequest) {
		BookingResponse bookingResponse = new BookingResponse();
		
		//Cannot be more than one in the list. Throw exception
		List<RoomBooking> roomBookingDB = roomBookingRepository.getBookingByReservationNumber(updateRequest.getReservationNumber());
		Room room = roomRepository.findById(roomBookingDB.get(0).getRoomId()).get();
		if(updateRequest.getStartDate().equals(roomBookingDB.get(0).getStartDate()) &&  updateRequest.getDurationInDays() == roomBookingDB.get(0).getDurationInDays()) {
			//map classes
			bookingResponse.setReservationNumber(roomBookingDB.get(0).getReservationNumber());
			bookingResponse.setStartDate(roomBookingDB.get(0).getStartDate());
			bookingResponse.setDurationInDays(roomBookingDB.get(0).getDurationInDays());
			bookingResponse.setStatus(roomBookingDB.get(0).getStatus());
			bookingResponse.setRoomId(roomBookingDB.get(0).getRoomId());
			bookingResponse.setRoomStyle(room.getStyle());
			bookingResponse.setMessage("No Change in the booking");
		}		
		else {
			List<Room> availableRooms = search(updateRequest.getRoomStyle(), updateRequest.getStartDate(), updateRequest.getDurationInDays());
			if(availableRooms == null) {
				//Add as a pending Request and ask if the user wants to be notified if it becomes available.
				bookingResponse.setMessage("Required room is not available.");
			}
			else {
				roomBookingDB.get(0).setRoomId(availableRooms.get(0).getId());
				roomBookingDB.get(0).setStartDate(updateRequest.getStartDate());
				roomBookingDB.get(0).setDurationInDays(updateRequest.getDurationInDays());
				roomBookingRepository.save(roomBookingDB.get(0));
				bookingResponse.setDurationInDays(updateRequest.getDurationInDays());
			}			
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
						if(endDate.isBefore(currentRoomBookingDate) || startDate.isAfter(currentRoomBookingDate.plusDays(currentDuration))) {
							if(roomBookings.get(j).getStatus() != BookingStatus.Confirmed || roomBookings.get(j).getStatus() != BookingStatus.Checked_in)
								roomsAvailable.add(rooms.get(i));														
		}}}}}
				
		return roomsAvailable;
	}
}
