package com.example.oyoUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.pst.mio.util.Dbconnection;

@Repository
public class BookingDAOImpl implements BookingDAO {
	LocalDateConvertor localDateConvertor = new LocalDateConvertor();
	@Override
	public List<Booking> findAll() {
		final String VIEW_bookingS = "select bid, rid, id, from_date, to_date, approval, duration from booking;";
		List <Booking> bookingList = new ArrayList<Booking>();
		try {
			Connection con = Dbconnection.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(VIEW_bookingS);
			 
			 ResultSet resultSet = preparedStatement.executeQuery();
			 while(resultSet.next()) {
				 LocalDate toDate = localDateConvertor.convertToEntityAttribute(resultSet.getDate(4));
				 LocalDate fromDate = localDateConvertor.convertToEntityAttribute(resultSet.getDate(5));
				 Booking booking = new Booking(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3), toDate, fromDate, resultSet.getString(6), resultSet.getString(7));
				 bookingList.add(booking);
			 }
			 return bookingList;
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return bookingList;
	}

	@Override
	public Booking findById(Integer id) {
		final String VIEW_bookingS = "select bid, rid, id, from_date, to_date, approval, duration from booking;";
		Booking booking = null;
		try {
			Connection con = Dbconnection.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(VIEW_bookingS);
			 preparedStatement.setInt(1, id);
			 ResultSet resultSet = preparedStatement.executeQuery();
			 if(resultSet.next()) {
				 booking = new Booking(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3), localDateConvertor.convertToEntityAttribute(resultSet.getDate(4)), localDateConvertor.convertToEntityAttribute(resultSet.getDate(5)), resultSet.getString(6), resultSet.getString(7));
			 }
			 return booking;
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return booking;
	}

	@Override
	public Booking save(Booking booking) {
		try {
			Connection con = Dbconnection.getConnection();
			 final String SAVE_HALL = "insert into booking(bid, rid, id, from_date, to_date, approval, duration) values(?, ?, ?, ?, ?, ?, ?);";
			 PreparedStatement preparedStatement = con.prepareStatement(SAVE_HALL);
			 preparedStatement.setInt(1, booking.getBid());
			 preparedStatement.setInt(2, booking.getRid());
			 preparedStatement.setInt(3, booking.getId());
			 preparedStatement.setDate(4, localDateConvertor.convertToDatabaseColumn(booking.getFromDate()));
			 preparedStatement.setDate(5, localDateConvertor.convertToDatabaseColumn(booking.getToDate()));
			 preparedStatement.setString(6, booking.getApproval());
			 preparedStatement.setString(7, booking.getDuration());
			 int i = preparedStatement.executeUpdate();
			 if(i!=0) return booking;
			 return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return booking;
	}

	@Override
	public List<Booking> saveAll(List<Booking> bookings) {
		int i=0;
		try {
			Connection con = Dbconnection.getConnection();
			 final String SAVE_HALL = "insert into booking(bid, rid, id, from_date, to_date, approval, duration) values(?, ?, ?, ?, ?, ?, ?);";
			 PreparedStatement preparedStatement = con.prepareStatement(SAVE_HALL);
			 for(Booking booking: bookings) {
			 preparedStatement.setInt(1, booking.getBid());
			 preparedStatement.setInt(2, booking.getRid());
			 preparedStatement.setInt(3, booking.getId());
			 preparedStatement.setDate(4, localDateConvertor.convertToDatabaseColumn(booking.getFromDate()));
			 preparedStatement.setDate(5, localDateConvertor.convertToDatabaseColumn(booking.getToDate()));
			 preparedStatement.setString(6, booking.getApproval());
			 preparedStatement.setString(7, booking.getDuration());
			 i = preparedStatement.executeUpdate();
			 }
			 if(i!=0) return bookings;
			 return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return bookings;
	}

	@Override
	public String deleteById(Integer id) {
		int i=0;
		final String UPDATE_BOOKING = "delete from booking where bid = (?);";
		try {
			Connection con = Dbconnection.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(UPDATE_BOOKING);
			System.out.println(id);
			 preparedStatement.setInt(1, id);
			 i = preparedStatement.executeUpdate();
			 if(i!=0) return "Deleted";
			  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Not Deleted";
	}

	@Override
	public List<Booking> findByApp(String approval) {
		final String VIEW_bookingS = "select bid, rid, id, from_date, to_date, approval, duration from booking where approval = (?);";
		List <Booking> bookingList = new ArrayList<Booking>();
		try {
			Connection con = Dbconnection.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(VIEW_bookingS);
			 preparedStatement.setString(1, approval);
			 ResultSet resultSet = preparedStatement.executeQuery();
			 while(resultSet.next()) {
				 LocalDate toDate = localDateConvertor.convertToEntityAttribute(resultSet.getDate(4));
				 LocalDate fromDate = localDateConvertor.convertToEntityAttribute(resultSet.getDate(5));
				 Booking booking = new Booking(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3), toDate, fromDate, resultSet.getString(6), resultSet.getString(7));
				 bookingList.add(booking);
			 }
			 return bookingList;
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return bookingList;
	}

	@Override
	public String updateById(Integer id, String approval) {
		int i=0;
		final String UPDATE_BOOKING = "update booking set approval = (?) where bid = (?);";
		try {
			Connection con = Dbconnection.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(UPDATE_BOOKING);
			 preparedStatement.setString(1, approval);
			 preparedStatement.setInt(2, id);
			 i = preparedStatement.executeUpdate();
			 if(i!=0) return "Updated";
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Not Updated";
	}

}
