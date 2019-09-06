package com.smv.AirSpace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smv.AirSpace.model.Vozilo;
import com.smv.AirSpace.repository.VoziloRepozitorijum;

@Service
public class VoziloServis {
	@Autowired
	VoziloRepozitorijum voziloRepo;

	public List<Vozilo> findAll() {
		return voziloRepo.findAll();	
	}
	
	public Vozilo findOne(Long id) {
		return voziloRepo.findById(id).orElse(null);
	}

	public Vozilo getOne(Long id) {
		return voziloRepo.getOne(id);
	}

	public Vozilo save(Vozilo vozilo) {
		return voziloRepo.save(vozilo);
	}

	public void delete(Long id) {
		voziloRepo.deleteById(id);	
	}
		
		
}
