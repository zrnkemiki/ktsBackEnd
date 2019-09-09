package com.smv.AirSpace.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smv.AirSpace.dto.VoziloDTO;
import com.smv.AirSpace.model.Vozilo;
import com.smv.AirSpace.service.VoziloServis;

@RestController
@RequestMapping(value = "/vozilo")
public class VoziloKontroler {

	@Autowired
	VoziloServis voziloServis;

	// Get all of entity vozilo.
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAll() {

		List<Vozilo> vozila = voziloServis.findAll();
		List<VoziloDTO> vozilaDTO = new ArrayList<VoziloDTO>();

		// convert vozilo in DTOVozlo. List<VoziloDTO> vozilaDTO = new ArrayList<>();
		for (Vozilo voz : vozila) {
			vozilaDTO.add(new VoziloDTO(voz));
		}

		try {
			return new ResponseEntity<List<VoziloDTO>>(vozilaDTO, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/{param}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getVehicle(@PathVariable("param") Long id) {
		Vozilo vozilo = voziloServis.findByID(id);
		VoziloDTO voziloDTO = new VoziloDTO(vozilo);
		return new ResponseEntity<VoziloDTO>(voziloDTO, HttpStatus.OK);
	}

	// Create new vehicle.
	// @PreAuthorize("hasAuthority('RENTACAR_ADMIN')")
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Vozilo> addVehicle(@RequestBody VoziloDTO voziloDTO) {

		Vozilo vozilo = voziloServis.saveVehicle(voziloDTO);

		return new ResponseEntity<Vozilo>(vozilo, HttpStatus.CREATED);
	}

	// Update vozilo.
	// @PreAuthorize("hasAuthority('RENTACAR_ADMIN')")
	@PutMapping()
	public ResponseEntity<Vozilo> updateVehicle(@RequestBody VoziloDTO voziloDTO, Principal principal) {
		return new ResponseEntity<Vozilo>(voziloServis.update(voziloDTO, principal), HttpStatus.OK);
	}

	// Delete vozilo.
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteVozilo(@PathVariable Long id) {
		Vozilo vozilo = voziloServis.getOne(id);
		if (vozilo == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		voziloServis.delete(vozilo.getId());
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
