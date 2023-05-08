package com.lorenzoclarissa.podology.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lorenzoclarissa.podology.model.UserDTO;
import com.lorenzoclarissa.podology.repository.UserRepository;
import com.lorenzoclarissa.podology.service.serviceInterface.UserService;

@Service
public class UserServiceIMPL implements UserService {

	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDTO getUser(String username, String password) {
		
	}

}
