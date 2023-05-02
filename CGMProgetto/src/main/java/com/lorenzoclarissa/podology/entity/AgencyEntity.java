package com.lorenzoclarissa.podology.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "agencycgm")
public class AgencyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "agencyName")
	private String name;
	
	@OneToMany(mappedBy = "agency", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<AnimalEntity> animals;

	public AgencyEntity(String name) {		
		this.name = name;
		this.animals = new ArrayList<>();
	}
	
	public AgencyEntity() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AnimalEntity> getAnimals() {
		return animals;
	}

	public void setAnimals(List<AnimalEntity> animals) {
		this.animals = animals;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AgencyEntity [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", animals=");
		builder.append(animals);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
}
