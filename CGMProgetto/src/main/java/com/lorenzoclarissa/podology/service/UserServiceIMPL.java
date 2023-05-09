package com.lorenzoclarissa.podology.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lorenzoclarissa.podology.authentication.Authentication;
import com.lorenzoclarissa.podology.authentication.Session;
import com.lorenzoclarissa.podology.authentication.SessionBuilder;
import com.lorenzoclarissa.podology.entity.UserEntity;
import com.lorenzoclarissa.podology.factory.Factory;
import com.lorenzoclarissa.podology.model.UserDTO;
import com.lorenzoclarissa.podology.repository.UserRepository;
import com.lorenzoclarissa.podology.service.serviceInterface.UserService;

@Service
public class UserServiceIMPL implements UserService{

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private SessionBuilder sessionBuilder;

	@Override
	public List<UserDTO> getAll() {
		List<UserDTO> usersDTO = new ArrayList<>();
		List<UserEntity> usersEntity = repo.findAll();
		for (UserEntity userEntity : usersEntity) {
			usersDTO.add(Factory.userEntityToDTO(userEntity));
		}
		return usersDTO;
	}

	@Override
	public UserDTO getById(Long id) {
		return Factory.userEntityToDTO(repo.findById(id).get());
	}

	@Override
	public void addUser(UserDTO user) {
		repo.save(Factory.UserDTOtoUserEntity(user));
	}

	@Override
	public Session checkCredentials(Authentication auth) {
		System.out.println("Check");
		if(repo.selectbyUsername(auth.getUsername()) != null) {
			System.out.println("username");
			System.out.println(auth.getPassword());
			System.out.println(repo.selectbyUsername(auth.getUsername()).getPassword());
			if(repo.selectbyUsername(auth.getUsername()).getPassword().equals(auth.getPassword())) {
				System.out.println("Credentials ok");
				
				return SessionBuilder.setSession(Factory.userEntityToDTO(repo.selectbyUsername(auth.getUsername())));
			}
		}
		return null;
	}
	
	
	
}
