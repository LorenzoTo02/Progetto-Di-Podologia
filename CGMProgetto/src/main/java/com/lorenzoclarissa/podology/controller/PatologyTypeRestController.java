package com.lorenzoclarissa.podology.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lorenzoclarissa.podology.model.PatologyTypeDTO;
import com.lorenzoclarissa.podology.service.PatologyTypeServiceIMPL;

@RestController
@RequestMapping("/api/patologyType")
public class PatologyTypeRestController {

	@Autowired
	private PatologyTypeServiceIMPL service;
	
	@GetMapping
	public List<PatologyTypeDTO> viewAll(){
		return service.getAllPatologiesType();
	}
	
	@PostMapping
	public void addNewPatologyType(@RequestBody PatologyTypeDTO patologyType) {
		service.addPatologyType(patologyType);
	}
	
	@DeleteMapping
	public void deletePatologyById(@RequestParam Long id) {
		service.deletePatology(id);
	}
}
