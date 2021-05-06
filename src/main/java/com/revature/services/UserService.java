package com.revature.services;

import java.util.List;

import com.revature.models.User;
import com.revature.daos.UserDao;
import com.revature.daos.UserDaoImpl;


public class UserService {

	private UserDao uDao = new UserDaoImpl();

	public List<User> getAllUsers() {

		return uDao.findAll();

	}

	public User findById(int userId) {
		return uDao.findByUserId(userId);
	}

	public boolean createUser(User user) {
		return uDao.addUser(user);
	}
}
