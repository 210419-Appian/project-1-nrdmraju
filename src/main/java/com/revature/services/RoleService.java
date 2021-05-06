package com.revature.services;

import java.util.List;

import com.revature.models.Role;

import com.revature.daos.RoleDao;
import com.revature.daos.RoleDaoImpl;


public class RoleService {

	private RoleDao rDao = new RoleDaoImpl();

	public List<Role> getAllRoles() {
		return rDao.findAll();

	}

	public Role findByRoleId(int roleId) {
		return rDao.findByRoleId(roleId);
	}
}
