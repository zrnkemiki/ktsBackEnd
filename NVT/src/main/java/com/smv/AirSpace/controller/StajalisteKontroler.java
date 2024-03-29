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

import com.smv.AirSpace.dto.StajalisteDTO;
import com.smv.AirSpace.model.Stajaliste;
import com.smv.AirSpace.service.StajalisteServis;

@RestController
@RequestMapping(value = "/stajaliste")
public class StajalisteKontroler {
	
	@Autowired
	StajalisteServis stajalisteServis;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StajalisteDTO>> getAll() {
		List<Stajaliste> stajalista = stajalisteServis.findAll();
		List<StajalisteDTO> stajalistaDTO = new ArrayList<>();
		for (Stajaliste s : stajalista) {
			stajalistaDTO.add(new StajalisteDTO(s));
		}
		
		try {
			return new ResponseEntity<>(stajalistaDTO, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StajalisteDTO> getStajaliste(@PathVariable("id") Long id) {
		Stajaliste s = stajalisteServis.findByID(id);
		if (s == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		StajalisteDTO stajalisteDTO = new StajalisteDTO(s);
		return new ResponseEntity<>(stajalisteDTO, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('EMPLOYEE')")
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Stajaliste> addStajaliste(@RequestBody StajalisteDTO stajalisteDTO) {
		Stajaliste stajaliste = stajalisteServis.save(stajalisteDTO);
		return new ResponseEntity<>(stajaliste, HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasAuthority('EMPLOYEE')")
	@PutMapping()
	public ResponseEntity<Stajaliste> updateStajaliste(@RequestBody StajalisteDTO stajalisteDTO, Principal principal) {
		return new ResponseEntity<>(stajalisteServis.update(stajalisteDTO, principal), HttpStatus.OK);	
	}
	
	@PreAuthorize("hasAuthority('EMPLOYEE')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteStajaliste(@PathVariable Long id) {
		Stajaliste stajaliste = stajalisteServis.getOne(id);
		if (stajaliste != null) {
			stajalisteServis.delete(stajaliste.getId());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
