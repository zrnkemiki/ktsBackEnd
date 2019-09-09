package com.smv.AirSpace.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "linija")
public class Linija implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
