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

import com.smv.AirSpace.dto.LinijaDTO;
import com.smv.AirSpace.model.Linija;
import com.smv.AirSpace.service.LinijaServis;
import com.smv.AirSpace.service.PolazakServis;
import com.smv.AirSpace.service.StajalisteServis;

@RestController
@RequestMapping(value = "/linija")
public class LinijaKontroler {
	@Autowired
	LinijaServis linijaServis;

	@Autowired
	PolazakServis polazakServis;

	@Autowired
	StajalisteServis stajalisteServis;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LinijaDTO>> getAll() {
		List<Linija> linije = linijaServis.findAll();
		List<LinijaDTO> linijeDTO = new ArrayList<>();
		for (Linija lin : linije) {
			linijeDTO.add(new LinijaDTO(lin));
		}
		
		try {
			return new ResponseEntity<>(linijeDTO, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LinijaDTO> getLinija(@PathVariable("id") Long id) {
		Linija linija = linijaServis.findByID(id);
		if (linija == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		LinijaDTO linijaDTO = new LinijaDTO(linija);
		return new ResponseEntity<>(linijaDTO, HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('EMPLOYEE')")
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Linija> addLinija(@RequestBody LinijaDTO linijaDTO) {
		Linija linija = linijaServis.save(linijaDTO);
		return new ResponseEntity<>(linija, HttpStatus.CREATED);
	}

	@PreAuthorize("hasAuthority('EMPLOYEE')")
	@PutMapping()
	public ResponseEntity<Linija> updateLinija(@RequestBody LinijaDTO linijaDTO, Principal principal) {
		return new ResponseEntity<>(linijaServis.update(linijaDTO, principal), HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('EMPLOYEE')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteLinija(@PathVariable Long id) {
		Linija linija = linijaServis.getOne(id);
		if (linija != null) {
			linijaServis.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
