package com.smv.AirSpace.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smv.AirSpace.dto.CenovnikDTO;
import com.smv.AirSpace.model.Cenovnik;
import com.smv.AirSpace.service.CenovnikService;



@RestController
@RequestMapping(value = "cenovnik")
public class CenovnikKontroler {

	@Autowired
	CenovnikService cenovnikServis;
	
	//svi cenovnici
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAll() {
		
		List<Cenovnik> cenovnici = cenovnikServis.findAll();
		List<CenovnikDTO> cenovniciDTO = new ArrayList<>();


		for (Cenovnik cen : cenovnici) {
			cenovniciDTO.add(new CenovnikDTO(cen));
		}

		try {
			return new ResponseEntity<>(cenovniciDTO, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//dodaj novu kartu
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Cenovnik> saveCenovnik(@RequestBody CenovnikDTO cenovnikDTO){
			
		Cenovnik cenovnik = cenovnikServis.save(cenovnikDTO);
		return new ResponseEntity<>(cenovnik, HttpStatus.CREATED);	
	}
	
		
	
	// Delete cenovnik.
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteCenovnik(@PathVariable Long id) {
		Cenovnik cenovnik = cenovnikServis.getOne(id);
		if (cenovnik == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		cenovnikServis.delete(cenovnik.getId());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	
}
