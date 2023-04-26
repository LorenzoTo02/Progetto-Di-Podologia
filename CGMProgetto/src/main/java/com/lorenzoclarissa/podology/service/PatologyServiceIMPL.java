package com.lorenzoclarissa.podology.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lorenzoclarissa.podology.entity.AnimalEntity;
import com.lorenzoclarissa.podology.entity.PatologyEntity;
import com.lorenzoclarissa.podology.factory.Factory;
import com.lorenzoclarissa.podology.model.AnimalDTO;
import com.lorenzoclarissa.podology.model.PatologyDTO;
import com.lorenzoclarissa.podology.repository.PatologyRepository;
import com.lorenzoclarissa.podology.service.serviceInterface.PatologyService;

@Service
public class PatologyServiceIMPL implements PatologyService {

	private Logger logger = LoggerFactory.getLogger(PatologyServiceIMPL.class);
	
	@Autowired
	private PatologyRepository repo;
	
	@Override
	public List<PatologyDTO> viewAll() {
//		System.out.println(repo.findAll().get(7).toString());
		List<PatologyEntity> patologies = repo.findAll();
		
		List<PatologyDTO> pDTOs = new ArrayList<>();
		
		for (PatologyEntity patologyEntity : patologies) {
			pDTOs.add(Factory.patologyEntitytoDTO(patologyEntity));
			logger.info("patology added at DTO list with ID: " + patologyEntity.getId());
		}
		
		logger.info("patology DTO list created");
		return pDTOs;
	}

	@Override
	public PatologyDTO viewById(Long id) {
		logger.info("obtained patology DTO with ID: " + id);
		return Factory.patologyEntitytoDTO(repo.findById(id).get());
	}

	@Override
	public void addPatology(PatologyDTO patology) {
		repo.save(Factory.patologyDTOtoEntity(patology));
	}

	@Override
	public List<PatologyDTO> viewByAnimal(AnimalDTO animal) {
		List<PatologyEntity> pEntity = repo.findAll();
		List<PatologyDTO> pDTOs = new ArrayList<>();
		AnimalEntity animalToCompare = Factory.animalDTOtoEntity(animal);
		for (PatologyEntity patologyEntity : pEntity) {		
			if(patologyEntity.getAnimal().equals(animalToCompare)) {
				pDTOs.add(Factory.patologyEntitytoDTO(patologyEntity));
				logger.info("list add patology DTO with ID: " + patologyEntity.getId());
			}
		}
		logger.info("list patology DTO created");
		return pDTOs;
	}

	@Override
	public List<PatologyDTO> viewByAnimalId(Long id) {
		List<PatologyEntity> pEntity = repo.findAll();
		List<PatologyDTO> pDTOs = new ArrayList<>();
		for (PatologyEntity patologyEntity : pEntity) {		
			if(patologyEntity.getAnimal().getId().equals(id)) {
				pDTOs.add(Factory.patologyEntitytoDTO(patologyEntity));
				logger.info("add patology in list with ID: " + patologyEntity.getId());
			}
		}
		logger.info("list patology DTO created");
		return pDTOs;
	}

	@Override
	public List<PatologyDTO> viewByAnimalEarTag(String earTag) {
		List<PatologyEntity> pEntity = repo.findAll();
		List<PatologyDTO> pDTOs = new ArrayList<>();
		for (PatologyEntity patologyEntity : pEntity) {		
			if(patologyEntity.getAnimal().getEarTag().equals(earTag)) {
				pDTOs.add(Factory.patologyEntitytoDTO(patologyEntity));
				logger.info("add patology in list with ID: " + patologyEntity.getId());
			}
		}
		logger.info("list dto patology created with animal earTag: " + earTag);
		return pDTOs;
	}

	@Override
	public void update(PatologyDTO patology, Long id) {
		patology.setId(id);
		PatologyEntity p = repo.findById(id).get();
		p.setPatology(patology.getPatology());
		repo.save(p);
		logger.info("update DTO and entity of patology: " + patology.getPatology() + " with ID: " + id);
	}

	@Override
	public void deleteById(Long id) {
		repo.deleteById(id);
		logger.info("deleted patology ID: " + id);
	}

}
