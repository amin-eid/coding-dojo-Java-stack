package com.codingdojo.CodingController;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class DojoController {

//	public static void main(String[] args) {
//		SpringApplication.run(DojoController.class, args);
//	}
//	
	
	    @RequestMapping("/{something}")
	    public String show(@PathVariable("something") String something){
	    	if (something.equals("dojo")) {
	    	return "The dojo is awesome!";
	    }
	    if (something.equals("burbank-dojo")) {
	    	return "Burbank Dojo is located in Southern California";
	    }
	    if (something.equals("san-jose")) {
	    	return "SJ dojo is the headquarters";
	    }
	    else {
	    return "";
	    }
	    }

}
