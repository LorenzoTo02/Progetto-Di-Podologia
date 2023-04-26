package com.lorenzoclarissa.podology.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lorenzoclarissa.podology.entity.PatologyEnum;

public class PatologyDTO {

	private Long id;
	private LocalDate date;
	
	private PatologyEnum patology;
	
	@JsonIgnore
	private AnimalDTO animal;

	public PatologyDTO(Long id, LocalDate date, PatologyEnum patology, AnimalDTO animal) {
		this.id = id;
		this.date = date;
		this.patology = patology;
		this.animal = animal;
	}
	
	

	public PatologyDTO(PatologyEnum patology) {
		this.patology = patology;
	}



	public PatologyDTO() {
	}

	



	public PatologyDTO(Long id, LocalDate date, PatologyEnum patology) {
		super();
		this.id = id;
		this.date = date;
		this.patology = patology;
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

	public PatologyEnum getPatology() {
		return patology;
	}

	public void setPatology(PatologyEnum patology) {
		this.patology = patology;
	}

	public AnimalDTO getAnimal() {
		return animal;
	}

	public void setAnimal(AnimalDTO animal) {
		this.animal = animal;
	}
	
	
	
	
	
	
	
}
