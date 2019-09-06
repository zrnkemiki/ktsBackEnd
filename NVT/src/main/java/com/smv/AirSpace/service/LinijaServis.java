package com.smv.AirSpace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smv.AirSpace.model.Linija;
import com.smv.AirSpace.repository.LinijaRepozitorijum;

@Service
public class LinijaServis {
	@Autowired
	LinijaRepozitorijum linijaRepo;

	public List<Linija> findAll() {
		return linijaRepo.findAll();	
	}
	
	public Linija findOne(Long id) {
		return linijaRepo.findById(id).orElse(null);
	}

	public Linija getOne(Long broj) {
		return linijaRepo.getOne(broj);
	}

	public Linija save(Linija linija) {
		return linijaRepo.save(linija);
	}

	public void delete(Long id) {
		linijaRepo.deleteById(id);
		//linijaRepo.delete(linija);	
	}

	
		
		
}
