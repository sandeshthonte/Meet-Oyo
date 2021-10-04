package com.example.oyoUser;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class CityService {
	
	@Autowired
	private CityDAOImpl cityDAOImpl = null;
	
	
	 @Autowired 
	public CityService(CityDAOImpl cityDAOImpl) {
		 this.cityDAOImpl = cityDAOImpl; 
	}
	 
	public List<City> getCities(String name) {
		 return cityDAOImpl.findAll(name);
	 }
}
