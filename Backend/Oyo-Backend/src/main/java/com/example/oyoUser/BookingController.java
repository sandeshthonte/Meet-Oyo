package com.example.oyoUser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/selections/")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	public BookingController(BookingService bookingService) {
		this.bookingService = bookingService;
	}
	
	@GetMapping("/bookings")
	public List<Booking> getBookings() {
		 return bookingService.getBookings();
	 }
	 
	@GetMapping("/booking/{id}")
	public Booking getBooking(@PathVariable Integer id) {
		 return bookingService.getBookingById(id);
	 }
	
	@GetMapping("/bookingApp/{approval}")
	public List<Booking> getBookingByApp(@PathVariable String approval) {
		 return bookingService.getBookingByApp(approval);
	 }

	@PostMapping("/addBooking")
	public Booking saveBooking(@RequestBody Booking booking) {
		 return bookingService.saveBooking(booking);
	 }
	
	@PostMapping("/addBookings")
	public List<Booking> saveBooking(@RequestBody List<Booking> bookings) {
		 return bookingService.saveBookings(bookings);
	 }
	
	@DeleteMapping("/deleteBooking/{id}")
	public String deleteBooking(@PathVariable Integer id) {
		 return bookingService.deleteBooking(id);
	 }
	 
	@PutMapping("/updateBooking/{bid}/{approval}")
	public String updateBooking(@PathVariable Integer bid, @PathVariable String approval) {
		 return bookingService.updateBooking(bid, approval);
	 }
}
