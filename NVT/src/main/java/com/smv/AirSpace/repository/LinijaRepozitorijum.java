package com.smv.AirSpace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smv.AirSpace.model.Linija;

@Repository
public interface LinijaRepozitorijum extends JpaRepository<Linija, Long> {
	
}
