package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.AccountStatus;

import utils.ConnectionUtil;

public class AccountStatusDaoImpl implements AccountStatusDao {
	
	@Override
	public List<AccountStatus> findAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM account_status;";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			List<AccountStatus> list = new ArrayList<>();
			
			AccountStatus status = new AccountStatus ();
			
			while (result.next()) {
				status.setStatusId(result.getInt("status_id"));
				status.setStatus(result.getString("status"));
			
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public AccountStatus findByStatusId(int status_id) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM account_status WHERE status_id = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, status_id);

			ResultSet result = statement.executeQuery();

			AccountStatus status = new AccountStatus();

			while (result.next()) {
				status.setStatusId(result.getInt("status_id"));
				status.setStatus(result.getString("status"));
			
			}

			return status;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	
	

	@Override
	public AccountStatus findByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

}
