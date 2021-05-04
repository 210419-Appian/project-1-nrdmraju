package Daos;

import java.util.List;

import models.Role;

public interface RoleDao {
	
	public List<Role> findAll();
	public Role findByRoleId(int role_id);
//	public Role findByRole(String role);

}
