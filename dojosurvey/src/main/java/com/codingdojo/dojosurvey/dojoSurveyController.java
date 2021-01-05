package com.codingdojo.dojosurvey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class dojoSurveyController {

    @RequestMapping("/")
    public String dashboard() {
        // ... any code to process before rendering
        return "index.jsp";
    } 
    
	      @RequestMapping(value="/result", method=RequestMethod.POST)
	      public String login(@RequestParam(value="txt") String name, @RequestParam(value="loc") String location , @RequestParam(value="lang") String language, @RequestParam(value="tex") String comment ,Model model) {
	            // ... process information and save it to the session
	    	  model.addAttribute("name", name);
	    	  model.addAttribute("location", location);
	    	  model.addAttribute("language", language);
	    	  model.addAttribute("comment", comment);
	    	  return "result.jsp";
	      }
	      
	      

	      
	      
	      
	      
}
