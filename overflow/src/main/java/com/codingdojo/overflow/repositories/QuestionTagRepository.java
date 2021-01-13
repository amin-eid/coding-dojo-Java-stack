package com.codingdojo.overflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.overflow.models.QuestionTag;

@Repository
public interface QuestionTagRepository extends CrudRepository<QuestionTag, Long>{

	List<QuestionTag> findAll();

}
