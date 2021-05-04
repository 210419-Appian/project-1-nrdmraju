package Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.AccountType;
import utils.ConnectionUtil;

public class AccountTypeDaoImpl implements AccountTypeDao {
	
	@Override
	public List<AccountType> findAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM account_types;";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			List<AccountType> list = new ArrayList<>();
			
			AccountType type = new AccountType ();
			
			while (result.next()) {
				type.setTypeId(result.getInt("type_id"));
				type.setType(result.getString("type"));
			
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public AccountType findByAccountTypeId(int type_id) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM account_type WHERE type_id = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, type_id);

			ResultSet result = statement.executeQuery();

			AccountType type = new AccountType();

			while (result.next()) {
				type.setTypeId(result.getInt("type_id"));
				type.setType(result.getString("type"));
			
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
