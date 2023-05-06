package com.lorenzoclarissa.podology.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "AnimalsHistory", uniqueConstraints = {
		@UniqueConstraint(columnNames = "earTag")
		})
public class AnimalHistory implements Serializable{

	@Id
	private Long id;
	@Column(name = "earTag", columnDefinition = "varchar(16)")
	private String earTag;
	@Column(name = "birthdate", columnDefinition = "date")
	private LocalDate birthday;
	@Column(name = "free_section", columnDefinition = "varchar(250)")
	private String description;
	@Column(name = "removal_date", columnDefinition = "date")
	private LocalDate removalDate;
	@Column(name = "motivation", columnDefinition = "varchar(100)")
	private String motivation;
	@Column(name = "agencyName")
	private String agency;
	
	@OneToMany(mappedBy = "animal", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<PatologyHistory> patologies;
	
	public AnimalHistory() {
	}

	public AnimalHistory(Long id, String earTag, LocalDate birthday, String description) {
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

	public List<PatologyHistory> getPatologies() {
		return patologies;
	}

	public void setPatologies(List<PatologyHistory> patologies) {
		this.patologies = patologies;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AnimalHistory [id=");
		builder.append(id);
		builder.append(", earTag=");
		builder.append(earTag);
		builder.append(", birthday=");
		builder.append(birthday);
		builder.append(", description=");
		builder.append(description);
		builder.append(", removalDate=");
		builder.append(removalDate);
		builder.append(", motivation=");
		builder.append(motivation);
		builder.append(", agency=");
		builder.append(agency);
		builder.append(", patologies=");
		builder.append(patologies);
		builder.append("]");
		return builder.toString();
	}

	
	
	
	
	
	
	
	
	

	
}

