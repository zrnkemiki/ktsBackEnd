package com.smv.AirSpace.service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smv.AirSpace.dto.StajalisteDTO;
import com.smv.AirSpace.model.Stajaliste;
import com.smv.AirSpace.repository.StajalisteRepozitorijum;

import exceptions.StopDoesntExistException;

@Service
public class StajalisteServis {

	@Autowired
	StajalisteRepozitorijum stajalisteRepo;
	
	public List<Stajaliste> findAll() {
		return stajalisteRepo.findAll();
	}
	
	public Stajaliste findOne(Long id) {
		return stajalisteRepo.findById(id).orElse(null);
	}
	
	public Stajaliste getOne(Long id) {
		return stajalisteRepo.getOne(id);
	}
	
	public Stajaliste save(StajalisteDTO stajalisteDTO) {
		Stajaliste stajaliste = new Stajaliste();
		stajaliste.setId(stajalisteDTO.getId());
		stajaliste.setNaziv(stajalisteDTO.getNaziv());
		stajaliste.setLokacijaX(stajalisteDTO.getLokacijaX());
		stajaliste.setLokacijaY(stajalisteDTO.getLokacijaY());
		stajaliste.setAdresa(stajalisteDTO.getAdresa());
		return stajalisteRepo.save(stajaliste);
	}
	
	public void delete(Long id) {
		stajalisteRepo.deleteById(id);
	}
	
	public Stajaliste findByID(Long id) {
		Optional<Stajaliste> rets = stajalisteRepo.findById(id);
		if (!rets.isPresent()) {
			throw new StopDoesntExistException();
		}
		return rets.get();
	}
	
	public Stajaliste update(StajalisteDTO stajalisteDTO, Principal principal) {
		try {
			findByID(stajalisteDTO.getId());
			Stajaliste stajaliste = new Stajaliste(stajalisteDTO);
			stajalisteRepo.save(stajaliste);
			return stajaliste;
		} catch (Exception e) {
			throw new StopDoesntExistException();
		}
	}
}
