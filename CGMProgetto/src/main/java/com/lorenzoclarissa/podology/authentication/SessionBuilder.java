package com.lorenzoclarissa.podology.authentication;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.lorenzoclarissa.podology.model.UserDTO;

@Component
public class SessionBuilder {

	public static Session setSession(UserDTO user) {
		System.out.println("session builder");
		return new Session(user.getId(), user.getUsername(), user.getRole().toString(), LocalDateTime.now());
	}
	
}
