package com.example.oyoUser;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class City {
	
	@Id  
	@GeneratedValue 
	private Integer cid;
	private String name;
	
	public City() {
		super();
	}

	public City(Integer cid,String name) {
		super();
		this.cid = cid;
		this.setCity(name);
	}

	public String getCity() {
		return name;
	}

	public void setCity(String name) {
		this.name = name;
	}

}
