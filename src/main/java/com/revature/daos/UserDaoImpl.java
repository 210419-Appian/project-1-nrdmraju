package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;

import utils.ConnectionUtil;



public class UserDaoImpl implements UserDao {

//	private static UserDao uDao = new UserDaoImpl();
	private static RoleDao rDao = new RoleDaoImpl();
	
	@Override
	public List<User> findAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM users;";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			List<User> list = new ArrayList<>();
			
			User u = new User();

			while (result.next()) {
						u.setUserId(result.getInt("user_id"));
						u.setUsername(result.getString("username"));
						u.setFirstName(result.getString("first_name"));
						u.setLastName(result.getString("last_name"));
						u.setEmail(result.getString("email"));
						u.setPassword(result.getString("user_password"));
						u.setRole(null);
					
				String rName = result.getString("user_role");
				if(rName!=null) {
					u.setRole(rDao.findByRole(rName));
				}
				list.add(u);
			}

			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addUser(User u) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			//There is no chance for sql injection with just an integer so this is safe. 
			String sql = "INSERT INTO users (user_id, username, first_name, last_name, email, user_password, user_role)"
					+ "	VALUES (?, ?, ?, ?, ?, ?);";

			
			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
			statement.setInt(++index, u.getUserId());
			statement.setString(++index, u.getUsername());
			statement.setString(++index, u.getFirstName());
			statement.setString(++index, u.getLastName());
			statement.setString(++index, u.getEmail());
			statement.setString(++index, u.getPassword());
			statement.setString(++index, u.getRole().getRole());
			
			statement.execute();
			return true;


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public User findByUserId(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}

}
