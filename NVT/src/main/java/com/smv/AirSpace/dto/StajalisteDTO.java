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
		// TODO Auto-generated constructor stub
	}

	public StajalisteDTO (Stajaliste staj) {
		this.id = staj.getId();
		//System.out.println(this.id);
		this.naziv = staj.getNaziv();
		//System.out.println(this.naziv);
		this.lokacijaX = staj.getLokacijaX();
		//System.out.println(this.lokacijaX);
		this.lokacijaY = staj.getLokacijaY();
		//System.out.println(this.lokacijaY);
		this.adresa = staj.getAdresa();
		//System.out.println(this.adresa);
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
