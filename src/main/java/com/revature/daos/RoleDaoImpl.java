package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Role;

import utils.ConnectionUtil;


public class RoleDaoImpl implements RoleDao {
	
	@Override
	public List<Role> findAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM roles;";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			List<Role> list = new ArrayList<>();
			
			Role role = new Role();
			
			while (result.next()) {
				role.setRoleId(result.getInt("role_id"));
				role.setRole(result.getString("role_description"));
			
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Role findByRoleId(int role_id) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM roles WHERE role_id = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, role_id);

			ResultSet result = statement.executeQuery();

			Role role = new Role();

			while (result.next()) {
				role.setRoleId(result.getInt("role_id"));
				role.setRole(result.getString("role_description"));
			
			}

			return role;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	

	@Override
	public Role findByRole(String role) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
