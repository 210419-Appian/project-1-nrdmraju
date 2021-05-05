package com.revature.daos;

import java.util.List;

import com.revature.models.Role;

public interface RoleDao {
	
	public List<Role> findAll();
	public Role findByRoleId(int role_id);
	public Role findByRole(String role);

}
