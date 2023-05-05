package com.lorenzoclarissa.podology.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lorenzoclarissa.podology.entity.PatologyTypeEntity;
import com.lorenzoclarissa.podology.factory.Factory;
import com.lorenzoclarissa.podology.model.PatologyTypeDTO;
import com.lorenzoclarissa.podology.repository.PatologyTypeRepository;
import com.lorenzoclarissa.podology.service.serviceInterface.PatologyTypeService;

@Service
public class PatologyTypeServiceIMPL implements PatologyTypeService{

	@Autowired
	private PatologyTypeRepository repo;
	
	@Override
	public List<PatologyTypeDTO> getAllPatologiesType() {
		List<PatologyTypeDTO> pDTO = new ArrayList<>();
		List<PatologyTypeEntity> pEntity = repo.findAll();
		for (PatologyTypeEntity patologyTypeEntity : pEntity) {
			pDTO.add(Factory.patEntityToDTO(patologyTypeEntity));
		}
		return pDTO;
	}

	@Override
	public void addPatologyType(PatologyTypeDTO patology) {
		repo.save(Factory.patDtoToEntity(patology));
	}

}
