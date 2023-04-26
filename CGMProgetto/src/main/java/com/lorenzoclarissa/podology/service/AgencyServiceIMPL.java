package com.lorenzoclarissa.podology.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lorenzoclarissa.podology.controller.AnimalRestController;
import com.lorenzoclarissa.podology.entity.AgencyEntity;
import com.lorenzoclarissa.podology.factory.Factory;
import com.lorenzoclarissa.podology.model.AgencyDTO;
import com.lorenzoclarissa.podology.repository.AgencyRepository;
import com.lorenzoclarissa.podology.service.serviceInterface.AgencyService;

@Service
public class AgencyServiceIMPL implements AgencyService{

	private Logger logger = LoggerFactory.getLogger(AgencyServiceIMPL.class);
	
	@Autowired
	private AgencyRepository repo;

	@Override
	public List<AgencyDTO> viewAll() {
		List<AgencyDTO> aDTO = new ArrayList<>();
		for (AgencyEntity agency : repo.findAll()) {
			aDTO.add(Factory.agencyEntityToDTO(agency));
			logger.info("added DTO agency to list DTO ID: " + agency.getId());
		}
		logger.info("list agency DTO created");
		return aDTO;
	}

	@Override
	public AgencyDTO viewById(Long id) {
		logger.info("obtained agency DTO with ID: " + id);
		return Factory.agencyEntityToDTO(repo.findById(id).get());
	}

	@Override
	public void addAgency(AgencyDTO agency) {
		logger.info("created agency DTO");
		repo.save(Factory.agencyDtoToEntity(agency));
	}
	
	
	
}
