package com.revature.services;

import java.util.List;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.models.UserDTO;
import com.revature.daos.UserDao;
import com.revature.daos.UserDaoImpl;


public class UserService {

	private UserDao uDao = new UserDaoImpl();

	public List<User> getAllUsers() {

		return uDao.findAll();

	}

	public User findByUserId(int userId) {
		return uDao.findByUserId(userId);
	}

	public boolean createUser(User user) {
		return uDao.addUser(user);
	}
	
	public boolean putUser(User user) {
		return uDao.updateUser(user);
	}
	
	public User findByUsername(String string) {
		return uDao.findByUsername(string);
	}
	
	public boolean loginVerif(UserDTO u) {
//		System.out.println(u.username);
		User userReq = uDao.findByUsername(u.username);

		if((userReq.getPassword() != null) && (u.password.equals(userReq.getPassword()))){
			return true;
		}
		return false;
	}
	
//	
//	public User getOneUser(int id) {
//		return uDao.findByUserId(id);
//	}
//	
//	public boolean updatePartialUser(User u) {
//		if (u.getUserId() == 0) {
//			return false;
//		}
//
//		User uData = findByUserId(u.getUserId());
//
//		if (u.getUsername() == null) {
//			u.setUsername(uData.getUsername());
//		}
//		if (u.getPassword() == null) {
//			u.setPassword(uData.getPassword());
//		}
//		if (u.getFirstName() == null) {
//			u.getFirstName(uData.getFirstName());
//		}
//		if (u.getLastName() == null) {
//			u.getLastName(uData.getLastName());
//		}
//		if (u.getEmail() == null) {
//			u.getEmail(uData.getEmail());
//		}
//		if (u.getRole() == null) {
//			u.getRole(uData.getRole());
//		}
//		return uDao.updateUser(u);
//
//	}
}
