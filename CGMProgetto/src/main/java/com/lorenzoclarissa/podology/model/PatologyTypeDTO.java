package com.lorenzoclarissa.podology.model;

public class PatologyTypeDTO {
    
    private Long id;
    private String name;

    
    public PatologyTypeDTO() {
	}
    
    public PatologyTypeDTO (String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
