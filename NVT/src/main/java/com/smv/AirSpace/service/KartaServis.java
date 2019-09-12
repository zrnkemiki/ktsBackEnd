package com.smv.AirSpace.service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smv.AirSpace.dto.KartaDTO;
import com.smv.AirSpace.model.Cenovnik;
import com.smv.AirSpace.model.Karta;
import com.smv.AirSpace.model.TipKarte;
import com.smv.AirSpace.model.User;
import com.smv.AirSpace.model.UserType;
import com.smv.AirSpace.repository.KartaRepozitorijum;

@Service
public class KartaServis {

	@Autowired
	KartaRepozitorijum kartaRepo;
	
	@Autowired
	CenovnikService cenovnikService;

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

	public Karta saveKarta(KartaDTO kartaDTO, User user) {
		Karta karta = new Karta(kartaDTO, user);

		Calendar cal = Calendar.getInstance(); // creates calendar
		cal.setTime(new Date()); // sets calendar time/date

		karta.setId(kartaDTO.getId());
		karta.setUser(user);
		karta.setVlasnik(user.getId());
		karta.setCena(kartaDTO.getCena());
		

		if (kartaDTO.getTip().equalsIgnoreCase("jednokratna")) {
			karta.setTip(TipKarte.jednokratna);
			karta.setAktivirana(false);
			karta.setVaziOd(cal.getTime());
			cal.add(Calendar.HOUR_OF_DAY, 24);
			karta.setVaziDo(cal.getTime());
		} else if (kartaDTO.getTip().equalsIgnoreCase("dnevna")) {
			karta.setTip(TipKarte.dnevna);
			karta.setAktivirana(true);
			karta.setVaziOd(cal.getTime());
			cal.add(Calendar.HOUR_OF_DAY, 24);
			karta.setVaziDo(cal.getTime());
		} else if (kartaDTO.getTip().equalsIgnoreCase("mesecna")) {
			karta.setTip(TipKarte.mesecna);
			karta.setAktivirana(true);
			karta.setVaziOd(cal.getTime());
			cal.add(Calendar.MONTH, 1);
			karta.setVaziDo(cal.getTime());
		} else if (kartaDTO.getTip().equalsIgnoreCase("mesecnaskolska") && user.getUserType() == UserType.STUDENT) {
			karta.setTip(TipKarte.mesecnaSkolska);
			karta.setAktivirana(true);
			karta.setVaziOd(cal.getTime());
			cal.add(Calendar.MONTH, 1);
			karta.setVaziDo(cal.getTime());
		} else if (kartaDTO.getTip().equalsIgnoreCase("mesecnapenzionerska") && user.getUserType() == UserType.PENSIONARY) {
			karta.setTip(TipKarte.mesecnaPenzionerska);
			karta.setAktivirana(true);
			karta.setVaziOd(cal.getTime());
			cal.add(Calendar.MONTH, 1);
			karta.setVaziDo(cal.getTime());
		} else {
			karta.setTip(TipKarte.mesecna);
			karta.setAktivirana(true);
			karta.setVaziOd(cal.getTime());
			cal.add(Calendar.HOUR_OF_DAY, 24);
			karta.setVaziDo(cal.getTime());
		}
		

		Cenovnik cenovnik = cenovnikService.getCenovnikPoTipu(karta.getTip());
		karta.setCena(cenovnik.getCena());
		kartaRepo.save(karta);
		return karta;
	}

	public void delete(Long id) {
		kartaRepo.deleteById(id);
	}

	public List<KartaDTO> getByUser(User user) {
		List<Karta> karte = findAll();
		Iterator<Karta> iterator = karte.iterator();
		while(iterator.hasNext()) {
			Karta karta = iterator.next();
			if(karta.dajUsera().getId()!= user.getId()) {
				iterator.remove();
			}
		}
		
		List<KartaDTO> karteDTO = new ArrayList<>();
		for (Karta k : karte) {
			karteDTO.add(new KartaDTO(k));
		}
		return karteDTO;
	}

}
