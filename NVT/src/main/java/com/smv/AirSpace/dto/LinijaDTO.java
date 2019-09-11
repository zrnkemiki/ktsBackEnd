package com.smv.AirSpace.dto;

import java.util.ArrayList;
import java.util.List;

import com.smv.AirSpace.model.Linija;
import com.smv.AirSpace.model.Polazak;
import com.smv.AirSpace.model.Stajaliste;
import com.smv.AirSpace.model.TipVozila;

public class LinijaDTO {
	
	private Long id;
	private String broj;
	private String naziv;
	private List<StajalisteDTO> stajalista;
	private List<PolazakDTO> polasci;
	private TipVozila tip;
	
	public LinijaDTO() {
		super();
	}

	public LinijaDTO(Long id, String broj, String naziv, List<StajalisteDTO> stajalista, List<PolazakDTO> polasci,
			TipVozila tip) {
		super();
		this.id = id;
		this.broj = broj;
		this.naziv = naziv;
		this.stajalista = stajalista;
		this.polasci = polasci;
		this.tip = tip;
	}

	public LinijaDTO (Linija lin) {
		this.id = lin.getId();
		this.broj = lin.getBroj();
		this.naziv = lin.getNaziv();
		this.stajalista = new ArrayList<>();
		for (Stajaliste staj : lin.getStajalista()) {
			this.stajalista.add(new StajalisteDTO(staj));
		}
		this.polasci = new ArrayList<>();
		for (Polazak pol : lin.getPolasci()) {
			this.polasci.add(new PolazakDTO(pol));
		}
		this.tip = lin.getTip();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBroj() {
		return broj;
	}

	public void setBroj(String broj) {
		this.broj = broj;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<StajalisteDTO> getStajalista() {
		return stajalista;
	}

	public void setStajalista(List<StajalisteDTO> stajalista) {
		this.stajalista = stajalista;
	}

	public List<PolazakDTO> getPolasci() {
		return polasci;
	}

	public void setPolasci(List<PolazakDTO> polasci) {
		this.polasci = polasci;
	}

	public TipVozila getTip() {
		return tip;
	}

	public void setTip(TipVozila tip) {
		this.tip = tip;
	}

}
