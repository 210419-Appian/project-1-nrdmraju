package driver;

import java.util.List;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.services.RoleService;
import com.revature.services.UserService;

public class Driver {
	
	private static RoleService rService = new RoleService();
	private static UserService uService = new UserService();

	public static void main(String[] args) {
		List<Role> list = rService.getAllRoles();
		
		//System.out.println(list);

		for(Role r: list) {
			System.out.println(r);
			
			System.out.println("======================================");
			
			List<User> uList = uService.getAllUsers();
			System.out.println(uList);
			
			System.out.println("======================================");
		}
	
	}

}
