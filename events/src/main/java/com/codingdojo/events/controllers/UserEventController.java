package com.codingdojo.events.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.events.models.Event;
import com.codingdojo.events.models.User;
import com.codingdojo.events.models.UserEvent;
import com.codingdojo.events.services.EventsService;


@Controller
public class UserEventController {

	@Autowired
	private EventsService eventService;
	

	
	private final String[] states = { "AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "IA", "ID",
	        "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ",
	        "NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV",
	        "WY" };
	


    @GetMapping("/events")
    public String events(HttpSession session, Model model, @ModelAttribute("event") Event event) {
    	Long userId = (Long) session.getAttribute("userId");
    	User u = eventService.findUserById(userId);
    	model.addAttribute("user", u);
    	String state = u.getState();
    	List<Event> eventsIn = eventService.eventsInState(state);
    	model.addAttribute("eventsIn", eventsIn);
    	List<Event> eventsOut = eventService.eventsOutOfState(state);
    	model.addAttribute("eventsOut", eventsOut);
    	model.addAttribute("states", states);  
    	
    	return "events.jsp";

    }
    

    
    ///////////////////
    @PostMapping(value="/events/create")
    public String createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, Model model, HttpSession session) {
    	if(result.hasErrors()) {
        	Long userId = (Long) session.getAttribute("userId");
        	User u = eventService.findUserById(userId);
        	model.addAttribute("user", u);
        	String state = u.getState();
        	List<Event> eventsIn = eventService.eventsInState(state);
        	model.addAttribute("eventsIn", eventsIn);
        	List<Event> eventsOut = eventService.eventsOutOfState(state);
        	model.addAttribute("eventsOut", eventsOut);
        	model.addAttribute("states", states); 
    		return "events.jsp";
    	}else {
    		eventService.createEvent(event);
    		return "redirect:/events/"+event.getId();
    	}
    }
    

///////////////////////
    
    @GetMapping(value="/events/{event_id}/join")
    public String addAttendee(@PathVariable("event_id")Long event_id, HttpSession session) {
    	User attendee = eventService.findUserById((Long) session.getAttribute("userId"));
    	Event attending_event = eventService.findEventById(event_id);
		List<User> attendees = attending_event.getAttendees();
		attendees.add(attendee);
		attending_event.setAttendees(attendees);
		eventService.updateUser(attendee);
		return "redirect:/events";
    }
    

//////////////////////////////////
    
    
    @GetMapping(value="/events/cancel/{event_id}")
    public String removeAttendee(@PathVariable("event_id")Long event_id, HttpSession session) {
    	User attendee = eventService.findUserById((Long) session.getAttribute("userId"));
    	Event attending_event = eventService.findEventById(event_id);
		List<User> attendees = attending_event.getAttendees();
		attendees.remove(attendee);
		attending_event.setAttendees(attendees);
		eventService.updateUser(attendee);
		return "redirect:/events";
    }

//////////////////////////////
    
    
    @RequestMapping("/events/{event_id}/delete")
    public String deleteEvent(@PathVariable("event_id") Long event_id) {
    	eventService.deleteEvent(event_id);
    	return "redirect:/events";
    }
    
//////////////////////////////////////////////
    
      @RequestMapping("/events/{event_id}/edit")
      public String editEvent(@PathVariable("event_id") Long event_id, Model model) {
    	Event event = eventService.findEventById(event_id);
      	model.addAttribute("event", event);
    	model.addAttribute("states", states); 
      	return "editEvent.jsp";
      }
      
      
///////////////////////////////////////////////////
      
      @PutMapping("/events/{id}/update")
      public String updateEvent(Model model, @PathVariable("id")Long id, @Valid @ModelAttribute("event") Event event, BindingResult result) {
          if (result.hasErrors()) {
          	  model.addAttribute("states", states); 
              return "editEvent.jsp";
          } else {
              this.eventService.updateEvent(event);
              return "redirect:/events/"+event.getId();
          }}
      
      
//////////////////////////////////
      
      @GetMapping("/events/{event_id}")
      public String showEvent(Model model, @PathVariable("event_id")Long event_id) {
    	  Event event = eventService.findEventById(event_id);
    	  model.addAttribute("event", event);
    	  return "showEvent.jsp";
      }
      
}
