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

import com.smv.AirSpace.dto.KartaDTO;
import com.smv.AirSpace.model.Karta;
import com.smv.AirSpace.model.User;
import com.smv.AirSpace.service.KartaServis;
import com.smv.AirSpace.service.UserServiceImpl;

@RestController
@RequestMapping(value = "karta")
public class KartaKontroler {

	@Autowired
	KartaServis kartaServis;

	@Autowired
	UserServiceImpl userService;

	// vrati sve karte
	@PreAuthorize("hasAuthority('EMPLOYEE')")
	@GetMapping("/all")
	public ResponseEntity<List<KartaDTO>> getAll() {

		List<Karta> karte = kartaServis.findAll();
		// konvertuj karte u DTO
		List<KartaDTO> karteDTO = new ArrayList<>();
		for (Karta k : karte) {
			karteDTO.add(new KartaDTO(k));
		}
		return new ResponseEntity<>(karteDTO, HttpStatus.OK);

	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<KartaDTO>> getUserTicket(Principal principal) {
		User user = userService.getUserByUsername(principal.getName());
		
		List<KartaDTO> karteDTO = kartaServis.getByUser(user);
		// konvertuj karte u DTO
		
		return new ResponseEntity<>(karteDTO, HttpStatus.OK);

	}
	
	@GetMapping(value = "/getTicketByUserName/{username}")
	public ResponseEntity<List<KartaDTO>> getTicketByUserName(@PathVariable String username) {
		User user = userService.getUserByUsername(username);

		List<KartaDTO> karteDTO = kartaServis.getByUser(user);
		// konvertuj karte u DTO

		return new ResponseEntity<>(karteDTO, HttpStatus.OK);

	}

	// nadji jednu kartu
	@GetMapping(value = "/{id}")
	public ResponseEntity<KartaDTO> getKarta(@PathVariable Long id) {
		Karta karta = kartaServis.getOne(id);
		if (karta == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new KartaDTO(karta), HttpStatus.OK);
	}

	// dodaj novu kartu
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Karta> addKarta(@RequestBody KartaDTO kartaDTO, Principal principal) {

		User user = userService.getUserByUsername(principal.getName());
		Karta karta = kartaServis.saveKarta(kartaDTO, user);

		return new ResponseEntity<Karta>(karta, HttpStatus.CREATED);
	}

	// Aktiviraj kartu
	@PutMapping()
	public ResponseEntity<Karta> updateKarta(@RequestBody KartaDTO kartaDTO) {
		// karta mora postojati
		Karta karta = kartaServis.findOne(kartaDTO.getId());
		if (karta == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		karta.setAktivirana(true);

		karta = kartaServis.save(karta);
		return new ResponseEntity<>(karta, HttpStatus.OK);
	}

	// obrisi kartu
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteKarta(@PathVariable Long id) {
		Karta karta = kartaServis.getOne(id);
		if (karta != null) {
			kartaServis.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
