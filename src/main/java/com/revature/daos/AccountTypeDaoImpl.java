package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.AccountType;
import com.revature.utils.ConnectionUtil;

public class AccountTypeDaoImpl implements AccountTypeDao {
	
	@Override
	public List<AccountType> findAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM account_types;";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			List<AccountType> list = new ArrayList<>();
			
//			AccountType type = new AccountType ();
			
			while (result.next()) {
				AccountType type = new AccountType ();
				type.setTypeId(result.getInt("type_id"));
				type.setType(result.getString("type_description"));
				list.add(type);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public AccountType findByAccountTypeId(int typeId) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM account_types WHERE type_id = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, typeId);

			ResultSet result = statement.executeQuery();

			AccountType type = new AccountType();

			while (result.next()) {
				type.setTypeId(result.getInt("type_id"));
				type.setType(result.getString("type_description"));
			
			}

			return type;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	
	

	@Override
	public AccountType findByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
