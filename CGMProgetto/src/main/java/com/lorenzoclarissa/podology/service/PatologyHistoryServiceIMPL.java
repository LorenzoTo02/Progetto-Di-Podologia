package com.lorenzoclarissa.podology.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lorenzoclarissa.podology.entity.PatologyHistory;
import com.lorenzoclarissa.podology.repository.PatologyHistoryRepository;
import com.lorenzoclarissa.podology.service.serviceInterface.PatologyHistoryService;

@Service
public class PatologyHistoryServiceIMPL implements PatologyHistoryService{

	@Autowired
	private PatologyHistoryRepository repo;
	
	@Override
	public List<PatologyHistory> viewAllByAnimal(Long id) {
		return repo.selectById(id);
	}

}
