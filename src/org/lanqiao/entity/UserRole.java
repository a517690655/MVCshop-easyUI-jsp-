package org.lanqiao.entity;

public class UserRole {
	private String uRoleId;
	private String uRoleName;
	public String getuRoleId() {
		return uRoleId;
	}
	public void setuRoleId(String uRoleId) {
		this.uRoleId = uRoleId;
	}
	public String getuRoleName() {
		return uRoleName;
	}
	public void setuRoleName(String uRoleName) {
		this.uRoleName = uRoleName;
	}
	public UserRole(String uRoleId, String uRoleName) {
		super();
		this.uRoleId = uRoleId;
		this.uRoleName = uRoleName;
	}
	public UserRole() {
		super();
	}
	
}
