package com.example.oyoUser;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Booking {
	
	@Id 
	@GeneratedValue
	private Integer bid;
	private Integer rid;
	private Integer id;
	private LocalDate fromDate;
	private LocalDate toDate;
	private String duration;
	private String approval;	
	
	//private List<Room>
	public Booking() {
		super();
	}

	public Booking(Integer bid, Integer rid, Integer id, LocalDate fromDate, LocalDate toDate, String duration,
			String approval) {
		super();
		this.bid = bid;
		this.rid = rid;
		this.id = id;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.duration = duration;
		this.approval = approval;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}

}
