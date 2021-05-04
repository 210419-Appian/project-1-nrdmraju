package Daos;

import models.AccountType;

import java.util.List;

public interface AccountTypeDao {
	
	public List<AccountType> findAll();
	public AccountType findByAccountTypeId(int type_id);
	public AccountType findByType(String type);
}
