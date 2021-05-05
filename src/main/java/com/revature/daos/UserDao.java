package com.revature.daos;

import java.util.List;

import com.revature.models.User;

public interface UserDao {
	
	public List<User> findAll();
	public User findByUserId(int user_id);
	public User findByUsername(String username);
	public User updateUser(User u);
	public boolean addUser(User u);
	
}
