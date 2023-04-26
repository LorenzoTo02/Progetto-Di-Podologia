package com.lorenzoclarissa.podology.resources;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lorenzoclarissa.podology.entity.PatologyEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

public class PatologyResources implements Serializable{

	private Long id;
	private LocalDate date;
	private PatologyEnum patology;
	
	private AnimalResource animal;
	
	public PatologyResources(LocalDate date, PatologyEnum patology, AnimalResource animal) {
		this.date = date;
		this.patology = patology;
		this.animal = animal;
	}
	
	public PatologyResources() {
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

	public Long getId() {
		return id;
	}

	public AnimalResource getAnimal() {
		return animal;
	}

	public void setAnimal(AnimalResource animal) {
		this.animal = animal;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PatologyEntity [id=");
		builder.append(id);
		builder.append(", date=");
		builder.append(date);
		builder.append(", patology=");
		builder.append(patology);
		builder.append(", animal=");
		builder.append(animal);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
	
	
	
	
}
