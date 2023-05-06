package com.lorenzoclarissa.podology.entity;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "patologiesHistory")
public class PatologyHistory implements Serializable{

	@Id
	private Long id;
	@Column(columnDefinition = "date")
	private LocalDate date;
	@Column(name = "name_patology", columnDefinition = "varchar(255)")
	private String patology;
	@Column(name = "healing_date", columnDefinition = "date")
	private LocalDate healingDate;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patology_fk")
	private AnimalHistory animal;
	
	public PatologyHistory(LocalDate date, String patology, AnimalHistory animal) {
		this.date = date;
		this.patology = patology;
		this.animal = animal;
	}
	
	public PatologyHistory() {
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

	public AnimalHistory getAnimal() {
		return animal;
	}

	public void setAnimal(AnimalHistory animal) {
		this.animal = animal;
	}

	public LocalDate getHealingDate() {
		return healingDate;
	}

	public void setHealingDate(LocalDate healingDate) {
		this.healingDate = healingDate;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
