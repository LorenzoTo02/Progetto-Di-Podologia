package com.lorenzoclarissa.podology.service.serviceInterface;

import java.util.List;

import com.lorenzoclarissa.podology.entity.PatologyHistory;

public interface PatologyHistoryService {

	List<PatologyHistory> viewAllByAnimal(Long id);
	
}
