package com.lorenzoclarissa.podology.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lorenzoclarissa.podology.model.AgencyDTO;
import com.lorenzoclarissa.podology.service.AgencyServiceIMPL;

@RestController
@RequestMapping("/api/agency")
public class AgencyRestController {

	private Logger logger = LoggerFactory.getLogger(AgencyRestController.class);
	
	@Autowired
	private AgencyServiceIMPL service;
	
	@GetMapping
	public List<AgencyDTO> getAll(){
		logger.info("call GET all agency");
		return service.viewAll();
	}
	
	@GetMapping("/{id}")
	public AgencyDTO getById(@PathVariable("id") Long id) {
		logger.info("call GET agency by ID: " + id);
		return service.viewById(id);
	}
	
	@PostMapping
	public void addAgency(@RequestBody AgencyDTO agency) {
		logger.info("call POST add agency named: " + agency.getName());
		service.addAgency(agency);
	}

	@DeleteMapping("/{id}")
	public void deleteAgency(@PathVariable("id") Long id){
		logger.info("call DELETE agency by id: " + id);
		service.deleteAgency(id);
	}
	
}
