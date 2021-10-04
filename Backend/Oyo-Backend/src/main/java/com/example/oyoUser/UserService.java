package com.example.oyoUser;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class UserService {
	
	@Autowired
	private UserDAOImpl userDAOImpl = null;
	
	
	 @Autowired 
	public UserService(UserDAOImpl userDAOImpl) {
		 this.userDAOImpl = userDAOImpl; 
	}
	 
	public List<User> getUsers() {
		 return userDAOImpl.findAll();
	 }
	
	public User getUserById(Integer id) {
		return userDAOImpl.findById(id);
	}
	
	public User save(User user) {
		return userDAOImpl.save(user);
	}
	
	public List<User> saveAll(@RequestBody List<User> users) {
		return userDAOImpl.saveAll(users);
	}
	
	public User findByEmailPassword(String email, String password) {
		return userDAOImpl.findByEmailPassword(email, password);
	}
}
