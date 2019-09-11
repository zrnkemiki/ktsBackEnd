package com.smv.AirSpace.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smv.AirSpace.dto.KartaDTO;
import com.smv.AirSpace.model.Karta;
import com.smv.AirSpace.service.KartaServis;



@RestController
@RequestMapping(value = "api/karta")
public class KartaKontroler {

	@Autowired
	KartaServis kartaServis;
	
	//vrati sve karte
	@GetMapping("/all")
	public ResponseEntity<List<KartaDTO>> getAll(){
		
		List<Karta> karte = kartaServis.findAll();
		//konvertuj karte u DTO
		List<KartaDTO> karteDTO = new ArrayList<>();
		for (Karta k : karte) {
			karteDTO.add(new KartaDTO(k));
		}
		return new ResponseEntity<>(karteDTO, HttpStatus.OK);
		
	}
	
	//nadji jednu kartu
	@GetMapping(value="/{id}")
	public ResponseEntity<KartaDTO> getKarta(@PathVariable Long id){
		Karta karta = kartaServis.getOne(id);
		if(karta == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new KartaDTO(karta), HttpStatus.OK);
	}
	
	//dodaj novu kartu
	@PostMapping(value="/add", consumes="application/json")
	public ResponseEntity<KartaDTO> saveKarta(@RequestBody KartaDTO kartaDTO){
		Karta karta = new Karta();
		karta.setId(kartaDTO.getId());
		karta.setTip(kartaDTO.getTip());
		karta.setAktivirana(kartaDTO.isAktivirana());
		karta.setVaziOd(kartaDTO.getVaziOd());
		karta.setVaziDo(kartaDTO.getVaziDo());
		karta.setCena(kartaDTO.getCena());
		karta.setVlasnik(kartaDTO.getVlasnik());
		
		karta = kartaServis.save(karta);
		return new ResponseEntity<>(new KartaDTO(karta), HttpStatus.CREATED);	
	}
	
	//Izmeni postojecu kartu
	@PutMapping()
	public ResponseEntity<KartaDTO> updateKarta(@RequestBody KartaDTO kartaDTO){
		//karta mora postojati
		Karta karta = kartaServis.getOne(kartaDTO.getId()); 
		if (karta == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		karta.setId(kartaDTO.getId());
		karta.setTip(kartaDTO.getTip());
		karta.setAktivirana(kartaDTO.isAktivirana());
		karta.setVaziOd(kartaDTO.getVaziOd());
		karta.setVaziDo(kartaDTO.getVaziDo());
		karta.setCena(kartaDTO.getCena());
		karta.setVlasnik(kartaDTO.getVlasnik());
		
		karta = kartaServis.save(karta);
		return new ResponseEntity<>(new KartaDTO(karta), HttpStatus.OK);	
	}
	
	
	//obrisi kartu
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteKarta(@PathVariable Long id){
		Karta karta = kartaServis.getOne(id);
		if (karta != null){
			kartaServis.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
