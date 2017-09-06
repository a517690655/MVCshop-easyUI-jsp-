package org.lanqiao.entity;

public class User {
	private String userId;
	private String uEmail;
	private String uLoginId;
	private String uPassword;
	private String uSex;
	private String uAddress;
	private String uTel;
	private String uStateId;
	private String uRoleId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public String getuLoginId() {
		return uLoginId;
	}
	public void setuLoginId(String uLoginId) {
		this.uLoginId = uLoginId;
	}
	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	public String getUsex() {
		return uSex;
	}
	public void setUsex(String usex) {
		this.uSex = usex;
	}
	public String getuAddress() {
		return uAddress;
	}
	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}
	public String getuTel() {
		return uTel;
	}
	public void setuTel(String uTel) {
		this.uTel = uTel;
	}
	public String getuStateId() {
		return uStateId;
	}
	public void setuStateId(String uStateId) {
		this.uStateId = uStateId;
	}
	public String getuRoleId() {
		return uRoleId;
	}
	public void setuRoleId(String uRoleId) {
		this.uRoleId = uRoleId;
	}
	public User(String userId, String uEmail, String uLoginId,
			String uPassword, String usex, String uAddress, String uTel,
			String uStateId, String uRoleId) {
		super();
		this.userId = userId;
		this.uEmail = uEmail;
		this.uLoginId = uLoginId;
		this.uPassword = uPassword;
		this.uSex = usex;
		this.uAddress = uAddress;
		this.uTel = uTel;
		this.uStateId = uStateId;
		this.uRoleId = uRoleId;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", uEmail=" + uEmail + ", uLoginId="
				+ uLoginId + ", uPassword=" + uPassword + ", uSex=" + uSex
				+ ", uAddress=" + uAddress + ", uTel=" + uTel + ", uStateId="
				+ uStateId + ", uRoleId=" + uRoleId + "]";
	}
	
	
}
