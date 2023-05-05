package com.lorenzoclarissa.podology.entity;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

@Entity
@Table(name = "patologiesCGM")
public class PatologyEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "date")
	private LocalDate date;
	@Column(name = "name_patology", columnDefinition = "varchar(255)")
	private String patology;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patology_fk")
	private AnimalEntity animal;
	
	public PatologyEntity(LocalDate date, String patology, AnimalEntity animal) {
		this.date = date;
		this.patology = patology;
		this.animal = animal;
	}
	
	public PatologyEntity() {
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

	public Long getId() {
		return id;
	}

	public AnimalEntity getAnimal() {
		return animal;
	}

	public void setAnimal(AnimalEntity animal) {
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
