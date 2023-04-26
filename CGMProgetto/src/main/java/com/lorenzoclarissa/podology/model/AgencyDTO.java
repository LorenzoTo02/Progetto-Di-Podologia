package com.lorenzoclarissa.podology.model;

import java.util.ArrayList;
import java.util.List;

public class AgencyDTO {

	private Long id;
	private String name;
	
	private List<AnimalDTO> animals;

	public AgencyDTO(String name) {		
		this.name = name;
		this.animals = new ArrayList<>();
	}
	
	public AgencyDTO() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AnimalDTO> getAnimals() {
		return animals;
	}

	public void setAnimals(List<AnimalDTO> animals) {
		this.animals = animals;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
