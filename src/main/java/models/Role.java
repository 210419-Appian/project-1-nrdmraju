package models;

public class Role {
	  private int roleId; // primary key
	  private String role; // not null, unique
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", role=" + role + ", getRoleId()=" + getRoleId() + ", getRole()=" + getRole()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public Role(int roleId, String role) {
		super();
		this.roleId = roleId;
		this.role = role;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	  
	  
	}