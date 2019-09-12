package com.smv.AirSpace.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smv.AirSpace.dto.CenovnikDTO;
import com.smv.AirSpace.model.Cenovnik;
import com.smv.AirSpace.model.Karta;
import com.smv.AirSpace.model.TipKarte;
import com.smv.AirSpace.repository.CenovnikRepozitorijum;

import exceptions.VehicleDoesntExistException;

@Service
public class CenovnikService {
	@Autowired
	CenovnikRepozitorijum cenovnikRepo;

	public List<Cenovnik> findAll() {
		return cenovnikRepo.findAll();
	}

	public Cenovnik save(Cenovnik cenovnik) {
		return cenovnikRepo.save(cenovnik);
	}

	public Cenovnik findOne(Long id) {
		return cenovnikRepo.findById(id).orElse(null);
	}

	public Cenovnik getOne(Long id) {
		return cenovnikRepo.getOne(id);
	}

	public Cenovnik saveCenovnik(CenovnikDTO cenovnikDTO) {

		Cenovnik cenovnik = new Cenovnik();
		cenovnik.setId(cenovnikDTO.getId());
		cenovnik.setDatumOd(cenovnikDTO.getDatumOd());
		cenovnik.setDatumDo(cenovnikDTO.getDatumDo());
		cenovnik.setAktivan(true);
		cenovnik.setCena(cenovnikDTO.getCena());
		if (cenovnikDTO.getTipKarte().equalsIgnoreCase("jednokratna")) {
			cenovnik.setTipKarte(TipKarte.jednokratna);
			;
		} else if (cenovnikDTO.getTipKarte().equalsIgnoreCase("dnevna")) {
			cenovnik.setTipKarte(TipKarte.dnevna);
		} else if (cenovnikDTO.getTipKarte().equalsIgnoreCase("mesecna")) {
			cenovnik.setTipKarte(TipKarte.mesecna);
			;
		} else if (cenovnikDTO.getTipKarte().equalsIgnoreCase("mesecnaskolska")) {
			cenovnik.setTipKarte(TipKarte.mesecnaSkolska);
			;
		} else if (cenovnikDTO.getTipKarte().equalsIgnoreCase("mesecnapenzionerska")) {
			cenovnik.setTipKarte(TipKarte.mesecnaPenzionerska);
		} else {
			cenovnik.setTipKarte(TipKarte.jednokratna);
		}

		return cenovnikRepo.save(cenovnik);
	}

	public void delete(Long id) {
		Cenovnik cenovnik = findByID(id);
		cenovnik.setAktivan(false);
		cenovnikRepo.save(cenovnik);
	}

	public Cenovnik findByID(Long id) {
		Optional<Cenovnik> rets = cenovnikRepo.findById(id);
		if (!rets.isPresent()) {
			throw new VehicleDoesntExistException();
		}
		return rets.get();
	}

	public Cenovnik getCenovnikPoTipu(TipKarte tipKarte) {
		List<Cenovnik> cenovnici = findAll();
		Iterator<Cenovnik> iterator = cenovnici.iterator();
		while (iterator.hasNext()) {
			Cenovnik cenovnik = iterator.next();
			if (!cenovnik.isAktivan() || cenovnik.getTipKarte() != tipKarte) {
				iterator.remove();
			}
		}
		return cenovnici.get(0);

	}

}
