package com.example.oyoUser;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hotels")
public class RoomController {
	
	
	 @Autowired private RoomService roomService = null;
	 
	 @Autowired public RoomController(RoomService roomService) { 
		 this.roomService = roomService; 
	} 
	
	@GetMapping("/rooms")
	public List<Room> getRooms() {
		 return roomService.getRooms();
	 }
	
	@GetMapping("/room/{id}")
	public Room getRoomById(@PathVariable Integer id) {
		 return roomService.getRoomById(id);
	 }
	
	@GetMapping("/roomName/{hotelName}")
	public Room getRoomByHotelName(@PathVariable String hotelName) {
		 return roomService.getRoomByHotelName(hotelName);
	 }
	
	@GetMapping("/roomCity/{city}/{fromdate}/{todate}")
	public List<Room> getRoomByCity(@PathVariable String city, @PathVariable Date fromdate, @PathVariable Date todate) {
		 return roomService.getRoomByCity(city, fromdate, todate);
	 }
	
	@PostMapping("/addRoom")
	public Room saveRoom(@RequestBody Room room) {
		System.out.println(room.getEndDate()+" "+room.getPricing());
		 return roomService.saveRoom(room);
	 }
	
	@PostMapping("/addRooms")
	public List<Room> saveRoom(@RequestBody List<Room> rooms) {
		 return roomService.saveRooms(rooms);
	 }
	
	@DeleteMapping("/deleteRoom/{id}")
	public String deleteRoom(@PathVariable Integer id) {
		 return roomService.deleteRoom(id);
	 }
	 
	@PutMapping("/updateRoom")
	public Room updateRoom(Room room) {
		 return roomService.updateRoom(room);
	 }
}
