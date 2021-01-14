package com.codingdojo.countries.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.countries.models.Country;
import com.codingdojo.countries.services.WorldService;

@RestController
public class Controller {
	@Autowired
	private WorldService worldService;
	@GetMapping("/")
	public List<Country> Index() {
		return this.worldService.getCountries();
	}
	@GetMapping("/n/{name}")
	public List<Object[]> CountryByName(@PathVariable("name") String name) {
		return this.worldService.getCountryByLanguage(name);
	}

	@GetMapping("/sloven")
	public List<Object[]> speakSloven() {
		return this.worldService.sloven();
	}

	@GetMapping("/CountryCities")
	public List<Object[]> citiesCountry() {
		return this.worldService.citiesCountry();
	}

	//What query would you run to get all the cities in Mexico with a population of greater than 500,000
	
	@GetMapping("/cities500")
	public List<Object[]> cities500() {
		return this.worldService.cities500();
	}
	
	//What query would you run to get all languages in each country with a percentage greater than 89%?
	
	@GetMapping("/CountryLangs")
	public List<Object[]> langs() {
		return this.worldService.langs();
	}
	
	//surface area below 501
	@GetMapping("/surface")
	public List<Object[]> surf() {
		return this.worldService.surface();
	}
	
	//constitutional monarchy
	@GetMapping("/monarchy")
	public List<Object[]> monarchy() {
		return this.worldService.monarchy();
	}
}