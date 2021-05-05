package com.revature.services;

import java.util.List;

import com.revature.models.User;
import com.revature.daos.UserDao;
import com.revature.daos.UserDaoImpl;


public class UserService {

	private UserDao uDao = new UserDaoImpl();

	public List<User> getAllUsers() {

		List<User> list = uDao.findAll();

		return list;

	}

	public User findById(int user_id) {
		return uDao.findByUserId(user_id);
	}

	public boolean createUser(User user) {
		return uDao.addUser(user);
	}
}
