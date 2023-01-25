package com.codingdojo.CodingController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 2. Importing dependencies
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@RequestMapping("/coding")
public class CodingControllerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CodingControllerApplication.class, args);
	}
	
    @RequestMapping("")
    public String index(){
      return "Hello Coding Dojo!";
    }
    @RequestMapping("/python")
    public String hello(){
      return "Python/Django was awesome!";
    }
    @RequestMapping("/java")
    public String world(){
      return "Java/Spring is better!";
    }
}
