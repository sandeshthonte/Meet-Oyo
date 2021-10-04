package com.example.oyoUser;

import java.sql.Date;
import java.util.List;


public interface RoomDAO{	
	List<Room> findAll();
	Room findById(Integer id);
	Room findByHotelName(String hotelName);
	List<Room> findByCity(String city, Date fromdate, Date todate);
	Room save(Room room);
	List<Room> saveAll(List<Room> rooms);
	String deleteById(Integer id);
}
