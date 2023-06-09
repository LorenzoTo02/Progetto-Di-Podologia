package com.lorenzoclarissa.podology.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lorenzoclarissa.podology.entity.AgencyEntity;

@Repository
public interface AgencyRepository extends JpaRepository<AgencyEntity, Long>{

}
