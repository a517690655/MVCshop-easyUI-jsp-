package org.lanqiao.entity;

public class UserState {
	private String uStateId;
	private String uStateName;
	public String getuStateId() {
		return uStateId;
	}
	public void setuStateId(String uStateId) {
		this.uStateId = uStateId;
	}
	public String getuStateName() {
		return uStateName;
	}
	public void setuStateName(String uStateName) {
		this.uStateName = uStateName;
	}
	public UserState(String uStateId, String uStateName) {
		super();
		this.uStateId = uStateId;
		this.uStateName = uStateName;
	}
	public UserState() {
		super();
	}
	
}
