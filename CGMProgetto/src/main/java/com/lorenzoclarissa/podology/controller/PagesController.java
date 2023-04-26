package com.lorenzoclarissa.podology.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class PagesController {
    
    @GetMapping
    public String home(){
        return "index";
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

}
