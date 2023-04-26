package com.lorenzoclarissa.podology.resources;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AnimalResource implements Serializable{

	private Long id;
	private String earTag;
	private LocalDate birthday;
	
	private List<PatologyResources> patologies;
	
	public AnimalResource(String earTag, LocalDate birthdary) {
		this.earTag = earTag;
		this.birthday = birthdary;
		this.patologies = new ArrayList<>();
	}
	
	public AnimalResource(Long id, String earTag, LocalDate birthday, List<PatologyResources> patologies) {
		this.id = id;
		this.earTag = earTag;
		this.birthday = birthday;
		this.patologies = patologies;
	}

	


	public AnimalResource(Long id, String earTag, LocalDate birthday) {
		this.id = id;
		this.earTag = earTag;
		this.birthday = birthday;
	}

	public AnimalResource() {
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

	public List<PatologyResources> getPatology() {
		return patologies;
	}

	public void setPatology(List<PatologyResources> patologies) {
		this.patologies = patologies;
	}

	public Long getId() {
		return id;
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
		builder.append(patologies);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
	
	
	
}
