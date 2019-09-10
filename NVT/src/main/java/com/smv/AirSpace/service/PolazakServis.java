package com.smv.AirSpace.service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smv.AirSpace.dto.PolazakDTO;
import com.smv.AirSpace.model.Polazak;
import com.smv.AirSpace.repository.PolazakRepozitorijum;

import exceptions.DepartureDoesntExistException;

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
	
	public Polazak findByID(Long id) {
		Optional<Polazak> rets = polazakRepo.findById(id);
		if (!rets.isPresent()) {
			throw new DepartureDoesntExistException();
		}
		return rets.get();
	}

	public Polazak getOne(Long id) {
		return polazakRepo.getOne(id);
	}

	public Polazak save(Polazak polazak) {
		return polazakRepo.save(polazak);
	}

	public void delete(Long id) {
		polazakRepo.deleteById(id);
	}
	
	public Polazak save(PolazakDTO polazakDTO) {
		Polazak polazak = new Polazak();
		polazak.setId(polazakDTO.getId());
		polazak.setDan(polazakDTO.getDan());
		polazak.setVreme(polazakDTO.getVreme());
		return polazakRepo.save(polazak);
	}
	
	public Polazak update(PolazakDTO polazakDTO, Principal principal) {
		try {
			findByID(polazakDTO.getId());
			Polazak polazak = new Polazak(polazakDTO);
			polazakRepo.save(polazak);
			return polazak;
		} catch (Exception e) {
			throw new DepartureDoesntExistException();
		}
	}
	
}
