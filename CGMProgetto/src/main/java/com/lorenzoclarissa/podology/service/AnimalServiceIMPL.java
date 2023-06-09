package com.lorenzoclarissa.podology.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lorenzoclarissa.podology.controller.AnimalRestController;
import com.lorenzoclarissa.podology.entity.AnimalEntity;
import com.lorenzoclarissa.podology.entity.AnimalHistory;
import com.lorenzoclarissa.podology.entity.PatologyEntity;
import com.lorenzoclarissa.podology.factory.Factory;
import com.lorenzoclarissa.podology.model.AnimalDTO;
import com.lorenzoclarissa.podology.repository.AgencyRepository;
import com.lorenzoclarissa.podology.repository.AnimalHistoryRepository;
import com.lorenzoclarissa.podology.repository.AnimalRepository;
import com.lorenzoclarissa.podology.service.serviceInterface.AnimalService;

import jakarta.transaction.Transactional;

@Service
public class AnimalServiceIMPL implements AnimalService{

	private Logger logger = LoggerFactory.getLogger(AnimalServiceIMPL.class);
	
	@Autowired
	private AnimalRepository repo;
	@Autowired
	private AnimalHistoryRepository repoHistory;
	
	@Autowired
	private AgencyRepository repoAgency;

	@Override
	public List<AnimalDTO> viewAll() {
		List<AnimalEntity> aEntity = repo.findAll();
		List<AnimalDTO> aDTO = new ArrayList<>();
		for (AnimalEntity animalEntity : aEntity) {
			aDTO.add(Factory.animalEntityToDTO(animalEntity));
			logger.info("Obtained DTO animal " + animalEntity.getId());
		}
		logger.info("Obtained DTO animals list");
		return aDTO;
	}

	@Override
	public void addAnimal(AnimalDTO animal, Long id) {
		AnimalEntity a = Factory.animalDTOtoEntity(animal);
		AnimalHistory ah = new AnimalHistory();		
		a.setAgency(repoAgency.findById(id).get());
		repo.save(a);
		ah.setId(repo.selectByEarTag(a.getEarTag()).getId());
		ah.setEarTag(a.getEarTag());
		ah.setBirthday(a.getBirthdary());
		ah.setDescription(a.getDescription());
		ah.setAgency(a.getAgency().getName());
		System.out.println(ah.toString());
		repoHistory.save(ah);
	}

	@Override
	public AnimalDTO viewById(Long id) {
		
		try {
			AnimalEntity a = repo.findById(id).get();
			logger.info("animal DTO obtained" + a.getId());
			return Factory.animalEntityToDTO(a);
		} catch (RuntimeException e) {
			System.err.println("Animale non trovato" + e.getMessage());
			
		}
		return null;
		
	}

	@Override
	public AnimalDTO viewByEarTag(String earTag) {
		try {
			AnimalEntity animal = repo.selectByEarTag(earTag);
			logger.info("animal DTO obtained by eartag" + animal.getId() + " - " + animal.getEarTag());
			return Factory.animalEntityToDTO(animal);
		} catch (Exception e) {
			System.err.println("Animale non trovato per eartag");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<AnimalDTO> viewWithPatologies() {
		List<AnimalEntity> animals = repo.findAll();
		List<AnimalDTO> aDTOs = new ArrayList<>();
		
		for (AnimalEntity animal : animals) {
			if(!animal.getPatology().isEmpty()) {
				aDTOs.add(Factory.animalEntityToDTO(animal));
			}
		}
		logger.info("Obtained all animal DTO with patologies");
		return aDTOs;
	}

	@Override
	public List<AnimalDTO> viewWithNoPatologies() {
		List<AnimalEntity> animals = repo.findAll();
		List<AnimalDTO> aDTOs = new ArrayList<>();
		
		for (AnimalEntity animal : animals) {
			if(animal.getPatology().isEmpty()) {
				aDTOs.add(Factory.animalEntityToDTO(animal));
			}
		}
		logger.info("Obtained all animal DTO with NO patologies");
		return aDTOs;
	}

	@Override
	public List<AnimalDTO> viewByPatolgyType(String patology) {
		List<AnimalEntity> animals = repo.findAll();
		List<AnimalDTO> aDTOs = new ArrayList<>();
		for (AnimalEntity animalEntity : animals) {
			List<PatologyEntity> patologies = animalEntity.getPatology();
			for (PatologyEntity patologyEntity : patologies) {
				if(patologyEntity.getPatology().toString().equals(patology)) {
					aDTOs.add(Factory.animalEntityToDTO(animalEntity));
				}
			}
		}
		logger.info("Obtained all animal DTO with patology = " + patology);
		return aDTOs;
		

	}

	@Override
	public void deleteAnimal(Long id, String motivation) {
		if(repo.findById(id).isEmpty()) {
			logger.warn("Try to delete by id a non-existing animal - " + id);
		} else {
			
			AnimalHistory a = repoHistory.findById(id).get();
			a.setRemovalDate(LocalDate.now());
			a.setMotivation(motivation);
			repoHistory.save(a);
			repo.deleteById(id);
			logger.info("Deleted animal entity ID: " + id);
		}
		
	}

	@Override
	public void deleteAnimalByEarTag(String earTag) {
		
		if(repo.selectByEarTag(earTag) != null) {
			logger.warn("Try to delete by earTag a non-existing animal - " + earTag);
		} else {
			AnimalEntity a = repo.selectByEarTag(earTag);
			repo.deleteById(a.getId());
			logger.info("Deleted animal entity EARTAG: " + earTag);
		}
		
		
	}

	@Override
	public List<AnimalDTO> viewByAgency(Long id) {
		List<AnimalEntity> animalEntity = repo.selectByAgencyId(id);
		List<AnimalDTO> aDTOs = new ArrayList<>();
		for (AnimalEntity animal : animalEntity) {
			aDTOs.add(Factory.animalEntityToDTO(animal));
		}
		return aDTOs;
	}

	@Override
	public List<AnimalDTO> viewByLastSixEarTag(String earTagSix, Long id) {
		String regex = earTagSix + "$";
		List<AnimalEntity> animalsE = repo.selectByAgencyAndEarTag(id, regex);
		List<AnimalDTO> aDTOs = new ArrayList<>();
		for (AnimalEntity animalE : animalsE) {
			aDTOs.add(Factory.animalEntityToDTO(animalE));
		}

		return aDTOs;
	}

	@Override
	public void addDescription(String description, Long id) {
		AnimalEntity a = repo.findById(id).get();
		a.setDescription(description);
		repo.save(a);
	}

	@Override
	public String viewDescription(Long id) {
		if(repo.findById(id).get().getDescription() != null) {
			return repo.findById(id).get().getDescription();
		}
		return null;
			
	}
	
	
	
}
