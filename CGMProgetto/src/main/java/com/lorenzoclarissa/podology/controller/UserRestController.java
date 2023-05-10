package com.lorenzoclarissa.podology.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lorenzoclarissa.podology.model.UserDTO;
import com.lorenzoclarissa.podology.service.UserServiceIMPL;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
	
	@Autowired
	private UserServiceIMPL service;
	
	@GetMapping
	public List<UserDTO> viewAll(){
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public UserDTO viewById(@PathVariable("id") Long id) {
		return service.getById(id);
	}
	
	@PostMapping
	public void newUser(@RequestBody UserDTO user) {
		service.addUser(user);
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Long id){
		service.deleteUser(id);
	}
	
	
}
