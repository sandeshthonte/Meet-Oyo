package com.example.oyoUser;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/privilege")
public class UserController {
	
	@Autowired
	private UserService userService = null;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/users")
	public List<User> getUsers() {
		 return userService.getUsers();
	 }
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable Integer id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("/getUser/{email}/{password}")
	public User findByEmailPassword(@PathVariable String email, @PathVariable String password) {
		System.out.println(email+password);
		return userService.findByEmailPassword(email, password);
	}
	
	@PostMapping("/addUser")
	public User save(@RequestBody User user) {
		System.out.println(user.getName());
		return userService.save(user);
	}
	
	@PostMapping("/addUsers")
	public List<User> saveAll(@RequestBody List<User> users) {
		return userService.saveAll(users);
	}
}
