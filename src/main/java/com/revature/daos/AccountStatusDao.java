package com.revature.daos;

import java.util.List;

import com.revature.models.AccountStatus;

public interface AccountStatusDao {
	
	
	public List<AccountStatus> findAll();
	public AccountStatus findByStatusId(int status_id);
	public AccountStatus findByStatus(String status);

}
