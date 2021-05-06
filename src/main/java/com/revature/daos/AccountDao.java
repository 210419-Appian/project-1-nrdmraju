package com.revature.daos;

import java.util.List;

import com.revature.models.Account;
import com.revature.models.User;

public interface AccountDao {
	
	public List<Account> findAll();
	public Account findByAccountId(int id);
	public Account findByUserId(int user_id);
	public boolean addAccount(Account a);
	public boolean updateAccount(Account a);
	
}
