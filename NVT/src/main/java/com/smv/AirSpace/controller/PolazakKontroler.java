package com.smv.AirSpace.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smv.AirSpace.dto.PolazakDTO;
import com.smv.AirSpace.model.Polazak;
import com.smv.AirSpace.service.PolazakServis;


@RestController
@RequestMapping(value = "api/polazak")
public class PolazakKontroler {

	@Autowired
	PolazakServis polazakServis;
	
	//vrati sve polaske
	@GetMapping("/all")
	public ResponseEntity<List<PolazakDTO>> getAll(){
		
		List<Polazak> polasci = polazakServis.findAll();
		//konvertuj polaske u DTO
		List<PolazakDTO> polasciDTO = new ArrayList<>();
		for (Polazak p : polasci) {
			polasciDTO.add(new PolazakDTO(p));
		}
		return new ResponseEntity<>(polasciDTO, HttpStatus.OK);
		
	}
	
	//nadji jedan polazak
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<PolazakDTO> getPolazak(@PathVariable Long id){
		Polazak polazak = polazakServis.getOne(id);
		if(polazak == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new PolazakDTO(polazak), HttpStatus.OK);
	}
	
	//dodaj novi polazak
	@RequestMapping(value="/add", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<PolazakDTO> savePolazak(@RequestBody PolazakDTO polazakDTO){
		Polazak polazak = new Polazak();
		polazak.setId(polazakDTO.getId());
		polazak.setDan(polazakDTO.getDan());
		polazak.setVreme(polazakDTO.getVreme());
		
		polazak = polazakServis.save(polazak);
		return new ResponseEntity<>(new PolazakDTO(polazak), HttpStatus.CREATED);	
	}
	
	//Izmeni postojeci polazak
	@RequestMapping(value="/update", method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<PolazakDTO> updatePolazak(@RequestBody PolazakDTO polazakDTO){
		//polazak mora postojati
		Polazak polazak = polazakServis.getOne(polazakDTO.getId()); 
		if (polazak == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		polazak.setId(polazakDTO.getId());
		polazak.setDan(polazakDTO.getDan());
		polazak.setVreme(polazakDTO.getVreme());
		
		polazak = polazakServis.save(polazak);
		return new ResponseEntity<>(new PolazakDTO(polazak), HttpStatus.OK);	
	}
	
	
	//obrisi polazak
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletePolazak(@PathVariable Long id){
		Polazak polazak = polazakServis.getOne(id);
		if (polazak != null){
			polazakServis.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
