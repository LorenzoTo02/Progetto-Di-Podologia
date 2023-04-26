package com.lorenzoclarissa.podology.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lorenzoclarissa.podology.entity.PatologyEntity;

@Repository
public interface PatologyRepository extends JpaRepository<PatologyEntity, Long>{

}
