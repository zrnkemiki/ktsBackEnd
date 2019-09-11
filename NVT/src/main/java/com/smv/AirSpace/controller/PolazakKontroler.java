package com.smv.AirSpace.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smv.AirSpace.dto.PolazakDTO;
import com.smv.AirSpace.model.Polazak;
import com.smv.AirSpace.service.PolazakServis;

@RestController
@RequestMapping(value = "/polazak")
public class PolazakKontroler {

	@Autowired
	PolazakServis polazakServis;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PolazakDTO>> getAll() {
		List<Polazak> polasci = polazakServis.findAll();
		List<PolazakDTO> polasciDTO = new ArrayList<>();
		for (Polazak p : polasci) {
			polasciDTO.add(new PolazakDTO(p));
		}
		
		try {
			return new ResponseEntity<>(polasciDTO, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PolazakDTO> getPolazak(@PathVariable("id") Long id) {
		Polazak polazak = polazakServis.findByID(id);
		if (polazak == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		PolazakDTO polazakDTO = new PolazakDTO(polazak);
		return new ResponseEntity<>(polazakDTO, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('EMPLOYEE')")
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Polazak> addPolazak(@RequestBody PolazakDTO polazakDTO) {
		Polazak polazak = polazakServis.save(polazakDTO);
		return new ResponseEntity<>(polazak, HttpStatus.CREATED);	
	}
	
	@PreAuthorize("hasAuthority('EMPLOYEE')")
	@PutMapping()
	public ResponseEntity<Polazak> updatePolazak(@RequestBody PolazakDTO polazakDTO, Principal principal) {
		return new ResponseEntity<>(polazakServis.update(polazakDTO, principal), HttpStatus.OK);	
	}
	
	@PreAuthorize("hasAuthority('EMPLOYEE')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletePolazak(@PathVariable Long id) {
		Polazak polazak = polazakServis.getOne(id);
		if (polazak != null) {
			polazakServis.delete(polazak.getId());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
