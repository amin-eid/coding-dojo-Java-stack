package com.codingdojo.productscategories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.productscategories.models.Category;
import com.codingdojo.productscategories.models.CategoryProduct;
import com.codingdojo.productscategories.models.Product;
import com.codingdojo.productscategories.services.ProdCatService;

@Controller
public class ProductController {
	private final ProdCatService prodCatServ;
	
	public ProductController(ProdCatService prodCatServ) {
		this.prodCatServ = prodCatServ;
	}
	
	@GetMapping("/products/new")
	public String newProdPage(@ModelAttribute("productObject") Product product) {
		return "/newproduct.jsp";
	}
	
	@PostMapping("/addproduct")
	public String addProduct(@Valid @ModelAttribute("productObject") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "/newproduct.jsp";
		}
		else {
			prodCatServ.addProd(product);
			return "redirect:/products/new";
		}
	}
	
	@GetMapping("products/{prodid}")
	public String showProduct(@PathVariable("prodid") Long prodid, @ModelAttribute("categoryProductObj") CategoryProduct categoryProduct, Model model) {
		Product product = prodCatServ.singleProd(prodid);
		model.addAttribute("product", product);
		model.addAttribute("categories", prodCatServ.availableCategoriesForProduct(product));
		return "/showproduct.jsp";
	}
	
	@PostMapping("/catadd")
	public String attachCategory(@ModelAttribute("categoryProductObj") CategoryProduct categoryProduct) {
		prodCatServ.addCatToProduct(categoryProduct);
		return "redirect:/products/" + categoryProduct.getProduct().getId();
	}
	
	@GetMapping("categories/{catid}")
	public String showCategory(@PathVariable("catid") Long catid, @ModelAttribute("categoryProductObj") CategoryProduct categoryProduct, Model model) {
		Category category = prodCatServ.singleCat(catid);
		model.addAttribute("category", category);
		model.addAttribute("products", prodCatServ.availableProductsForCategory(category));
		return "/showcategory.jsp";
	}
	
	@PostMapping("/prodadd")
	public String attachProduct(@ModelAttribute("categoryProductObj") CategoryProduct categoryProduct) {
		prodCatServ.addProdToCategory(categoryProduct);
		return "redirect:/categories/" + categoryProduct.getCategory().getId();
	}
}