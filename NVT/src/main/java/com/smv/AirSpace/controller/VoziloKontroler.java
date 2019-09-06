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

import com.smv.AirSpace.dto.VoziloDTO;
import com.smv.AirSpace.model.Vozilo;
import com.smv.AirSpace.service.VoziloServis;


@RestController
@RequestMapping(value = "api/vozilo")
public class VoziloKontroler {
	
	
	@Autowired
	VoziloServis voziloServis;
	
	//Get all of entity vozilo.
	@GetMapping("/all")
	public ResponseEntity<List<VoziloDTO>> getAll(){
		
		List<Vozilo> vozila = voziloServis.findAll();
		
		//convert vozilo in DTOVozlo.
		List<VoziloDTO> vozilaDTO = new ArrayList<>();
			for (Vozilo voz : vozila) {
				vozilaDTO.add(new VoziloDTO(voz));
			}
		
		return new ResponseEntity<>(vozilaDTO, HttpStatus.OK);
	}
	
	
	//Get vozilo.
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<VoziloDTO> getVozilo(@PathVariable Long id){
		
		Vozilo vozilo = voziloServis.getOne(id);
		
		if(vozilo == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(new VoziloDTO(vozilo), HttpStatus.OK);
		}
	}

	
	//Create new vozilo.
	@RequestMapping(value="/add", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<VoziloDTO> newVozilo(@RequestBody VoziloDTO voziloDto){
			
		Vozilo vozilo = new Vozilo();
		
		
		vozilo.setId(voziloDto.getId());
		vozilo.setStajaliste(voziloDto.getStajaliste());
		vozilo.setLinija(voziloDto.getLinija());
		vozilo.setTip(voziloDto.getTip());
			
		vozilo = voziloServis.save(vozilo);
		
		return new ResponseEntity<>(new VoziloDTO(vozilo), HttpStatus.CREATED);
	}
	
	
	
	//Update vozilo.
	@RequestMapping(value="/update", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<VoziloDTO> updateVozilo(@RequestBody VoziloDTO voziloDto){
			
		Vozilo vozilo = voziloServis.getOne(voziloDto.getId());
		
		if(vozilo == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		vozilo.setId(voziloDto.getId());
		vozilo.setStajaliste(voziloDto.getStajaliste());
		vozilo.setLinija(voziloDto.getLinija());
		vozilo.setTip(voziloDto.getTip());
			
		vozilo = voziloServis.save(vozilo);
		
		return new ResponseEntity<>(new VoziloDTO(vozilo), HttpStatus.OK);
	}
	
	
	
	
	//Delete vozilo.
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteVozilo(@PathVariable Long id){
		Vozilo vozilo = voziloServis.getOne(id);
		if (vozilo == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
			voziloServis.delete(vozilo.getId());
			return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
