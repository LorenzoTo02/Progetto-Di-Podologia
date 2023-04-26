package com.lorenzoclarissa.podology.service.serviceInterface;

import java.util.List;

import com.lorenzoclarissa.podology.model.AnimalDTO;

public interface AnimalService {

	List<AnimalDTO> viewAll();
	
	void addAnimal(AnimalDTO animal, Long id);
	void deleteAnimal(Long id);
	void deleteAnimalByEarTag(String earTag);
	
	AnimalDTO viewById(Long id);
	
	AnimalDTO viewByEarTag(String earTag); //Query custom
	
	List<AnimalDTO> viewWithPatologies();
	List<AnimalDTO> viewWithNoPatologies();
	
	List<AnimalDTO> viewByPatolgyType(String patology);

	List<AnimalDTO> viewByAgency(Long id);

	List<AnimalDTO> viewByLastSixEarTag(String earTagSix, Long id);
	
}
