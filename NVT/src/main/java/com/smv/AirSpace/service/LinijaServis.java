package com.smv.AirSpace.service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smv.AirSpace.dto.LinijaDTO;
import com.smv.AirSpace.dto.PolazakDTO;
import com.smv.AirSpace.dto.StajalisteDTO;
import com.smv.AirSpace.model.Linija;
import com.smv.AirSpace.model.Polazak;
import com.smv.AirSpace.model.Stajaliste;
import com.smv.AirSpace.repository.LinijaRepozitorijum;

import exceptions.LineDoesntExistException;

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
	
	public Linija findByID(Long id) {
		Optional<Linija> rets = linijaRepo.findById(id);
		if (!rets.isPresent()) {
			throw new LineDoesntExistException();
		}
		return rets.get();
	}

	public Linija getOne(Long broj) {
		return linijaRepo.getOne(broj);
	}
	
	public Linija save(LinijaDTO linijaDTO) {
		Linija linija = new Linija();
		linija.setId(linijaDTO.getId());
		linija.setBroj(linijaDTO.getBroj());
		linija.setNaziv(linijaDTO.getNaziv());
		List<Stajaliste> stajalista = new ArrayList<>();
		for (StajalisteDTO stajDTO : linijaDTO.getStajalista()) {
			stajalista.add(new Stajaliste(stajDTO));
		}
		linija.setStajalista(stajalista);
		List<Polazak> polasci = new ArrayList<>();
		for (PolazakDTO polDTO : linijaDTO.getPolasci()) {
			polasci.add(new Polazak(polDTO));
		}
		linija.setPolasci(polasci);
		linija.setTip(linijaDTO.getTip());
		return linijaRepo.save(linija);
	}

	public void delete(Long id) {
		linijaRepo.deleteById(id);	
	}

	public Linija update(LinijaDTO linijaDTO, Principal principal) {
		try {
			findByID(linijaDTO.getId());
			Linija linija = new Linija(linijaDTO);
			linijaRepo.save(linija);
			return linija;
		} catch (Exception e) {
			throw new LineDoesntExistException();
		}
	}

}
