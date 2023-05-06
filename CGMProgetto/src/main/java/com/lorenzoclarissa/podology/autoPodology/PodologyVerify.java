package com.lorenzoclarissa.podology.autoPodology;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lorenzoclarissa.podology.entity.PatologyEntity;
import com.lorenzoclarissa.podology.entity.PatologyHistory;
import com.lorenzoclarissa.podology.repository.AnimalHistoryRepository;
import com.lorenzoclarissa.podology.repository.PatologyHistoryRepository;
import com.lorenzoclarissa.podology.repository.PatologyRepository;

@Component
public class PodologyVerify implements Runnable{

	@Autowired
	private PatologyRepository repo;
	@Autowired
	private PatologyHistoryRepository repoHistory;
	@Autowired
	private AnimalHistoryRepository repoAnimal;
	
	// DUE MESI IN Ms = 5259600000L
	
	@Override
	public void run() {
		if(repo.findAll() != null) {

		for (PatologyEntity patologyEntity : repo.findAll()) {
			ZonedDateTime time = ZonedDateTime.of(LocalDateTime.of(patologyEntity.getDate(), LocalTime.MIN), ZoneId.systemDefault());
			ZonedDateTime now = ZonedDateTime.now();
			
			if((now.toInstant().toEpochMilli() - time.toInstant().toEpochMilli()) >= 52) {			
				PatologyHistory p = new PatologyHistory();
				p.setId(patologyEntity.getId());
				p.setDate(patologyEntity.getDate());
				p.setAnimal(repoAnimal.findById(patologyEntity.getAnimal().getId()).get());
				p.setPatology(patologyEntity.getPatology());
				p.setHealingDate(LocalDate.now());
				repoHistory.save(p);
				repo.delete(patologyEntity);
				
			}
			
			
			}
		}
	}

}
