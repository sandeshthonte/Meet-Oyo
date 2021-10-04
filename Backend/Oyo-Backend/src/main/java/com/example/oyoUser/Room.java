package com.example.oyoUser;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table
public class Room {
	
	@Id  
	@GeneratedValue 
	private Integer rid;

	private String address;
	private String city;
	
	private LocalDate startDate;
	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}


	private LocalDate endDate;
	private String hotelName;
	private String pricing;
	private String rating;
	
	
	public Room() {
		super();
	}

	public Room(Integer rid, String address, String city, LocalDate endDate, String hotelName,
			String pricing, String rating) {
		super();
		this.rid = rid;
		this.address = address;
		this.city = city;
		this.endDate = endDate;
		this.hotelName = hotelName;
		this.pricing = pricing;
		this.rating = rating;
	}




	public Room(Integer rid, String address, String city, LocalDate startDate, LocalDate endDate,
			String pricing, String rating, String hotelName) {
		super();
		this.rid = rid;
		this.address = address;
		this.city = city;
		this.startDate = startDate;
		this.endDate = endDate;
		this.hotelName = hotelName;
		this.pricing = pricing;
		this.rating = rating;
	}

	public Integer getRid() {
		return rid;
	}


	public void setRid(Integer rid) {
		this.rid = rid;
	}


	public String getHotelName() {
		return hotelName;
	}


	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}

	public String getPricing() {
		return pricing;
	}


	public void setPricing(String pricing) {
		this.pricing = pricing;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}

}
