package com.smv.AirSpace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smv.AirSpace.model.Stajaliste;


@Repository
public interface StajalisteRepozitorijum extends JpaRepository<Stajaliste, Long>{

}
