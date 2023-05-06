package com.lorenzoclarissa.podology.service.serviceInterface;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lorenzoclarissa.podology.entity.PatologyHistory;
import com.lorenzoclarissa.podology.repository.PatologyHistoryRepository;

@Service
public class PatologyHistoryServiceIMPL implements PatologyHistoryService{

	@Autowired
	private PatologyHistoryRepository repo;
	
	@Override
	public List<PatologyHistory> viewAllByAnimal(Long id) {
		return repo.selectById(id);
	}

}
