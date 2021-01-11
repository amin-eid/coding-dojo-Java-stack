package com.codingdojo.driverLicense.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.driverLicense.models.Person;
import com.codingdojo.driverLicense.services.PersonService;

@RestController
public class PersonApi {
    private final PersonService personService;
    public PersonApi(PersonService personService){
        this.personService = personService;
    }
    @RequestMapping("/api/persons")
    public List<Person> index() {
        return personService.allPersons();
    }
    
    @RequestMapping(value="/api/persons", method=RequestMethod.POST)
    public Person create(@RequestParam(value="firstName") String firstName, @RequestParam(value="lastName") String lastName) {
        Person person = new Person(firstName, lastName);
        return personService.createPerson(person);
    }
    
    @RequestMapping("/api/persons/{id}")
    public Person show(@PathVariable("id") Long id) {
        Person person = personService.findPerson(id);
        return person;
    }
    
    @RequestMapping(value="/api/persons/{id}", method=RequestMethod.PUT)
    public Person update(@PathVariable("id") Long id, @RequestParam(value="firstName") String firstName, @RequestParam(value="lastName") String lastName) {
        Person person = personService.updatePerson(firstName,lastName,id);
        return person;
    }
    
    @RequestMapping(value="/api/persons/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        personService.deletePerson(id);
    }
}
