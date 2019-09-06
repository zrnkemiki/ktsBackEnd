package com.smv.AirSpace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smv.AirSpace.model.Karta;

@Repository
public interface KartaRepozitorijum extends JpaRepository<Karta, Long> {
	
}
