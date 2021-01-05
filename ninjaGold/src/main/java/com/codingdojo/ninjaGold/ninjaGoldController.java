package com.codingdojo.ninjaGold;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ninjaGoldController {
public ArrayList<String> act=new ArrayList<String>();
@GetMapping("/")
	public String index(Model model,HttpSession session) {
	System.out.println("Salam!");
	if (session.getAttribute("gold")==null) {
		session.setAttribute("gold",0);
	}
	model.addAttribute("act",act);
	return "index.jsp";
}
	

@PostMapping("/")
public String index2(@RequestBody() String postData, HttpSession session) {
System.out.println("Someone clicked a button!");
String place=postData.substring(0,postData.indexOf("="));
System.out.println(place);
Random rand= new Random();
int x=0;
int gold=(int) session.getAttribute("gold");
String activities="You entered a ";
String gained="gained";
if (place.equals("farm")) {
	x=rand.nextInt(10)+10;
}
else if (place.equals("cave")) {
	x=rand.nextInt(5)+5;
}
else if (place.equals("house")) {
	x=rand.nextInt(3)+2;
}

else if (place.equals("casino")) {
	x=rand.nextInt(50);
	if (rand.nextInt(2)==1) {
		x=-x;
		gained="lost";
	}
}
gold+=x;
activities+=place+" and "+gained+" gold "+gold;

act.add(activities);
session.setAttribute("gold",gold);

return "redirect:/";
}


}
