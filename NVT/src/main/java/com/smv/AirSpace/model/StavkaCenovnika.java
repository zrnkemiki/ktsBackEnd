package com.smv.AirSpace.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stavke_cenovnika")
public class StavkaCenovnika {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long idCenovnika;
	
	private Long idKarte;
	
	private int cenaKarte;

	public StavkaCenovnika() {
		super();
	}

	public StavkaCenovnika(Long id, Long idCenovnika, Long idKarte, int cenaKarte) {
		super();
		this.id = id;
		this.idCenovnika = idCenovnika;
		this.idKarte = idKarte;
		this.cenaKarte = cenaKarte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCenovnika() {
		return idCenovnika;
	}

	public void setIdCenovnika(Long idCenovnika) {
		this.idCenovnika = idCenovnika;
	}

	public Long getIdKarte() {
		return idKarte;
	}

	public void setIdKarte(Long idKarte) {
		this.idKarte = idKarte;
	}

	public int getCenaKarte() {
		return cenaKarte;
	}

	public void setCenaKarte(int cenaKarte) {
		this.cenaKarte = cenaKarte;
	}

	@Override
	public String toString() {
		return "StavkaCenovnika [id=" + id + ", idCenovnika=" + idCenovnika + ", idKarte=" + idKarte + ", cenaKarte="
				+ cenaKarte + "]";
	}
	
	
	
}
