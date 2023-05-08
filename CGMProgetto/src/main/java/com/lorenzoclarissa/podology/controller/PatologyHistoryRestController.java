package com.lorenzoclarissa.podology.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lorenzoclarissa.podology.entity.PatologyHistory;
import com.lorenzoclarissa.podology.service.PatologyHistoryServiceIMPL;

@RestController
@RequestMapping("/api/historyPatology")
public class PatologyHistoryRestController {

	@Autowired
	private PatologyHistoryServiceIMPL service;
	
	@GetMapping("/{id}")
	public List<PatologyHistory> viewAll(@PathVariable("id") Long id){
		return service.viewAllByAnimal(id);
	}
	
}
