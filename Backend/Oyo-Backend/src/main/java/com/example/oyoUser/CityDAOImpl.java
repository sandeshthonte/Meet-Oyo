package com.example.oyoUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.pst.mio.util.Dbconnection;

@Repository
public class CityDAOImpl implements CityDAO {

	@Override
	public List<City> findAll(String name) {
		final String VIEW_CITY = "select cid, name from city where name like (?);";
		City city = null;
		List<City> cities = new ArrayList<City>();
		
		try {
			Connection con = Dbconnection.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(VIEW_CITY);
			 preparedStatement.setString(1, name+"%");
			 ResultSet resultSet = preparedStatement.executeQuery();
			 while(resultSet.next()) {
				 city = new City(resultSet.getInt(1), resultSet.getString(2));
				 cities.add(city);
			 }
			 return cities;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return cities;
	}
	
}
