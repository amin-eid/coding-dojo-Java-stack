package com.codingdojo.logreg.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.logreg.models.User;
import com.codingdojo.logreg.services.UserService;


@Controller
public class UsersController {
 private final UserService userService;
 
 public UsersController(UserService userService) {
     this.userService = userService;
 }
 
 @RequestMapping("/registration")
 public String registerForm(@ModelAttribute("user") User user) {
     return "registrationPage.jsp";
 }
 @RequestMapping("/login")
 public String login() {
     return "loginPage.jsp";
 }
 
 @RequestMapping(value="/registration", method=RequestMethod.POST)
 public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
	 if(result.hasErrors()) {
		 return "registrationPage.jsp";
	 }
	 User u=userService.registerUser(user);
	 session.setAttribute("userId", u.getId());
	 return "redirect:/home";
 }
 
 @RequestMapping(value="/login", method=RequestMethod.POST)
 public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
	 boolean isAuthenticated=userService.authenticateUser(email, password);
	 if(isAuthenticated) {
		 User u=userService.findByEmail(email);
		 session.setAttribute("userId", u.getId());
		 return "redirect:/home";
	 }
	 else {
		 model.addAttribute("error","invalid Credentials,Please try again!");
		 return "loginPage.jsp";
	 }
 }
 
 @RequestMapping("/home")
 public String home(HttpSession session, Model model) {
	 Long userID=(Long) session.getAttribute("userId");
	 User u=userService.findUserById(userID);
	 model.addAttribute("user",u);
	 return "homePage.jsp";
 }
 @RequestMapping("/logout")
 public String logout(HttpSession session) {
	 session.invalidate();
	 return "redirect:/login";
 }
}