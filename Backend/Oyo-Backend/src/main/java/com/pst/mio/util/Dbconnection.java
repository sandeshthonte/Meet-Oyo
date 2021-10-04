package com.pst.mio.util;

import java.sql.DriverManager;
import java.sql.Connection;

public class Dbconnection {
	
	//load the driver
	//get the connection
	//create statement
	//execute get Result
	//close
	public static Connection con = null;
	
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oyorooms", "root", "lxgiwyl027");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}
}
