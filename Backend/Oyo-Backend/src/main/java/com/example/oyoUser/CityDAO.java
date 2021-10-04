package com.example.oyoUser;

import java.util.List;

public interface CityDAO{	
	
	List<City> findAll(String city);
	//@Query("SELECT new com.example.oyoUser.OrderAllNamesDTO(u.name, r.hotel_name) FROM User u join u.User r")
	//public List<OrderAllNamesDTO> getJoinInformation();
}
