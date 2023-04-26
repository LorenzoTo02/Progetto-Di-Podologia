package com.lorenzoclarissa.podology.service.serviceInterface;

import java.util.List;

import com.lorenzoclarissa.podology.model.AgencyDTO;

public interface AgencyService {

	List<AgencyDTO> viewAll();
	AgencyDTO viewById(Long id);
	void addAgency(AgencyDTO agency);
	
}
