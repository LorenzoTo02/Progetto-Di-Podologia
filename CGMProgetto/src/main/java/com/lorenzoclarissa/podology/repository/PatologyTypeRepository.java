package com.lorenzoclarissa.podology.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lorenzoclarissa.podology.entity.PatologyTypeEntity;

@Repository
public interface PatologyTypeRepository extends JpaRepository<PatologyTypeEntity, Long>{
    
}
