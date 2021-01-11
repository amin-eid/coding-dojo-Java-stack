package com.codingdojo.driverLicense.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.driverLicense.models.Person;
import com.codingdojo.driverLicense.repositories.PersonRepository;

@Service
public class PersonService {
    // adding the book repository as a dependency
    private final PersonRepository personRepository;
    
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    // returns all the books
    public List<Person> allPersons() {
        return personRepository.findAll();
    }
    // creates a book
    public Person createPerson(Person b) {
        return personRepository.save(b);
    }
    // retrieves a book
    public Person findPerson(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if(optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            return null;
        }
        
    }
    
    
    public Person updatePerson(Person b) {
    	return personRepository.save(b);
    }
    
    
	public Person updatePerson(String firstName, String lastName, Long id) {
		// TODO Auto-generated method stub
		Optional<Person> person1=personRepository.findById(id);
		if(person1.isPresent()) {
            Person updatePerson=person1.get();
            updatePerson.setFirstName(firstName);
            updatePerson.setLastName(lastName);
            return personRepository.save(updatePerson);
            
            
        } else {
            return null;
        }
		
	
	}
	
	
	public void deletePerson(Long id) {
		// TODO Auto-generated method stub
		personRepository.deleteById(id);	
	}
}
