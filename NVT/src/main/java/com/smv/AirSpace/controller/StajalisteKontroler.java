package com.smv.AirSpace.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public ResponseEntity<?> getAll() {
		List<Stajaliste> stajalista = stajalisteServis.findAll();
		List<StajalisteDTO> stajalistaDTO = new ArrayList<StajalisteDTO>();
		for (Stajaliste s : stajalista) {
			stajalistaDTO.add(new StajalisteDTO(s));
		}
		
		try {
			return new ResponseEntity<List<StajalisteDTO>>(stajalistaDTO, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getStajaliste(@PathVariable("id") Long id) {
		Stajaliste s = stajalisteServis.findByID(id);
		if (s == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		StajalisteDTO stajalisteDTO = new StajalisteDTO(s);
		return new ResponseEntity<StajalisteDTO>(stajalisteDTO, HttpStatus.OK);
	}
	
	//@PreAuthorize("hasAuthority('EMPLOYEE')")
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Stajaliste> addStajaliste(@RequestBody StajalisteDTO stajalisteDTO) {
		Stajaliste stajaliste = stajalisteServis.save(stajalisteDTO);
		return new ResponseEntity<Stajaliste>(stajaliste, HttpStatus.CREATED);
	}
	
	//@PreAuthorize("hasAuthority('EMPLOYEE')")
	@PutMapping()
	public ResponseEntity<Stajaliste> updateStajaliste(@RequestBody StajalisteDTO stajalisteDTO, Principal principal) {
		return new ResponseEntity<Stajaliste>(stajalisteServis.update(stajalisteDTO, principal), HttpStatus.OK);	
	}
	
	//@PreAuthorize("hasAuthority('EMPLOYEE')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteStajaliste(@PathVariable Long id) {
		Stajaliste stajaliste = stajalisteServis.getOne(id);
		if (stajaliste != null) {
			stajalisteServis.delete(stajaliste.getId());
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
