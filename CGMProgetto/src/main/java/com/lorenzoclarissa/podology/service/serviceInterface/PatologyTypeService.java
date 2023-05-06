package com.lorenzoclarissa.podology.service.serviceInterface;

import java.util.List;

import com.lorenzoclarissa.podology.model.PatologyTypeDTO;

public interface PatologyTypeService {
    
    List<PatologyTypeDTO> getAllPatologiesType();
    void addPatologyType(PatologyTypeDTO patology);
    void deletePatology(Long id);
}
