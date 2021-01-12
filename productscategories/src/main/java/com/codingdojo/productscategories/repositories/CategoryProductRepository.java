package com.codingdojo.productscategories.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.productscategories.models.CategoryProduct;


public interface CategoryProductRepository extends CrudRepository<CategoryProduct, Long>{

}