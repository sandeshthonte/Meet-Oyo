package com.example.oyoUser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
	
	@Autowired
	private BookingDAO bookingDAO;
	
	@Autowired
	public BookingService(BookingDAO bookingDAO) {
		this.bookingDAO = bookingDAO;
	}
	 
	public List<Booking> getBookings(){
		return bookingDAO.findAll();
	}
	
	public Booking getBookingById(Integer id) {
		return bookingDAO.findById(id);
	}
	
	public List<Booking> getBookingByApp(String approval) {
		return bookingDAO.findByApp(approval);
	}
	
	public Booking saveBooking(Booking booking) {
		Booking currentBooking = bookingDAO.saveAll(List.of(booking)).get(0);
		return currentBooking;
	}
	
	public List<Booking> saveBookings(List<Booking> bookings) {
		return bookingDAO.saveAll(bookings);
	}
	
	public String deleteBooking(Integer id) {
		return bookingDAO.deleteById(id);
	}
	 
	public String updateBooking(Integer bid, String approval) {
		return bookingDAO.updateById(bid, approval);
	}
	
}
