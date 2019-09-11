package com.smv.AirSpace.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.smv.AirSpace.dto.LinijaDTO;
import com.smv.AirSpace.dto.PolazakDTO;
import com.smv.AirSpace.dto.StajalisteDTO;

@Entity
@Table(name = "linija")
public class Linija {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	String broj;

	String naziv;

	@ManyToMany
	List<Stajaliste> stajalista;

	@ManyToMany
	List<Polazak> polasci;

	@Enumerated(EnumType.STRING)
	TipVozila tip;

	public Linija() {
		super();
	}

	public Linija(Long id, String broj, String naziv, List<Stajaliste> stajalista, List<Polazak> polasci,
			TipVozila tip) {
		super();
		this.id = id;
		this.broj = broj;
		this.naziv = naziv;
		this.stajalista = stajalista;
		this.polasci = polasci;
		this.tip = tip;
	}
	
	public Linija(LinijaDTO linijaDTO) {
		this.id = linijaDTO.getId();
		this.broj = linijaDTO.getBroj();
		this.naziv = linijaDTO.getNaziv();
		List<Stajaliste> staj = new ArrayList<>();
		for (StajalisteDTO stajDTO : linijaDTO.getStajalista()) {
			staj.add(new Stajaliste(stajDTO));
		}
		this.stajalista = staj;
		List<Polazak> pol = new ArrayList<>();
		for (PolazakDTO polDTO : linijaDTO.getPolasci()) {
			pol.add(new Polazak(polDTO));
		}
		this.polasci = pol;
		this.tip = linijaDTO.getTip();
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

	public List<Stajaliste> getStajalista() {
		return stajalista;
	}

	public void setStajalista(List<Stajaliste> stajalista) {
		this.stajalista = stajalista;
	}

	public List<Polazak> getPolasci() {
		return polasci;
	}

	public void setPolasci(List<Polazak> polasci) {
		this.polasci = polasci;
	}

	public TipVozila getTip() {
		return tip;
	}

	public void setTip(TipVozila tip) {
		this.tip = tip;
	}

	@Override
	public String toString() {
		return "Linija [id=" + id + ", broj=" + broj + ", naziv=" + naziv + ", stajalista=" + stajalista + ", polasci="
				+ polasci + ", tip=" + tip + "]";
	}

}
