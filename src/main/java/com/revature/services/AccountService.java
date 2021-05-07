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

	public List<Account> findByAccountId(int Id) {
		return aDao.findByAccountId(Id);
	}

	public List<Account> findByUserId(int userId) {
		return aDao.findByUserId(userId);
	}
}
