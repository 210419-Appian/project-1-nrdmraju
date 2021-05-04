package Daos;

import java.util.List;

import models.AccountType;

public interface AccountTypeDao {
	
	public List<AccountType> findAll();
	public AccountType findById(int type_id);
	public AccountType findByType(String type);
}
