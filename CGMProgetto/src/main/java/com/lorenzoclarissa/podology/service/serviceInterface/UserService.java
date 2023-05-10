package com.lorenzoclarissa.podology.service.serviceInterface;

import java.util.List;

import com.lorenzoclarissa.podology.authentication.Authentication;
import com.lorenzoclarissa.podology.authentication.Session;
import com.lorenzoclarissa.podology.model.UserDTO;

public interface UserService {

	List<UserDTO> getAll();
	
	UserDTO getById(Long id);
	
	void addUser(UserDTO user);

	void deleteUser(Long id);
	
	Session checkCredentials(Authentication auth);
	
}
