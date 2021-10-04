package com.example.oyoUser;

public class OrderAllNamesDTO {
	private String name;
	private String HotelName;
	public OrderAllNamesDTO() {
		super();
	}
	public OrderAllNamesDTO(String name, String hotelName) {
		super();
		this.name = name;
		HotelName = hotelName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHotelName() {
		return HotelName;
	}
	public void setHotelName(String hotelName) {
		HotelName = hotelName;
	}
	
}
