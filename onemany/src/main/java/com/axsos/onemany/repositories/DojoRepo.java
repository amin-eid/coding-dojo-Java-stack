package com.axsos.onemany.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.axsos.onemany.models.Dojo;



public interface DojoRepo extends CrudRepository<Dojo, Long> {
 List<Dojo> findAll();
// Optional<Dojo> findById(Long id);
}
