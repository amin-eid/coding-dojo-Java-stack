package com.codingdojo.countries.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.countries.models.City;
import com.codingdojo.countries.models.Country;
import com.codingdojo.countries.models.Language;
import com.codingdojo.countries.repositories.CountryRepository;

@Service
public class WorldService {
	@Autowired
	private CountryRepository cRepo;
	
	public List<Country> getCountryByName(String name) {
		return this.cRepo.findCountryByName(name);
	}
	public List<Object[]> getCountryByLanguage(String lang) {
		return this.cRepo.findCountryByLang(lang);
	}
	
	public List<Country> getCountries() {
		return this.cRepo.findAll();
	}
	
	public List<Object[]> sloven() {
		return this.cRepo.findCountriesSlovene();
	}
	
	public List<Object[]> citiesCountry() {
		return this.cRepo.findTotalCitiesperCountry();
	}
	
	//What query would you run to get all the cities in Mexico with a population of greater than 500,000
	
	public List<Object[]> cities500() {
		return this.cRepo.citiespop500();
	}
	
	//What query would you run to get all languages in each country with a percentage greater than 89%?
	public List<Object[]> langs() {
		return this.cRepo.langsCountry();
	}
	
	//surface area below 501
	public List<Object[]> surface() {
		return this.cRepo.Surface();
	}
	
	//constitutional monarchy
	public List<Object[]> monarchy() {
		return this.cRepo.monarchy();
	}
	
}
