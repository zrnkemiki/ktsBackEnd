package com.smv.AirSpace.service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smv.AirSpace.dto.VoziloDTO;
import com.smv.AirSpace.model.TipVozila;
import com.smv.AirSpace.model.Vozilo;
import com.smv.AirSpace.repository.VoziloRepozitorijum;

import exceptions.VehicleDoesntExistException;

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

	public Vozilo saveVehicle(VoziloDTO voziloDTO) {

		Vozilo vozilo = new Vozilo();
		vozilo.setId(voziloDTO.getId());
		vozilo.setLinija(Long.parseLong(voziloDTO.getLinijaString()));
		//DORADITI DA NE BUDE DEFAULT
		vozilo.setStajaliste(1L);
		if(voziloDTO.getTip().toLowerCase().equals("autobus")) {
			vozilo.setTip(TipVozila.autobus);
		}
		else if(voziloDTO.getTip().toLowerCase().equals("tramvaj")) {
			vozilo.setTip(TipVozila.tramvaj);
		}
		else if(voziloDTO.getTip().toLowerCase().equals("metro")) {
			vozilo.setTip(TipVozila.metro);
		}
		else vozilo.setTip(TipVozila.autobus);
		
		return voziloRepo.save(vozilo);
	}

	public void delete(Long id) {
		voziloRepo.deleteById(id);	
	}

	public Vozilo findByID(Long id) {
		Optional<Vozilo> rets = voziloRepo.findById(id);
		if (!rets.isPresent()) {
			throw new VehicleDoesntExistException();
		}
		return rets.get();
	}
	
	public Vozilo update(VoziloDTO voziloDTO, Principal principal) {
		try {
			findByID(voziloDTO.getId());
			Vozilo vozilo = new Vozilo(voziloDTO);
			voziloRepo.save(vozilo);
			return vozilo;
		} catch (Exception e) {
			throw new VehicleDoesntExistException();
		}
	}
		
		
}
