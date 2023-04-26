package com.lorenzoclarissa.podology.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lorenzoclarissa.podology.entity.PatologyEntity;
import com.lorenzoclarissa.podology.factory.Factory;
import com.lorenzoclarissa.podology.model.AnimalDTO;
import com.lorenzoclarissa.podology.model.PatologyDTO;
import com.lorenzoclarissa.podology.repository.AnimalRepository;
import com.lorenzoclarissa.podology.service.AnimalServiceIMPL;
import com.lorenzoclarissa.podology.service.PatologyServiceIMPL;

@RestController
@RequestMapping("/api/patology")
public class PatologyRestController {

	private Logger logger = LoggerFactory.getLogger(PatologyRestController.class);
	
	@Autowired
	private PatologyServiceIMPL service;
	
	@Autowired
	private AnimalServiceIMPL serviceAnimal;
	
	
	@GetMapping
	public List<PatologyDTO> getAll(){
		logger.info("call GET all patologies");
		return service.viewAll();
	}
	
	@GetMapping("/{id}")
	public PatologyDTO getById(@PathVariable("id") Long id) {
		logger.info("call GET patology by ID: " + id);
		return service.viewById(id);
	}
	
	@PostMapping("/animal/{id}")
	public void addPatology(@RequestBody PatologyDTO patology, @PathVariable("id") Long id) {
		AnimalDTO a = serviceAnimal.viewById(id);
		patology.setAnimal(a);
		patology.setDate(LocalDate.now());
		logger.info("call POST add patology ad animal ID: " + id);
		service.addPatology(patology);
	}
	
	@GetMapping("/animal/{id}")
	public List<PatologyDTO> getByAnimal(@PathVariable("id") Long id){
		logger.info("call GET all patologies by animal ID: " + id);
		return service.viewByAnimalId(id);
	}
	
	@GetMapping("/animal/eartag/{earTag}")
	public List<PatologyDTO> getByAnimal(@PathVariable("earTag") String earTag){
		logger.info("call GET all patologies by animal earTag: " + earTag);
		return service.viewByAnimalEarTag(earTag);
	}
	
	@PutMapping("/{animal}")
	public void updatePatology(@RequestBody PatologyDTO patology, @RequestParam Long id, @PathVariable("animal") Long animal) {
		PatologyDTO p = new PatologyDTO();
		p.setPatology(patology.getPatology());
		p.setAnimal(serviceAnimal.viewById(id));
		logger.info("call PUT update patology at animal ID: " + id);
		service.update(patology, id);
	}
	
	@DeleteMapping("/{id}")
	public void deletePatologyById(@PathVariable("id") Long id) {
		logger.info("call DELETE patology by ID: " + id);
		service.deleteById(id);
	}
	
	
}
