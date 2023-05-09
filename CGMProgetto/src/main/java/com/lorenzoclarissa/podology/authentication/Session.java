package com.lorenzoclarissa.podology.authentication;

import java.time.LocalDateTime;

public class Session {

	private Long userId;
	private String username;
	private String role;
	private LocalDateTime loginDate;
	
	public Session(Long userId, String username, String role, LocalDateTime loginDate) {
		this.userId = userId;
		this.username = username;
		this.role = role;
		this.loginDate = loginDate;
	}
	
	public Session() {
		
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalDateTime getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(LocalDateTime loginDate) {
		this.loginDate = loginDate;
	}

	
	
}
