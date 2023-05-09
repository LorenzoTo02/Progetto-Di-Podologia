package com.lorenzoclarissa.podology.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.lorenzoclarissa.podology.authentication.Authentication;
import com.lorenzoclarissa.podology.authentication.Session;
import com.lorenzoclarissa.podology.service.UserServiceIMPL;

@RestController
@RequestMapping("/auth")
public class SessionController {

	@Autowired
	private UserServiceIMPL service;

	@ResponseBody
	@PostMapping
	public Session authenticate(@RequestBody Authentication auth) {
		System.out.println("--------Controller-------");
		try {
			return service.checkCredentials(auth);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
