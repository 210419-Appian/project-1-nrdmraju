package com.revature.daos;

import java.util.List;

import com.revature.models.AccountType;

public interface AccountTypeDao {
	
	public List<AccountType> findAll();
	public AccountType findByAccountTypeId(int type_id);
	public AccountType findByType(String type);
}
