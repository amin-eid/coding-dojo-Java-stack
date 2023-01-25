package com.codingdojo.HelloHuman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HelloHumanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloHumanApplication.class, args);
	}

	@RestController
	public class HomeController {
	    @RequestMapping("/")
	    public String index(@RequestParam(value="name" , required=false) String searchQuery) {
	    	if (searchQuery== null) {
	    		String str="<h2>Hello Human</h2>";
	    				str+="Welcome to Spring Boot";
	    		return str;
	    	}
	    	else {
	    		String str="<h2>Hello " + searchQuery+ "</h2>Welcome to Spring Boot";
	        return str;
	    }
	}
	
	
}
}
