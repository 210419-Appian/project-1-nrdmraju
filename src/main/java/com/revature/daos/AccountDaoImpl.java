package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
import com.revature.utils.ConnectionUtil;

public class AccountDaoImpl implements AccountDao {

	private static UserDao uDao = new UserDaoImpl();
	private static AccountTypeDao  aDao = new AccountTypeDaoImpl();
	private static AccountStatusDao asDao = new AccountStatusDaoImpl();
	
//	CREATE TABLE accounts(
//			 account_Id SERIAL PRIMARY KEY, 
//			 balance DOUBLE PRECISION NOT NULL,
//			 account_status INTEGER REFERENCES account_status(status_id),
//			 account_type INTEGER REFERENCES account_types(type_id),
//			 user_id INTEGER REFERENCES users(user_id)
//			);
//	
//	public class Account {
//		  private int accountId; // primary key
//		  private double balance;  // not null
//		  private AccountStatus status;
//		  private AccountType type;
//		  private int userId;
		  
	
	@Override
	public List<Account> findAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM accounts;";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			List<Account> list = new ArrayList<>();

			while (result.next()) {
				Account a = new Account(
						result.getInt("account_Id"), 
						result.getDouble("balance"), 
						null, // account_status INTEGER REFERENCES account_status(status_id) createFindById in AccountStatusDaoImpl
						null, // account_type INTEGER REFERENCES account_types(type_id) createFindById in AccountTypeDaoImpl
						null
						);
				
				int accStatus = result.getInt("account_status");
					a.setStatus(asDao.findByStatusId(accStatus));
					
				int accType = result.getInt("account_type");
					a.setType(aDao.findByAccountTypeId(accType));
					
				int accUser = result.getInt("user_id");
					a.setUser(uDao.findByUserId(accUser));
				list.add(a);
			}

			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
//=========================================================================================================================================================	
	
	@Override
	public Account findByAccountId(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM accounts WHERE account_id = "+id+";";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);
			
			Account acc = null;
			
			while (result.next()) {
				acc = new Account(
						result.getInt("account_Id"), 
						result.getDouble("balance"), 
						null, // account_status INTEGER REFERENCES account_status(status_id) createFindById in AccountStatusDaoImpl
						null, // account_type INTEGER REFERENCES account_types(type_id) createFindById in AccountTypeDaoImpl
						null
						);
					int accStatus = result.getInt("account_status");
					acc.setStatus(asDao.findByStatusId(accStatus));
					
				int accType = result.getInt("account_type");
				acc.setType(aDao.findByAccountTypeId(accType));
					
				int accUser = result.getInt("user_id");
				acc.setUser(uDao.findByUserId(accUser));
				
			return acc;
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
//=========================================================================================================================================================	
	
	@Override
	public List<Account> findByUserId(int userId) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM accounts WHERE user_id = "+userId+";";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			List<Account> list = new ArrayList<>();

			while (result.next()) {
				Account auid = new Account(
						result.getInt("account_Id"), 
						result.getDouble("balance"), 
						null, // account_status INTEGER REFERENCES account_status(status_id) createFindById in AccountStatusDaoImpl
						null, // account_type INTEGER REFERENCES account_types(type_id) createFindById in AccountTypeDaoImpl
						null //
						);
					int accStatus = result.getInt("account_status");
					auid.setStatus(asDao.findByStatusId(accStatus));
					
					int accType = result.getInt("account_type");
					auid.setType(aDao.findByAccountTypeId(accType));
					
					int accUser = result.getInt("user_id");
					auid.setUser(uDao.findByUserId(accUser));
					list.add(auid);
				}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		return null;
	}
	
//=========================================================================================================================================================	
	
	@Override
	public List<Account> findByAccountTypeId(int typeId) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM accounts WHERE account_type = "+typeId+";";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);
			
			List<Account> list = new ArrayList<>();
			
			while (result.next()) {
				Account atyid = new Account(
						result.getInt("account_Id"), 
						result.getDouble("balance"), 
						null, // account_status INTEGER REFERENCES account_status(status_id) createFindById in AccountStatusDaoImpl
						null, // account_type INTEGER REFERENCES account_types(type_id) createFindById in AccountTypeDaoImpl
						null // account_user INTEGER REFERENCES accounts(user_id) createFindById in AccountDaoImpl
						);
					int accStatus = result.getInt("account_status");
					atyid.setStatus(asDao.findByStatusId(accStatus));
					
				int accType = result.getInt("account_type");
				atyid.setType(aDao.findByAccountTypeId(accType));
					
				int accUser = result.getInt("user_id");
				atyid.setUser(uDao.findByUserId(accUser));
				
				 list.add(atyid);
				}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
//=========================================================================================================================================================	
	
	@Override
	public List<Account> findByAccountStatusId(int statusId) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM accounts WHERE account_status = "+statusId+";";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);
			
			List<Account> list = new ArrayList<>();
			
			while (result.next()) {
				Account astid = new Account(
						result.getInt("account_Id"), 
						result.getDouble("balance"), 
						null, // account_status INTEGER REFERENCES account_status(status_id) createFindById in AccountStatusDaoImpl
						null, // account_type INTEGER REFERENCES account_types(type_id) createFindById in AccountTypeDaoImpl
						null // account_user INTEGER REFERENCES accounts(user_id) createFindById in AccountDaoImpl
						);
					int accStatus = result.getInt("account_status");
					astid.setStatus(asDao.findByStatusId(accStatus));
					
					int accType = result.getInt("account_type");
					astid.setType(aDao.findByAccountTypeId(accType));
						
					int accUser = result.getInt("user_id");
					astid.setUser(uDao.findByUserId(accUser));
				
				 list.add(astid);
				}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
//=========================================================================================================================================================	
	
	@Override
	public boolean updateAccount(Account a) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "UPDATE accounts "
					 +"SET balance = ?, account_status = ? WHERE account_id = ?; ";

			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
			statement.setDouble(++index, a.getBalance());
			statement.setInt(++index, a.getStatus().getStatusId());
			statement.setInt(++index, a.getAccountId());

			
			statement.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}	

//=========================================================================================================================================================	

	@Override
	public boolean addAccount(Account a) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			//There is no chance for sql injection with just an integer so this is safe. 
			String sql = "INSERT INTO accounts (balance, account_status, account_type, user_id)"
					+ "	VALUES ( ?, ?, ?, ?);";

			
			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
//			statement.setInt(++index, a.getAccountId());
//			statement.setDouble(++index, a.getBalance());
//			statement.setString(++index, a.getStatus().getStatus());
//			statement.setString(++index, a.getType().getType());
//			statement.setInt(++index, a.getUser().getUserId());

			statement.setDouble(++index, a.getBalance());
			statement.setInt(++index, a.getStatus().getStatusId());
			statement.setInt(++index, a.getType().getTypeId());
			statement.setInt(++index, a.getUser().getUserId());
			
			statement.execute();
			
			return true;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}	
//			
//=========================================================================================================================================================	

	@Override
	public Account findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
