package com.revature.services;

import java.util.List;

import com.revature.models.Role;

import com.revature.daos.RoleDao;
import com.revature.daos.RoleDaoImpl;


public class RoleService {

	private RoleDao rDao = new RoleDaoImpl();

	public List<Role> getAllRoles() {

		List<Role> list = rDao.findAll();
		return list;

	}

	public Role findByRole(String role) {
		return rDao.findByRole(role);
	}
}
