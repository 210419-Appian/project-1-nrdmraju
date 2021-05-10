package com.revature.services;

import java.util.List;

import com.revature.models.Account;
import com.revature.daos.AccountDao;
import com.revature.daos.AccountDaoImpl;

public class AccountService {

	private AccountDao aDao = new AccountDaoImpl();

	public List<Account> getAllAccounts() {

		return aDao.findAll();

	}

	public Account findByAccountId(int Id) {
		return aDao.findByAccountId(Id);
	}

	public List<Account> findByUserId(int userId) {
		return aDao.findByUserId(userId);
	}
	
	public List<Account> findByAccountStatusId(int statusId) {
		return aDao.findByAccountStatusId(statusId);
	}
	
	public boolean createAccount(Account account) {
		return aDao.addAccount(account);
	}
	
	public Account getOneAccount(int id) {
		return aDao.findById(id);
	}
	
	public boolean putAccount(Account a) {
		return aDao.updateAccount(a);
	}
	
	public boolean updatePartialAccount(Account a) {
		if (a.getAccountId() == 0) {
			return false;
		}

		Account accData = getOneAccount(a.getAccountId());

		if (a.getBalance() == 0.0) {
			a.setBalance(accData.getBalance());
		}
		if (a.getStatus() == null) {
			a.setStatus(accData.getStatus());
		}
		if (a.getType() == null) {
			a.setType(accData.getType());
		}
		return aDao.updateAccount(a);

	}
	
	public boolean withdraw(Account a) {
		if (a.getAccountId() == 0) {
			return false;
		}
		Account accData = aDao.findByAccountId(a.getAccountId());

		if (accData.getBalance() - a.getBalance() > 0) {
			a.setBalance(accData.getBalance() - a.getBalance());
		}
		if (a.getStatus() == null) {
			a.setStatus(accData.getStatus());
		}
//		if (a.getType() == null) {
//			a.setType(accData.getType());
//		}
		return aDao.updateAccount(a);

	}
	
	public boolean deposit(Account a) {
		if (a.getAccountId() == 0) {
			return false;
		}
		Account accData = aDao.findByAccountId(a.getAccountId());

		if (accData.getBalance() + a.getBalance() >= 0) {
			a.setBalance(accData.getBalance() + a.getBalance());
		}
		if (a.getStatus() == null) {
			a.setStatus(accData.getStatus());
		}
//		if (a.getType() == null) {
//			a.setType(accData.getType());
//		}
		return aDao.updateAccount(a);

	}
}

