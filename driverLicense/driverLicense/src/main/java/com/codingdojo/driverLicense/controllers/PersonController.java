package com.codingdojo.driverLicense.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.driverLicense.models.Person;
import com.codingdojo.driverLicense.services.PersonService;

@Controller
public class PersonController {
    private final PersonService personService;
    
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    
    @RequestMapping("/persons")
    public String index(Model model) {
        List<Person> persons = personService.allPersons();
        model.addAttribute("persons", persons);
        return "/index.jsp";
    }
    
    @RequestMapping("/persons/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "/new.jsp";
    }
    @RequestMapping(value="/persons", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "/persons/new.jsp";
        } else {
            personService.createPerson(person);
            return "redirect:/persons";
        }
    }
    
    @RequestMapping("/persons/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
    	Person person = personService.findPerson(id);
    	model.addAttribute("person", person);
    	return "/show.jsp";
    }
    
    @RequestMapping("/persons/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Person person = personService.findPerson(id);
        model.addAttribute("person", person);
        return "/persons/edit.jsp";
    }
    
    @RequestMapping(value="/persons/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("person") Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "/persons/edit.jsp";
        } else {
            personService.updatePerson(person);
            return "redirect:/persons";
        }
    }
  
    @RequestMapping(value="/persons/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        personService.deletePerson(id);
        return "redirect:/persons";
    }
}
