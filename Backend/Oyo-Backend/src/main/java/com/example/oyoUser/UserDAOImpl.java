package com.example.oyoUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.pst.mio.util.Dbconnection;

@Repository
public class UserDAOImpl implements UserDAO {

	@Override
	public List<User> findAll() {
		final String VIEW_USERS = "select id, email, name, password, privilege from user;";
		List <User> userList = new ArrayList<User>();
		try {
			Connection con = Dbconnection.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(VIEW_USERS);
			 
			 ResultSet resultSet = preparedStatement.executeQuery();
			 while(resultSet.next()) {
				 User user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
				 userList.add(user);
			 }
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public User findById(Integer id) {
		final String VIEW_USERS = "select id, email, name, password, privilege from user where id = (?);";
		User user = null;
		try {
			Connection con = Dbconnection.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(VIEW_USERS);
			 preparedStatement.setInt(1, id);
			 ResultSet resultSet = preparedStatement.executeQuery();
			 if(resultSet.next()) {
				 user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
				 
			 }
			 return user;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> saveAll(List<User> users) {
		int i=0;
		try {
			Connection con = Dbconnection.getConnection();
			 final String SAVE_USER = "insert into user(id, email, name, password, privilege) values(?, ?, ?, ?, ?);";
			 PreparedStatement preparedStatement = con.prepareStatement(SAVE_USER);
			 for(User user : users) {
			 preparedStatement.setInt(1, user.getId());
			 preparedStatement.setString(2, user.getEmail());
			 preparedStatement.setString(3, user.getName());
			 preparedStatement.setString(4, user.getPassword());
			 preparedStatement.setString(5, user.getPrivilege());
			 i = preparedStatement.executeUpdate();
			 }
			 if(i!=0) return users;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return users;
	}
	
	@Override
	public User save(User user) {
		int i=0;
		try {
			Connection con = Dbconnection.getConnection();
			final String SAVE_USER = "insert into user(id, email, name, password, privilege) values(?, ?, ?, ?, ?);";
			 PreparedStatement preparedStatement = con.prepareStatement(SAVE_USER);
			 preparedStatement.setInt(1, user.getId());
			 preparedStatement.setString(2, user.getEmail());
			 preparedStatement.setString(3, user.getName());
			 preparedStatement.setString(4, user.getPassword());
			 preparedStatement.setString(5, user.getPrivilege());
			 i = preparedStatement.executeUpdate();
			 if(i!=0) return user;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public String deleteById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByEmailPassword(String email, String password) {
		final String VIEW_USERS = "select id, email, name, password, privilege from user where email = (?) and password = (?);";
		User user = null;
		try {
			Connection con = Dbconnection.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(VIEW_USERS);
			 preparedStatement.setString(1, email);
			 preparedStatement.setString(2, password);
			 ResultSet resultSet = preparedStatement.executeQuery();
			 if(resultSet.next()) {
				 System.out.println("User Present");
				 user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
				 return user;
			 }
			 else {
				System.out.println("User Not Present");
				return null;
			}
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return user;
	}

}
