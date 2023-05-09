package com.lorenzoclarissa.podology.model;

import com.lorenzoclarissa.podology.entity.RoleEnum;

public class UserDTO {

	private Long id;
	private String username;
	private String password;
	private RoleEnum role;
	
	public UserDTO(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public UserDTO() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleEnum getRole() {
		return role;
	}

	public void setRole(RoleEnum role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
