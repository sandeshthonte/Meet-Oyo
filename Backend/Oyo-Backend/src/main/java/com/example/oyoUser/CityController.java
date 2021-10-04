package com.example.oyoUser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/city")
public class CityController {
	
	@Autowired
	private CityService cityService = null;
	
	@Autowired
	public CityController(CityService cityService) {
		this.cityService = cityService;
	}
	
	@GetMapping("/cities/{name}")
	public List<City> getUsers(@PathVariable String name) {
		 return cityService.getCities(name);
	 }
}
