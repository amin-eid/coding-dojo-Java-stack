package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DateController {

    @RequestMapping("/")
    public String index() {
        return "index.jsp";
    }
    
    

	    @RequestMapping("/date")
	    public String index2(Model model) {
			String datePattern = "EEEEE, dd MMMMM, yyyy";
			SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
			String date = dateFormat.format(new Date());	
			
			model.addAttribute("date", date);
	        return "index2.jsp";
	    }
	    
	    @RequestMapping("/time")
	    public String index3(Model model) {
			String timePattern = "hh:mm a"; 
			SimpleDateFormat timeFormat = new SimpleDateFormat(timePattern);
			String time = timeFormat.format(new Date());	
			
			model.addAttribute("time", time);
	        return "index3.jsp";
	    }
	    
	    
		}
		
	
