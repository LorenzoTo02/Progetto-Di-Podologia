package com.lorenzoclarissa.podology.model;

import java.time.LocalDate;
import java.util.List;


public class AnimalDTO {

	private Long id;
	private String earTag;
	private LocalDate birthday;	
	private List<PatologyDTO> patologies;
	private String description;
	
	// @JsonIgnore
	private AgencyDTO agency;
	
	public AnimalDTO(Long id, String earTag, LocalDate birthday, List<PatologyDTO> patologies, AgencyDTO agency) {
		this.id = id;
		this.earTag = earTag;
		this.birthday = birthday;
		this.patologies = patologies;
		this.agency = agency;
	}
	
	public AnimalDTO(String earTag, LocalDate birthday) {
		this.earTag = earTag;
		this.birthday = birthday;
	}
	
	

	public AnimalDTO(Long id, String earTag, LocalDate birthday) {
		this.id = id;
		this.earTag = earTag;
		this.birthday = birthday;
	}

	public AnimalDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEarTag() {
		return earTag;
	}

	public void setEarTag(String earTag) {
		this.earTag = earTag;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public List<PatologyDTO> getPatologies() {
		return patologies;
	}

	public void setPatologies(List<PatologyDTO> patologies) {
		this.patologies = patologies;
	}
	
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AgencyDTO getAgency() {
		return agency;
	}

	public void setAgency(AgencyDTO agency) {
		this.agency = agency;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AnimalDTO [id=");
		builder.append(id);
		builder.append(", earTag=");
		builder.append(earTag);
		builder.append(", birthday=");
		builder.append(birthday);
		builder.append(", patologies=");
		builder.append(patologies);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
}
