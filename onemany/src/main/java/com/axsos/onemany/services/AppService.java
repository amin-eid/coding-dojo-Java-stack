package com.axsos.onemany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.axsos.onemany.models.Dojo;
import com.axsos.onemany.models.Ninja;
import com.axsos.onemany.repositories.DojoRepo;
import com.axsos.onemany.repositories.NinjaRepo;

@Service
public class AppService {
private final DojoRepo dojoRepository;
private final NinjaRepo ninjaRepository;
    public AppService(DojoRepo dojoRepository,NinjaRepo ninjaRepository) {
        this.dojoRepository = dojoRepository;
        this.ninjaRepository=ninjaRepository;
    }
    
    // creates a dojo
    public Dojo createDojo(Dojo d) {
        return dojoRepository.save(d);
    }
    
    
    public Ninja createNinja(Ninja n) {
        return ninjaRepository.save(n);
    }
    
    
    
    public List<Dojo> findAllDojos(){
    	return dojoRepository.findAll();
    }
    
    public Dojo findDojo(Long id){
    	Optional<Dojo> dojo1 = dojoRepository.findById(id);
    	if (dojo1.isPresent()) {
    		return dojo1.get();
    	}
    	else {
    		return null;
    	}
    }
    
}
