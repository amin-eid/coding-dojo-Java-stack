package com.codingdojo.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.countries.models.Country;


public interface CountryRepository extends CrudRepository<Country, Integer> {
	List<Country> findAll();
	@Query("SELECT c FROM Country c WHERE name LIKE %?1%")
	List<Country> findCountryByName(String name);
	@Query("SELECT c.name, l.language, l.percentage FROM Country c INNER JOIN c.languages l WHERE l.language LIKE %?1% ORDER BY l.percentage DESC")
	List<Object[]> findCountryByLang(String lang);
	@Query("SELECT c.name, COUNT(ci.id) AS num_cities FROM Country c JOIN c.cities ci GROUP BY c.id ORDER BY num_cities DESC")
	List<Object[]> findCountryCityCount();
	@Query("SELECT c FROM Country c WHERE c.surfaceArea < 501 AND c.population > 100000 ORDER BY c.population DESC")
	List<Country> findDenseCountries();
	@Query("SELECT c FROM Country c WHERE c.governmentForm = 'Constitutional Monarchy' AND c.lifeExpectancy > 75 AND c.capital > 200")
	List<Country> findConMonCountries();
	@Query("SELECT c.region, COUNT(c.id) AS num_countries FROM Country c GROUP BY c.region ORDER BY num_countries DESC")
	List<Object[]> findCountryByRegion();
	
	@Query(value="SELECT name, language, percentage from countries JOIN languages ON countries.id=languages.country_id WHERE language='Slovene' ORDER BY percentage DESC;",nativeQuery=true)
	List<Object[]> findCountriesSlovene();
	
	
	@Query(value="select countries.name,COUNT(cities.id) as x FROM countries JOIN cities ON countries.id=cities.country_id group by name order by x desc;",nativeQuery=true)
	List<Object[]> findTotalCitiesperCountry();
	
	//What query would you run to get all the cities in Mexico with a population of greater than 500,000
	
	
	@Query(value="select countries.id,cities.name,cities.population  FROM countries JOIN cities ON countries.id=cities.country_id WHERE countries.name='Mexico' and  cities.population > 500000 order by cities.population desc;",nativeQuery=true)
	List<Object[]> citiespop500();
	
	
	//What query would you run to get all languages in each country with a percentage greater than 89%?
	
	@Query(value="select countries.name,languages.language,languages.percentage from countries JOIN languages ON languages.country_id=countries.id WHERE languages.percentage > 89 order by languages.percentage desc;",nativeQuery=true)
	List<Object[]> langsCountry();
	
	//Surface Area below 501
	@Query(value="select countries.name,countries.surface_area,countries.population FROM countries where countries.surface_area < 501 && countries.population > 100000;",nativeQuery=true)
	List<Object[]> Surface();
	
	
	//constitutional monarchy
	@Query(value="select countries.name,countries.government_form,countries.life_expectancy,countries.capital from countries where countries.government_form='Constitutional Monarchy' AND countries.capital > 200 AND countries.life_expectancy > 75;",nativeQuery=true)
	List<Object[]> monarchy();
}