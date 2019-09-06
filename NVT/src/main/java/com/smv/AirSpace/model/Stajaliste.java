package com.smv.AirSpace.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author Nemanja
 * Nov 5, 2018
 */
@Entity
@Table(name = "stajaliste")
public class Stajaliste implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String naziv;
	
	private Double lokacijaX;
	
	private Double lokacijaY;
	
	private String adresa;

	
	public Stajaliste() {
		super();
	}

	/**
	 * @param id
	 * @param naziv
	 * @param lokacijaX
	 * @param lokacijaY
	 * @param adresa
	 */
	public Stajaliste(Long id, String naziv, Double lokacijaX, Double lokacijaY, String adresa) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.lokacijaX = lokacijaX;
		this.lokacijaY = lokacijaY;
		this.adresa = adresa;
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

	@Override
	public String toString() {
		return "Stajaliste [id=" + id + ", naziv=" + naziv + ", lokacijaX=" + lokacijaX + ", lokacijaY=" + lokacijaY
				+ ", adresa=" + adresa + "]";
	}
	
	
	

}
