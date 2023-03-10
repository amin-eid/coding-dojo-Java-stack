package com.codingdojo.strings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 2. Importing dependencies
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StringsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringsApplication.class, args);
	}

	@RequestMapping("/")
    public String hello() { 
        return "Hello Client,How are you Doing?!";
}
	@RequestMapping("/random")
    public String rand() { 
        return "Spring Boot is Great! So easy to Just respond with strings!";
}
}
