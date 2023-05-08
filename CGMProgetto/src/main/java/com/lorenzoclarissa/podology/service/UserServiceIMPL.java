package com.lorenzoclarissa.podology.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.lorenzoclarissa.podology.entity.UserEntity;
import com.lorenzoclarissa.podology.repository.UserRepository;
import com.lorenzoclarissa.podology.security.WebSecurityConfig;
import com.lorenzoclarissa.podology.service.serviceInterface.UserService;

@Service
public class UserServiceIMPL implements UserService {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private WebSecurityConfig security;
	 
	@Override
	public void getUser(String username, String password) {
		try {
			UserEntity user = repo.selectByUsername(username);
			
			if(user != null) {
				if(user.getPassword() == password) {
					security.userDetailsService(user);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
