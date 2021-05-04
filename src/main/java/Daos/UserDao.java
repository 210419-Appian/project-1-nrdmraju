package Daos;

import java.util.List;

import models.User;

public interface UserDao {
	
	public List<User> findAll();
	public User findById(int user_id);
	public User findByUsername(String username);
	public boolean addUser(User u);
	
}
