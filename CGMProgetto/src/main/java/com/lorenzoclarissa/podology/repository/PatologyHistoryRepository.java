package com.lorenzoclarissa.podology.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.lorenzoclarissa.podology.entity.PatologyHistory;

@Repository
public interface PatologyHistoryRepository extends JpaRepository<PatologyHistory, Long>{

	@Query("SELECT p From PatologyHistory p WHERE p.animal.id = :id")
	public List<PatologyHistory> selectById(@Param("id") Long id);
	
}
