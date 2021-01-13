package com.codingdojo.overflow.controllers;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.overflow.models.Answer;
import com.codingdojo.overflow.models.NewQuestion;
import com.codingdojo.overflow.models.Question;
import com.codingdojo.overflow.services.OverflowService;

@Controller
public class QuestionController {

	private final OverflowService oService;
	public QuestionController(OverflowService service) {
		this.oService = service;
	}

	@RequestMapping("/questions")
	public String Index(Model model) {
		model.addAttribute("questions", oService.getAllQuestions());
		return "/questionindex.jsp";
	}	

	@RequestMapping("/questions/new")
	public String New(@ModelAttribute("questiontag") Question question) {
		return "/questionnew.jsp";
	}

	@RequestMapping("/questions/{id}")
	public String Show(@PathVariable("id") Long id,@ModelAttribute("answer") Answer answer, Model model) {
		model.addAttribute("question", this.oService.findQuestion(id));
		return "/questionshow.jsp";
	}
	
	@RequestMapping(value="/questions",method=RequestMethod.POST)
	public String addQuestion(@Valid @ModelAttribute("questiontag") NewQuestion question, BindingResult result) {
		if(result.hasErrors()) {
			return "questionnew.jsp";
		}
		else {
			this.oService.createQuestion(question);
			return "redirect:/questions";
		}
	}

	
	@RequestMapping("/answers")
	public String ansShow(Model model) {
		model.addAttribute("answers", oService.getAllAnswers());
		return "/answerindex.jsp";
	}		

	
	@RequestMapping(value="/answers",method=RequestMethod.POST)
	public String createAnswer(@Valid @ModelAttribute("answers") Answer answer, BindingResult result) {
		if(result.hasErrors()) {
			return "/answerindex.jsp";
		}
		else {
			this.oService.addAnswer(answer);
			return "redirect:/answers";
		}
	}
	
	
}
