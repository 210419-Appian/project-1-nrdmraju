package com.revature.daos;

import java.util.List;

import com.revature.models.Account;
import com.revature.models.User;

public interface AccountDao {
	
	public List<Account> findAll();
	public List<Account> findByAccountId(int id);
	public List<Account> findByUserId(int userId);
	public List<Account> findByAccountTypeId(int typeId);
	public List<Account> findByAccountStatusId(int statusId);
	public Account findById(int id);
	public boolean addAccount(Account a);
	public boolean updateAccount(Account a);
	
}
