package com.lorenzoclarissa.podology.service.serviceInterface;

import com.lorenzoclarissa.podology.model.UserDTO;

public interface UserService {

	UserDTO getUser(String username, String password);
	
}
