package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.utils.ConnectionUtil;



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
			

			while (result.next()) {
				User u = new User();
						u.setUserId(result.getInt("user_id"));
						u.setUsername(result.getString("username"));
						u.setPassword(result.getString("user_password"));
						u.setFirstName(result.getString("first_name"));
						u.setLastName(result.getString("last_name"));
						u.setEmail(result.getString("email"));
						u.setRole(null);
					
				int rName = result.getInt("user_role");
					u.setRole(rDao.findByRoleId(rName));
				list.add(u);
			}

			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
//=========================================================================================================================================================	
	
	@Override
	public User findByUserId(int userId) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM users WHERE user_id = "+userId+";";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			User u = null;
			
			while (result.next()) {
				 u = new User(
						result.getInt("user_id"),
						result.getString("username"),
						result.getString("user_password"),
						result.getString("first_name"),
						result.getString("last_name"),
						result.getString("email"),
						null);
				 
					int rName = result.getInt("user_role");
						u.setRole(rDao.findByRoleId(rName));
				
				}
			return u;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
//=========================================================================================================================================================	

	@Override
	public User findByUsername(String username) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM users WHERE username = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, username);

			ResultSet result = statement.executeQuery();

			User u = null;
			
			while (result.next()) {
				 u = new User(
						result.getInt("user_id"),
						result.getString("username"),
						result.getString("user_password"),
						result.getString("first_name"),
						result.getString("last_name"),
						result.getString("email"),
						null);
				 
					int rName = result.getInt("user_role");
					u.setRole(rDao.findByRoleId(rName));
				
				}
			return u;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
//=========================================================================================================================================================	

	@Override
	public boolean updateUser(User u) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "UPDATE users "
					 +"SET username = ?, user_password = ?, first_name = ?, "
					+ "last_name = ?, email = ?, user_role =? WHERE user_id = ?; ";

			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
			statement.setString(++index, u.getUsername());
			statement.setString(++index, u.getPassword());
			statement.setString(++index, u.getFirstName());
			statement.setString(++index, u.getLastName());
			statement.setString(++index, u.getEmail());
			statement.setInt(++index, u.getRole().getRoleId());
			statement.setInt(++index, u.getUserId());

			
			statement.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

//=========================================================================================================================================================	

	//Come back to this and finish the addUser method.
	@Override
	public boolean addUser(User u) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			//There is no chance for sql injection with just an integer so this is safe. 
			String sql = "INSERT INTO users (username, user_password, first_name, last_name, email, user_role)"
					+ "	VALUES ( ?, ?, ?, ?, ?, ?);";

			
			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
//			statement.setInt(++index, u.getUserId());
			statement.setString(++index, u.getUsername());
			statement.setString(++index, u.getPassword());
			statement.setString(++index, u.getFirstName());
			statement.setString(++index, u.getLastName());
			statement.setString(++index, u.getEmail());
			statement.setInt(++index, u.getRole().getRoleId());
			
			statement.execute();
			return true;


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
//=========================================================================================================================================================	
	
	
 //HelloFrontController -> AvengerDaoImpl

}
