package com.axsos.onemany.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.axsos.onemany.models.Ninja;

public interface NinjaRepo extends CrudRepository<Ninja, Long> {
List<Ninja> findAll();
}
