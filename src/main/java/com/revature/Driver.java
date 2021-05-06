package com.revature;

import java.util.List;

import com.revature.models.AccountStatus;
import com.revature.models.AccountType;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.services.AccountStatusService;
import com.revature.services.AccountTypeService;
import com.revature.services.RoleService;
import com.revature.services.UserService;

public class Driver {
	
	private static RoleService rService = new RoleService();
	private static UserService uService = new UserService();
	private static AccountStatusService  accstService = new AccountStatusService();
	private static AccountTypeService  acctyService = new AccountTypeService();

	public static void main(String[] args) {
		List<User> ulist = uService.getAllUsers();
		
		System.out.println(ulist);
		System.out.println("======================================");
		
		List<Role> rlist = rService.getAllRoles();
		
		System.out.println(rlist);
		System.out.println("======================================");
		
		Role r1 = rService.findByRoleId(1);
		System.out.println(r1);
		System.out.println("======================================");

		List<AccountStatus> accstlist = accstService.getAllAccountStatus();
		
		System.out.println(accstlist);
		System.out.println("======================================");
		
		AccountStatus s3 = accstService.findByStatusId(3);
		System.out.println(s3);
		System.out.println("======================================");
		
		List<AccountType> acctylist = acctyService.getAllAccountType();
		
		System.out.println(acctylist);
		System.out.println("======================================");
		
		AccountType t2 = acctyService.findByAccountTypeId(2);
		System.out.println(t2);
		System.out.println("======================================");
		
		
			
//		
		}
	
	}

