package com.codingdojo.counter;


import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class counterController {

    @RequestMapping("/")
    public String index(HttpSession session) {
    	if (session.isNew()) {
			session.setAttribute("counter", 0);
			session.setAttribute("counter2", 0);
		}
		else {
			Integer count = (Integer) session.getAttribute("counter");
			Integer count2 = (Integer) session.getAttribute("counter2");
			count += 1;
			count2+=2;
			session.setAttribute("counter", count);
			session.setAttribute("counter2", count2);
		}
		return "index.jsp";
    }
    
    

	    @RequestMapping("/counter")
	    public String counter(){
        return "counter.jsp";
	    }
	    
	    @RequestMapping("/counter2")
	    public String counter2(){
        return "counter2.jsp";
	    }
	    
	    
	    @RequestMapping("/reset")
	    public String reset(HttpSession session){
			session.setAttribute("counter", 0);
			session.setAttribute("counter2", 0);
			
        return "index.jsp";
	    }
	    
	    
		}
		
	