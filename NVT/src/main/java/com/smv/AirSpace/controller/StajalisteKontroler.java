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

import com.smv.AirSpace.dto.StajalisteDTO;
import com.smv.AirSpace.model.Stajaliste;
import com.smv.AirSpace.service.StajalisteServis;

/**
 * @author Nemanja
 * Nov 22, 2018
 */

@RestController
@RequestMapping(value = "api/stajaliste")
public class StajalisteKontroler {
	
	@Autowired
	StajalisteServis stajalisteSer;
	
	//Get all of entity stajaliste.
	@GetMapping("/all")
	public ResponseEntity<List<StajalisteDTO>> getAll(){
		
		List<Stajaliste> stajalista = stajalisteSer.getAll();

		List<StajalisteDTO> stajalistaDTO = new ArrayList<>();
		for (Stajaliste s : stajalista) {
			stajalistaDTO.add(new StajalisteDTO(s));
		}
		return new ResponseEntity<>(stajalistaDTO, HttpStatus.OK);
		
	}
	
	//Get one stajaliste.
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<StajalisteDTO> getStajaliste(@PathVariable Long id){
		Stajaliste s = stajalisteSer.getOne(id);
		if(s == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new StajalisteDTO(s), HttpStatus.OK);
	}
	
	//New stajaliste.
	@RequestMapping(value="/add", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<StajalisteDTO> saveStajaliste(@RequestBody StajalisteDTO stajDTO){
		Stajaliste s = new Stajaliste();
		
		s.setId(stajDTO.getId());
		s.setNaziv(stajDTO.getNaziv());
		s.setLokacijaX(stajDTO.getLokacijaX());
		s.setLokacijaY(stajDTO.getLokacijaY());
		s.setAdresa(stajDTO.getAdresa());
		
		s = stajalisteSer.save(s);
	
		return new ResponseEntity<>(new StajalisteDTO(s), HttpStatus.CREATED);	
	}
	
	//Update stajaliste.
	@RequestMapping(value="/update", method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<StajalisteDTO> updateStajaliste(@RequestBody StajalisteDTO stajDTO){
		
		Stajaliste s = stajalisteSer.getOne(stajDTO.getId());
		
		if (s == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		s.setId(stajDTO.getId());
		s.setNaziv(stajDTO.getNaziv());
		s.setLokacijaX(stajDTO.getLokacijaX());
		s.setLokacijaY(stajDTO.getLokacijaY());
		s.setAdresa(stajDTO.getAdresa());
		
		s = stajalisteSer.save(s);
		return new ResponseEntity<>(new StajalisteDTO(s), HttpStatus.OK);	
	}
	
	
	//Delete stajaliste.
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteStajaliste(@PathVariable Long id){
		Stajaliste s = stajalisteSer.getOne(id);
		if (s != null){
			stajalisteSer.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
