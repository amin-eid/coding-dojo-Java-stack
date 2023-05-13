package com.axsos.onemany.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.axsos.onemany.models.Dojo;
import com.axsos.onemany.models.Ninja;
import com.axsos.onemany.services.AppService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import jakarta.validation.Valid;



@Controller
public class AppController {
	private final AppService appService;
    public AppController(AppService appService){
        this.appService = appService;
    }
    
    
    @RequestMapping("/")
    public String index0(Model model) {
    	List<Dojo> dojos= appService.findAllDojos();
    	model.addAttribute("alldojos",dojos);
        return "index.jsp";
    }
    
    
    
    @RequestMapping("/dojos/new")
    public String index(@ModelAttribute("hussam") Dojo dojo1) {
        return "dojo.jsp";
    }
    
    @RequestMapping("/ninjas/new")
    public String index5( @ModelAttribute("ibrahim") Ninja ninja1,Model model) {
    	List<Dojo> dojos=appService.findAllDojos();
    	model.addAttribute("alldojos",dojos);
        return "ninja.jsp";
    }
   
    
    @PostMapping("/ninjas")
    public String index6( @Valid @ModelAttribute("ibrahim") Ninja ninja1,BindingResult result,Model model) {
    	 if(result.hasErrors()) {
    	    	List<Dojo> dojos=appService.findAllDojos();
    	    	model.addAttribute("alldojos",dojos);
      		  return "ninja.jsp";
      	  }
      	  else {
      		appService.createNinja(ninja1);
      		  return "redirect:/";
      	  }
    }
   
    
    
    @PostMapping("/dojos")
    public String index2(@Valid @ModelAttribute("hussam") Dojo dojo1,BindingResult result) {
    	 if(result.hasErrors()) {
   		  return "dojo.jsp";
   	  }
   	  else {
   		appService.createDojo(dojo1);
   		  return "redirect:/";
   	  }
    }
    
    @RequestMapping("/dojos/{id}")
    public String index(@PathVariable("id") Long id,Model model) {
    	Dojo dojo1=appService.findDojo(id);
    	model.addAttribute("onedojo",dojo1);
        return "showdojo.jsp";
    }
    
    
    
}
