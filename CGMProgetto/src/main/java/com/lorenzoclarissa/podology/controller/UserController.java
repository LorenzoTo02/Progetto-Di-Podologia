package com.lorenzoclarissa.podology.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lorenzoclarissa.podology.entity.UserEntity;
import com.lorenzoclarissa.podology.service.UserServiceIMPL;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserServiceIMPL service;
	
	@PostMapping
	public void getCredentials(@RequestBody UserEntity user) {
		service.getUser(user.getUsername(), user.getPassword());
	}
	
}
