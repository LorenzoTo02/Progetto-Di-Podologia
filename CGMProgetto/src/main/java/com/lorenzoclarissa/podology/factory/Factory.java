package com.lorenzoclarissa.podology.factory;

import java.util.ArrayList;
import java.util.List;

import com.lorenzoclarissa.podology.entity.AgencyEntity;
import com.lorenzoclarissa.podology.entity.AnimalEntity;
import com.lorenzoclarissa.podology.entity.PatologyEntity;
import com.lorenzoclarissa.podology.entity.PatologyTypeEntity;
import com.lorenzoclarissa.podology.entity.UserEntity;
import com.lorenzoclarissa.podology.model.AgencyDTO;
import com.lorenzoclarissa.podology.model.AnimalDTO;
import com.lorenzoclarissa.podology.model.PatologyDTO;
import com.lorenzoclarissa.podology.model.PatologyTypeDTO;
import com.lorenzoclarissa.podology.model.UserDTO;

public class Factory {

	public static AnimalEntity animalDTOtoEntity(AnimalDTO animal) {
//		if(animal.getPatologies() == null) {
			AnimalEntity a = new AnimalEntity(animal.getId(), animal.getEarTag(), animal.getBirthday());
//			a.setAgency(Factory.agencyDtoToEntity(animal.getAgency()));
			return a;
//		} else {
//			AnimalEntity b = new AnimalEntity(animal.getId(), animal.getEarTag(), animal.getBirthday());
//			List<PatologyEntity> pEntity = new ArrayList<>();
//			for (PatologyDTO patology : animal.getPatologies()) {
//				pEntity.add(new PatologyEntity(patology.getDate(), patology.getPatology(), Factory.animalDTOtoEntity(patology.getAnimal())));
//			}
//			b.setPatology(pEntity);
//			return b;
//		}
		
		
	}
	
	public static AnimalDTO animalEntityToDTO(AnimalEntity animal) {
		List<PatologyEntity> patologyEntity = animal.getPatology();
		List<PatologyDTO> pDTO = new ArrayList<>();
		for (PatologyEntity patologyEntity2 : patologyEntity) {
			pDTO.add(new PatologyDTO(patologyEntity2.getId(), patologyEntity2.getDate(), patologyEntity2.getPatology()));
		}
		AnimalDTO a = new AnimalDTO();
		a.setId(animal.getId());
		a.setEarTag(animal.getEarTag());
		a.setBirthday(animal.getBirthdary());
		a.setPatologies(pDTO);
		if(animal.getDescription() != null) {
			a.setDescription(animal.getDescription());
		}
		if(animal.getAgency() != null) {
			AgencyDTO ag = new AgencyDTO();
			ag.setName(animal.getAgency().getName());
			ag.setId(animal.getAgency().getId());
			a.setAgency(ag); 
		} else {
			a.setAgency(null);
		}
		return a;
	}
	
	public static PatologyEntity patologyDTOtoEntity(PatologyDTO patology) {
		PatologyEntity e = new PatologyEntity(patology.getDate(), patology.getPatology(), Factory.animalDTOtoEntity(patology.getAnimal()));
		return e;
	}
	
	public static PatologyDTO patologyEntitytoDTO(PatologyEntity patology) {
		PatologyDTO p = new PatologyDTO(patology.getId(), patology.getDate(), patology.getPatology(), Factory.animalEntityToDTO(patology.getAnimal()));
		return p;
	}
	
	public static AgencyDTO agencyEntityToDTO(AgencyEntity agencyE) {
		AgencyDTO a = new AgencyDTO();
		a.setName(agencyE.getName());
		a.setId(agencyE.getId());
		List<AnimalDTO> animals = new ArrayList<>();
		List<PatologyDTO> patologyDTOs = new ArrayList<>();
		for (AnimalEntity animal : agencyE.getAnimals()) {
			AnimalDTO an = new AnimalDTO();
			an.setBirthday(animal.getBirthdary());
			an.setEarTag(animal.getEarTag());
			an.setId(animal.getId());
			
			for (PatologyEntity patology : animal.getPatology()) {
				PatologyDTO p = new PatologyDTO();
				p.setId(patology.getId());
				p.setPatology(patology.getPatology());
				p.setDate(patology.getDate());
				patologyDTOs.add(p);
			}
			an.setPatologies(patologyDTOs);
			animals.add(an);
		}
		a.setAnimals(animals);
		return a;
	}
	
	public static AgencyEntity agencyDtoToEntity(AgencyDTO agencyDTO) {
		AgencyEntity a = new AgencyEntity();
		a.setName(agencyDTO.getName());
		
//		List<AnimalEntity> animals = new ArrayList<>();
//		for (AnimalDTO animal : agencyDTO.getAnimals()) {
//			AnimalDTO an = new AnimalDTO();
//			an.setBirthday(animal.getBirthday());
//			an.setEarTag(animal.getEarTag());
////			an.setId(animal.getId());
//		}
//		a.setAnimals(animals);
		
		return a;
	}

	public static PatologyTypeEntity patDtoToEntity(PatologyTypeDTO patologyDTO){
		return new PatologyTypeEntity(patologyDTO.getName());
	}

	public static PatologyTypeDTO patEntityToDTO(PatologyTypeEntity patologyEntity){
		PatologyTypeDTO p = new PatologyTypeDTO(patologyEntity.getName());
		p.setId(patologyEntity.getId());
		return p;
	}
	
	public static UserEntity UserDTOtoUserEntity(UserDTO userDTO) {
		UserEntity userE = new UserEntity();
		userE.setUsername(userDTO.getUsername());
		userE.setRole(userDTO.getRole());
		return userE;
	}
	
	public static UserDTO userEntityToDTO(UserEntity userE) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(userE.getId());
		userDTO.setUsername(userE.getUsername());
		userDTO.setRole(userE.getRole());
		return userDTO;
	}
}
