package com.smv.AirSpace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smv.AirSpace.model.Stajaliste;

/**
 * @author Nemanja
 * Nov 22, 2018
 */

@Repository
public interface StajalisteRepozitorijum extends JpaRepository<Stajaliste, Long>{

}
