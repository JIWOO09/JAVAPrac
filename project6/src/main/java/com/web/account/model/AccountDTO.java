package com.web.account.model;

public class AccountDTO {
	private int id;
	private String username;
	private String password;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username.toLowerCase();
						//소문자 적용
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password.toLowerCase();
	}
}