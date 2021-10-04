package com.example.oyoUser;

import java.util.List;

public interface BookingDAO{
	List<Booking> findAll();
	Booking findById(Integer id);
	List<Booking> findByApp(String approval);
	Booking save(Booking booking);
	List<Booking> saveAll(List<Booking> bookings);
	String deleteById(Integer id);
	String updateById(Integer id, String approval);
}
