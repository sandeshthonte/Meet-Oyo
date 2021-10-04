package com.example.oyoUser;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate; 
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.stereotype.Repository;

import com.pst.mio.util.Dbconnection;

@Repository
public class RoomDAOImpl implements RoomDAO {
	LocalDateConvertor localDateConvertor = new LocalDateConvertor();
	@Override
	public List<Room> findAll() {
		final String VIEW_ROOMS = "select rid, address, city, start_date, end_date, pricing, rating, hotel_name from room";
		List <Room> roomList = new ArrayList<Room>();
		try {
			Connection con = Dbconnection.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(VIEW_ROOMS);
			 
			 ResultSet resultSet = preparedStatement.executeQuery();
			 while(resultSet.next()) {
				 Room room = new Room(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), localDateConvertor.convertToEntityAttribute(resultSet.getDate(4)), localDateConvertor.convertToEntityAttribute(resultSet.getDate(5)), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8));
				 roomList.add(room);
			 }
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return roomList; 
	}

	@Override
	public Room findById(Integer id) {
		final String VIEW_ROOMS = "select rid, address, city, start_date, end_date, pricing, rating, hotel_name from room where rid = (?);";
		Room room = null;
		try { 
			Connection con = Dbconnection.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(VIEW_ROOMS);
			 preparedStatement.setInt(1, id);
			 ResultSet resultSet = preparedStatement.executeQuery();
			 if(resultSet.next()) {
				 room = new Room(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), localDateConvertor.convertToEntityAttribute(resultSet.getDate(4)), localDateConvertor.convertToEntityAttribute(resultSet.getDate(5)), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8)); 
			 } 
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		return room; 
	}

	@Override
	public Room findByHotelName(String hotelName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Room save(Room room) {
		
		int i=0;
		try {
			Connection con = Dbconnection.getConnection();
			final String SAVE_ROOM = "insert into room(rid, address, city, end_date, hotel_name, pricing, rating, start_date) values(?, ?, ?, ?, ?, ?, ?, ?);";
			 Statement statement = con.createStatement();
			 ResultSet rst = statement.executeQuery("SELECT CURRENT_TIMESTAMP");
			 Date start_date = null;
			 if(rst.next()) {
				 start_date = rst.getDate(1);
			 }
			 
					
			 PreparedStatement preparedStatement = con.prepareStatement(SAVE_ROOM);
			 preparedStatement.setInt(1, room.getRid());
			 preparedStatement.setString(2, room.getAddress());
			 preparedStatement.setString(3, room.getCity());
			 preparedStatement.setDate(4,localDateConvertor.convertToDatabaseColumn(room.getEndDate()));
			 preparedStatement.setString(5, room.getHotelName());
			 preparedStatement.setString(6, room.getPricing());
			 preparedStatement.setString(7, room.getRating());
			 preparedStatement.setDate(8, start_date);
			 i = preparedStatement.executeUpdate();
			 if(i!=0) return room;
			 return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return room;
	}

	@Override
	public List<Room> saveAll(List<Room> rooms) {
		int i = 0;
		try {
			Connection con = Dbconnection.getConnection();
			 final String SAVE_ROOM = "insert into room(rid, address, city, end_date, hotel_name, pricing, rating, start_date) values(?, ?, ?, ?, ?, ?, ?, ?);";
			 for(Room room : rooms) {
			 Statement statement = con.createStatement();
			 ResultSet rst = statement.executeQuery("SELECT CURRENT_TIMESTAMP");
					
			 PreparedStatement preparedStatement = con.prepareStatement(SAVE_ROOM);
			 preparedStatement.setInt(1, room.getRid());
			 preparedStatement.setString(2, room.getAddress());
			 preparedStatement.setString(3, room.getCity());
			 preparedStatement.setDate(4,localDateConvertor.convertToDatabaseColumn(room.getEndDate()));
			 preparedStatement.setString(5, room.getHotelName());
			 preparedStatement.setString(6, room.getPricing());
			 preparedStatement.setString(7, room.getRating());
			 preparedStatement.setDate(8, rst.getDate(1));
			 i = preparedStatement.executeUpdate();
			 }
			 if(i!=0) return rooms;
			 return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rooms;
	}

	@Override
	public String deleteById(Integer id) {
		boolean i = false;
		try {
			Connection con = Dbconnection.getConnection();
			 final String DELETE_ROOM = "delete from room where rid = ?";
			 PreparedStatement preparedStatement = con.prepareStatement(DELETE_ROOM);
			 preparedStatement.setInt(1, id);
			 i = preparedStatement.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (i == false) return "Not Deleted";
		return "Deleted";
	}

	@Override
	public List<Room> findByCity(String city, Date fromdate, Date todate) {
		final String VIEW_ROOMS = "select rid, address, city, start_date, end_date, pricing, rating, hotel_name from room where city = (?) and start_date < (?) and end_date > (?);";
		Room room = null;
		List<Room> roomList = new ArrayList<Room>();
		try {
			Connection con = Dbconnection.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(VIEW_ROOMS);
			 preparedStatement.setString(1, city);
			 preparedStatement.setDate(2, fromdate);
			 preparedStatement.setDate(3, todate);
			 
			 ResultSet resultSet = preparedStatement.executeQuery();
			 while(resultSet.next()) {
				 room = new Room(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), localDateConvertor.convertToEntityAttribute(resultSet.getDate(4)), localDateConvertor.convertToEntityAttribute(resultSet.getDate(5)), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8));
				 roomList.add(room);
			 }
			 return roomList;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return roomList; 
	}

 
}
