package com.smv.AirSpace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smv.AirSpace.model.Karta;
import com.smv.AirSpace.repository.KartaRepozitorijum;

@Service
public class KartaServis {

	@Autowired
	KartaRepozitorijum kartaRepo;

	public List<Karta> findAll() {
		return kartaRepo.findAll();	
	}
	
	public Karta findOne(Long id) {
		return kartaRepo.findById(id).orElse(null);
	}

	public Karta getOne(Long id) {
		return kartaRepo.getOne(id);
	}

	public Karta save(Karta karta) {
		return kartaRepo.save(karta);
	}

	public void delete(Long id) {
		kartaRepo.deleteById(id);
	}
	
}