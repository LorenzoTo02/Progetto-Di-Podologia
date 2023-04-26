package com.lorenzoclarissa.podology.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lorenzoclarissa.podology.entity.AnimalEntity;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalEntity, Long>{

	@Query("SELECT a FROM AnimalEntity a WHERE a.earTag = :eartag")
	public AnimalEntity selectByEarTag(@Param("eartag") String earTag);
	
	@Query("SELECT a FROM AnimalEntity a WHERE a.agency.id = :idAgency")
	public List<AnimalEntity> selectByAgencyId(@Param("idAgency") Long id);

	@Query(value = "select * from animalscgm a where a.agency_fk = :idAgency AND (a.ear_tag REGEXP :eartag)", nativeQuery = true)
	public List<AnimalEntity> selectByAgencyAndEarTag(@Param("idAgency") Long id, @Param("eartag") String earTag);
}
