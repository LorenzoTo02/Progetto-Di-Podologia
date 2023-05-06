package com.lorenzoclarissa.podology.model;

import java.time.LocalDate;
import java.util.List;
import com.lorenzoclarissa.podology.entity.PatologyEntity;

public class AnimalHistoryDTO {
	
	private Long id;
	private String earTag;
	private LocalDate birthday;
	private String description;
	private LocalDate removalDate;
	private String motivation;
	private String agency;
	
	private List<PatologyHistoryDTO> patologies;
	
	public AnimalHistoryDTO() {
	}

	public AnimalHistoryDTO(Long id, String earTag, LocalDate birthday, String description) {
		this.id = id;
		this.earTag = earTag;
		this.birthday = birthday;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getRemovalDate() {
		return removalDate;
	}

	public void setRemovalDate(LocalDate removalDate) {
		this.removalDate = removalDate;
	}

	public String getMotivation() {
		return motivation;
	}

	public void setMotivation(String motivation) {
		this.motivation = motivation;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public List<PatologyHistoryDTO> getPatologies() {
		return patologies;
	}

	public void setPatologies(List<PatologyHistoryDTO> patologies) {
		this.patologies = patologies;
	}
}
