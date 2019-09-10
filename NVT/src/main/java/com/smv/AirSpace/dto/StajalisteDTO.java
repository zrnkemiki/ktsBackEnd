package com.smv.AirSpace.dto;

import com.smv.AirSpace.model.Stajaliste;

public class StajalisteDTO {
	
	private Long id;
	private String naziv;
	private Double lokacijaX;
	private Double lokacijaY;
	private String adresa;
	
	public StajalisteDTO() {
		super();
	}
	
	public StajalisteDTO(Long id, String naziv, Double lokacijaX, Double lokacijaY, String adresa) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.lokacijaX = lokacijaX;
		this.lokacijaY = lokacijaY;
		this.adresa = adresa;
	}
	
	public StajalisteDTO (Stajaliste staj) {
		this.id = staj.getId();
		this.naziv = staj.getNaziv();
		this.lokacijaX = staj.getLokacijaX();
		this.lokacijaY = staj.getLokacijaY();
		this.adresa = staj.getAdresa();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Double getLokacijaX() {
		return lokacijaX;
	}

	public void setLokacijaX(Double lokacijaX) {
		this.lokacijaX = lokacijaX;
	}

	public Double getLokacijaY() {
		return lokacijaY;
	}

	public void setLokacijaY(Double lokacijaY) {
		this.lokacijaY = lokacijaY;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

}
