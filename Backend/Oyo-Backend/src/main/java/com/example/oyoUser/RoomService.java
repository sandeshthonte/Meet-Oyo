package com.example.oyoUser;

import java.sql.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@Transactional
public class RoomService {
	@Autowired
	private RoomDAOImpl roomDAOImpl = null;
	
	@Autowired
	public RoomService(RoomDAOImpl roomDAOImpl) {
		this.roomDAOImpl = roomDAOImpl;
	}
	
	public List<Room> getRooms(){
		return roomDAOImpl.findAll();
	}
	
	public Room getRoomById(Integer id) {
		return roomDAOImpl.findById(id);
	}
	
	public Room getRoomByHotelName(String hotelName) {
		return roomDAOImpl.findByHotelName(hotelName);
	}
	
	public List<Room> getRoomByCity(String city, Date fromdate, Date todate) {
		return roomDAOImpl.findByCity(city, fromdate, todate);
	}
	
	public Room saveRoom(@RequestBody Room room) {
		System.out.println(room.getHotelName()+" "+room.getPricing());
		return roomDAOImpl.save(room);
	}
	
	public List<Room> saveRooms(List<Room> rooms) {
		return roomDAOImpl.saveAll(rooms);
	}
	
	public String deleteRoom(Integer id) {
		return roomDAOImpl.deleteById(id);
	}
	 
	public Room updateRoom(Room room) {
//		Room currentRoom = roomDAOImpl.findById(room.getRid());
//		currentRoom.setHotelName(room.getHotelName());
//		currentRoom.setRid(room.getRid());
//		currentRoom.setAddress(room.getAddress());
//		currentRoom.setCity(room.getCity());
//		currentRoom.setEnlistedDate(room.getEnlistedDate());
//		currentRoom.setPricing(room.getPricing());
//		currentRoom.setRating(room.getRating());
//		return roomDAOImpl.saveAll(List.of(currentRoom)).get(0);
		return room;
	}
	
}	

