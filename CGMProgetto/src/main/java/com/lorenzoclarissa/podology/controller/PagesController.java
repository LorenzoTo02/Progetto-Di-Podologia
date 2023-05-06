package com.lorenzoclarissa.podology.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lorenzoclarissa.podology.autoPodology.PodologyVerify;

@Controller
@RequestMapping("")
public class PagesController {
    
	@Autowired
	private PodologyVerify verify;
	
    @GetMapping
    public String home(){
    	try {
			verify.run();
			return "index";
		} catch (Exception e) {
			e.printStackTrace();
			return "index";
		}
    }

    @GetMapping("/companies")
    public String companiesPage(){
        return "agencyList";
    }

    @GetMapping("/companies/agency")
    public String singleAgencyPage(){
        return "agencyPage";
    }

    @GetMapping("/companies/agency/list")
    public String listAnimal(){
        return "animalList";
    }

    @GetMapping("/companies/agency/animal")
    public String animalPage(){
        return "animal";
    }

    @GetMapping("/companies/agency/animal/medical")
    public String medicalRecordsPage(){
        return "animalrecords";
    }

    @GetMapping("/newagency")
    public String addAgencyPage(){
        return "agencyAdd";
    }
    
    @GetMapping("/admin")
    public String adminPage() {
    	return "adminPage";
    }
    
    @GetMapping("/admin/patology")
    public String addPatology() {
    	return "patologyTypeAdd";
    }
    
    @GetMapping("/admin/patologies")
    public String getPatologies() {
    	return "patologies";
    }

}
