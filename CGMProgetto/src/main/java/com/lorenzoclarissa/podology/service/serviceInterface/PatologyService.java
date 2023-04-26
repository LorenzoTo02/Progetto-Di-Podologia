package com.lorenzoclarissa.podology.service.serviceInterface;

import java.util.List;

import com.lorenzoclarissa.podology.model.AnimalDTO;
import com.lorenzoclarissa.podology.model.PatologyDTO;

public interface PatologyService {

	List<PatologyDTO> viewAll();
	PatologyDTO viewById(Long id);
	
	void addPatology(PatologyDTO patology);
	
	List<PatologyDTO> viewByAnimal(AnimalDTO animal);
	List<PatologyDTO> viewByAnimalId(Long id);
	List<PatologyDTO> viewByAnimalEarTag(String earTag);
	
	void update(PatologyDTO patology, Long id);
	
	void deleteById(Long id);
	
}
