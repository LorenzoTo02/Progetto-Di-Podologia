package com.lorenzoclarissa.podology.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.lorenzoclarissa.podology.model.AnimalDTO;
import com.lorenzoclarissa.podology.service.AgencyServiceIMPL;
import com.lorenzoclarissa.podology.service.AnimalServiceIMPL;

@RestController
@RequestMapping("/api/animal")
public class AnimalRestController {
	
	private Logger logger = LoggerFactory.getLogger(AnimalRestController.class);

	@Autowired
	private AnimalServiceIMPL service;
	
	@Autowired
	private AgencyServiceIMPL serviceAgency;
	
	@GetMapping
	public List<AnimalDTO> getAllAnimals(){
		logger.info("call GET all animals");
		return service.viewAll();
	}
	
	@GetMapping("/{id}")
	public AnimalDTO getById(@PathVariable("id") Long id) {
		logger.info("call GET animal by id");
		return service.viewById(id);
	}
	
	@GetMapping("/earTag/{earTag}")
	public AnimalDTO getByEarTag(@PathVariable("earTag") String earTag) {
		logger.info("call GET animal by earTag");
		return service.viewByEarTag(earTag);
	}
	
	@PostMapping("/agency") //?value=? localhost:9026/api/animal/agency?value=ID
	public void addAnimal(@RequestBody AnimalDTO animal, @RequestParam Long value) {
		animal.setAgency(serviceAgency.viewById(value));
		logger.info("call POST animal " + animal.getEarTag() + " in agency: " + serviceAgency.viewById(value).getName());
		service.addAnimal(animal, value);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		logger.info("call DELETE animal by id " + id);
		service.deleteAnimal(id);
	}
	
	@DeleteMapping("/earTag/{earTag}")
	public void deleteByEarTag(@PathVariable("earTag") String eartag) {
		logger.info("call DELETE animal by earTag: " + eartag);
		service.deleteAnimalByEarTag(eartag);
	}
	
	@GetMapping("/withPatologies")
	public List<AnimalDTO> getWithPatologies(){
		logger.info("call GET all animals with Patologies");
		return service.viewWithPatologies();
	}
	
	@GetMapping("/withNoPatologies")
	public List<AnimalDTO> getWithNoPatologies(){
		logger.info("call GET all with No Patologies");
		return service.viewWithNoPatologies();
	}
	
	@GetMapping("/patology")
	public List<AnimalDTO> getByPatology(@RequestParam String value){
		logger.info("call GET all animals with patology: " + value);
		return service.viewByPatolgyType(value);
	}

	@GetMapping("/agency/{id}")
	public List<AnimalDTO> getAnimalsByAgency(@PathVariable("id") Long id){
		return service.viewByAgency(id);
	}

	@GetMapping("/agency") //?id=ID&earTag=N
	public List<AnimalDTO> getAnimalBySixEarTag(@RequestParam(required = true) Long id, @RequestParam(required = true) String earTag){
		return service.viewByLastSixEarTag(earTag, id);
	}
	
	
}
