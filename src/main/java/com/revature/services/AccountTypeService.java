package com.revature.services;

import java.util.List;

import com.revature.daos.AccountTypeDao;
import com.revature.daos.AccountTypeDaoImpl;
import com.revature.models.AccountType;

public class AccountTypeService {
	
	private AccountTypeDao acctyDao = new AccountTypeDaoImpl();
	
	public List<AccountType> getAllAccountType(){
		return acctyDao.findAll();
	}
	
	public AccountType findByAccountTypeId(int typeId) {
		return acctyDao.findByAccountTypeId(typeId);
	}
	
}
