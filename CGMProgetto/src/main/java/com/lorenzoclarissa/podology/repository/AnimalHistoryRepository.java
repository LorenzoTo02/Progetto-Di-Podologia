package com.lorenzoclarissa.podology.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lorenzoclarissa.podology.entity.AnimalHistory;

@Repository
public interface AnimalHistoryRepository extends JpaRepository<AnimalHistory, Long>{

}
