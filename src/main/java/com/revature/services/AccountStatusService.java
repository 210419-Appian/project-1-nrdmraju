package com.revature.services;

import java.util.List;

import com.revature.daos.AccountStatusDao;
import com.revature.daos.AccountStatusDaoImpl;
import com.revature.models.AccountStatus;

public class AccountStatusService {
	
	private AccountStatusDao accstDao = new AccountStatusDaoImpl();
	
	public List<AccountStatus> getAllAccountStatus(){
		return accstDao.findAll();
	}
	
	public AccountStatus findByStatusId(int statusId) {
		return accstDao.findByStatusId(statusId);
	}
	
}
