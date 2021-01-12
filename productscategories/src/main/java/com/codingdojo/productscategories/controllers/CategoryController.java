package com.codingdojo.productscategories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.productscategories.models.Category;
import com.codingdojo.productscategories.services.ProdCatService;

@Controller
public class CategoryController {
	private final ProdCatService prodCatServ;
	
	public CategoryController(ProdCatService prodCatServ) {
		this.prodCatServ = prodCatServ;
	}
	
	@GetMapping("/categories/new")
	public String newCatPage(@ModelAttribute("categoryObject") Category category) {
		return "/newcategory.jsp";
	}
	
	@PostMapping("/addcategory")
	public String addCategory(@Valid @ModelAttribute("categoryObject") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "/categories/new";
		}
		else {
			prodCatServ.addCat(category);
			return "redirect:/categories/new";
		}
	}
}