package com.revature.models;

public class UserDTO {
	
	/*
	 * DTO stands for Data Transfer Object. They are temporary objects that are used to store information
	 * coming from outside your application, if that information does not perfectly fit any already
	 * existing object type in your application. 
	 */
	
	public String username;
	public String password;
	
	public UserDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public UserDTO() {
		super();
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	

}
