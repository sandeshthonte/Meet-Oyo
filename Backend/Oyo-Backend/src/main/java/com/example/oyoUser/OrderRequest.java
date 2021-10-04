package com.example.oyoUser;

public class OrderRequest {
	
	private User user;

	public OrderRequest() {
		super();
	}

	public OrderRequest(User user) {
		super();
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
