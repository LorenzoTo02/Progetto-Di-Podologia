package com.lorenzoclarissa.podology.model;

import java.time.LocalDate;
import com.lorenzoclarissa.podology.entity.AnimalHistory;

public class PatologyHistoryDTO {

	private Long id;
	private LocalDate date;
	private String patology;
	private LocalDate healingDate;
	
	private AnimalHistoryDTO animal;
	
	public PatologyHistoryDTO(LocalDate date, String patology, AnimalHistoryDTO animal) {
		this.date = date;
		this.patology = patology;
		this.animal = animal;
	}
	
	public PatologyHistoryDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getPatology() {
		return patology;
	}

	public void setPatology(String patology) {
		this.patology = patology;
	}

	public LocalDate getHealingDate() {
		return healingDate;
	}

	public void setHealingDate(LocalDate healingDate) {
		this.healingDate = healingDate;
	}

	public AnimalHistoryDTO getAnimal() {
		return animal;
	}

	public void setAnimal(AnimalHistoryDTO animal) {
		this.animal = animal;
	}
	
	

	
}
