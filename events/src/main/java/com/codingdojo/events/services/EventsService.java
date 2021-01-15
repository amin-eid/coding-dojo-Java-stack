package com.codingdojo.events.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.events.models.Event;
import com.codingdojo.events.models.Message;
import com.codingdojo.events.models.User;
import com.codingdojo.events.models.UserEvent;
import com.codingdojo.events.repositories.EventRepo;
import com.codingdojo.events.repositories.MessageRepo;
import com.codingdojo.events.repositories.UserEventRepo;
import com.codingdojo.events.repositories.UserRepo;


@Service
public class EventsService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserEventRepo userEventRepo;
	
	@Autowired
	private EventRepo eventRepo;
	
	@Autowired
	private MessageRepo messageRepo;
	


    public User findUserById(Long id) {
    	Optional<User> u = userRepo.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
	public List<Event> eventsInState(String state) {
    	return eventRepo.findByState(state);
	}

	public List<Event> eventsOutOfState(String state) {
    	return eventRepo.findByStateIsNot(state);
	}
	
	public Event findEventById(Long event_id) {
		return eventRepo.findEventById(event_id);
	}
	

	

	public Event createEvent(Event event) {
		return eventRepo.save(event);
		
	}

	public UserEvent createRelationship(UserEvent userEvent) {
		return userEventRepo.save(userEvent);
		
	}

	public void deleteEvent(Long event_id) {
		eventRepo.deleteById(event_id);
	}

	public Event updateEvent(Event event) {
		return this.eventRepo.save(event);
		
	}

	public void updateUser(User attendee) {
		userRepo.save(attendee);
		
	}
	
	public void createUser(User usr) {
		userRepo.save(usr);
		
	}
	
	
	
	
	//User Part
	
	
	public User registerUser(@Valid User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepo.save(user);
    }

	public boolean authenticateUser(String email, String password) {
        User user = userRepo.findByEmail(email);
        if(user == null) {
            return false;
        } else {
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    
}
	

	
	

	public User findByEmail(String email) {
        return userRepo.findByEmail(email);
	}


	
	
	
	

}