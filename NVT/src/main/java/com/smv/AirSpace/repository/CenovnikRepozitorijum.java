package com.smv.AirSpace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smv.AirSpace.model.Cenovnik;

@Repository
public interface CenovnikRepozitorijum extends JpaRepository<Cenovnik, Long> {
	
}
