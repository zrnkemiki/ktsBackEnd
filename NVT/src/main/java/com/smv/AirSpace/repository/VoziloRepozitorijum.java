package com.smv.AirSpace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smv.AirSpace.model.Vozilo;

@Repository
public interface VoziloRepozitorijum extends JpaRepository<Vozilo, Long> {
	
}
