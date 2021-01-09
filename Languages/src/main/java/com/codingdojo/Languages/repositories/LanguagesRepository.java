package com.codingdojo.Languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.Languages.models.Language;

public interface LanguagesRepository extends CrudRepository<Language, Long>{
	List<Language> findAll();
}