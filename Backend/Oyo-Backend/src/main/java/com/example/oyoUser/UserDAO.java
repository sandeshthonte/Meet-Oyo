package com.example.oyoUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pst.mio.util.Dbconnection;

public interface UserDAO{	
	
	List<User> findAll();
	User findById(Integer id);
	User findByEmailPassword(String email, String password);
	List<User> saveAll(List<User> users);
	String deleteById(Integer id);
	User save(User user);
	//@Query("SELECT new com.example.oyoUser.OrderAllNamesDTO(u.name, r.hotel_name) FROM User u join u.User r")
	//public List<OrderAllNamesDTO> getJoinInformation();
}
