package com.lorenzoclarissa.podology.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
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
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "AnimalsCGM", uniqueConstraints = {
		@UniqueConstraint(columnNames = "earTag")
		})
public class AnimalEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "earTag", columnDefinition = "varchar(16)")
	private String earTag;
	@Column(name = "birthdate", columnDefinition = "date")
	private LocalDate birthday;
	@Column(name = "free_section", columnDefinition = "varchar(250)")
	private String description;
	
	@OneToMany(mappedBy = "animal", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<PatologyEntity> patologies;
	
	@ManyToOne
	@JoinColumn(name = "agency_fk")
	private AgencyEntity agency;
	
	public AnimalEntity(String earTag, LocalDate birthdary) {
		this.earTag = earTag;
		this.birthday = birthdary;
		this.patologies = new ArrayList<>();
	}
	
	public AnimalEntity(Long id, String earTag, LocalDate birthday, List<PatologyEntity> patologies) {
		this.id = id;
		this.earTag = earTag;
		this.birthday = birthday;
		this.patologies = patologies;
	}

	public AnimalEntity(Long id, String earTag, LocalDate birthday) {
		this.id = id;
		this.earTag = earTag;
		this.birthday = birthday;
	}

	public AnimalEntity() {
	}

	public String getEarTag() {
		return earTag;
	}

	public void setEarTag(String earTag) {
		this.earTag = earTag;
	}

	public LocalDate getBirthdary() {
		return birthday;
	}

	public void setBirthdary(LocalDate birthdary) {
		this.birthday = birthdary;
	}

	public List<PatologyEntity> getPatology() {
		return patologies;
	}

	public void setPatology(List<PatologyEntity> patologies) {
		this.patologies = patologies;
	}

	public Long getId() {
		return id;
	}
	
	public AgencyEntity getAgency() {
		return agency;
	}

	public void setAgency(AgencyEntity agency) {
		this.agency = agency;
	}
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AnimalEntity [id=");
		builder.append(id);
		builder.append(", earTag=");
		builder.append(earTag);
		builder.append(", birthday=");
		builder.append(birthday);
		builder.append(", patologies=");
//		builder.append(patologies);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
	
	
	
}
