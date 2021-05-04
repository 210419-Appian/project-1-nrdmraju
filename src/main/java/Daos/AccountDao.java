package Daos;

import java.util.List;

import models.Account;

public interface AccountDao {
	
	public List<Account> findAll();
	public Account findById(int id);
	public Account findByUserId(int user_id);
	public boolean addAccount(Account a);
	
}
