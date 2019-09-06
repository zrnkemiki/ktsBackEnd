package com.smv.AirSpace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smv.AirSpace.model.Polazak;
import com.smv.AirSpace.repository.PolazakRepozitorijum;

@Service
public class PolazakServis {

	@Autowired
	PolazakRepozitorijum polazakRepo;

	public List<Polazak> findAll() {
		return polazakRepo.findAll();	
	}
	
	public Polazak findOne(Long id) {
		return polazakRepo.findById(id).orElse(null);
	}

	public Polazak getOne(Long id) {
		return polazakRepo.getOne(id);
	}

	public Polazak save(Polazak polazak) {
		return polazakRepo.save(polazak);
	}

	public void delete(Long id) {
		polazakRepo.deleteById(id);
		//linijaRepo.delete(linija);	
	}
	
}
