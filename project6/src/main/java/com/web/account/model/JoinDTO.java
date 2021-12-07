package com.web.account.model;


import java.sql.Date;

public class JoinDTO {
	private int id;
	private String username;
	private String password;
	private String email;
	private Date joinDate;
	private Date loginDate;
	
	public JoinDTO() {}
	
	public JoinDTO(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public JoinDTO(String username, String password, String email) {
		this(username, password);
		this.email = email;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setId(String id) {
		this.id = Integer.parseInt(id);
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username.toLowerCase();
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password.toLowerCase();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
}