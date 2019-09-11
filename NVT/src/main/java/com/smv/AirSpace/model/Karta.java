package com.smv.AirSpace.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.smv.AirSpace.dto.KartaDTO;

@Entity
@Table(name = "karte")
public class Karta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Enumerated(EnumType.STRING)
	private TipKarte tip;

	private boolean aktivirana;

	private Date vaziOd;

	private Date vaziDo;

	private int cena;

	private Long idVlasnik;

	@ManyToOne()
	private User user;

	public User dajUsera() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Karta(Long id, TipKarte tip, boolean aktivirana, Date vaziOd, Date vaziDo, int cena, Long idVlasnik,
			User user) {
		super();
		this.id = id;
		this.tip = tip;
		this.aktivirana = aktivirana;
		this.vaziOd = vaziOd;
		this.vaziDo = vaziDo;
		this.cena = cena;
		this.idVlasnik = idVlasnik;
		this.user = user;
	}

	public Karta() {
		super();
	}

	public Karta(KartaDTO kartaDTO) {
		this.id = kartaDTO.getId();
		if (kartaDTO.getTip().equalsIgnoreCase("jednokratna")) {
			this.setTip(TipKarte.jednokratna);
		} else if (kartaDTO.getTip().equalsIgnoreCase("dnevna")) {
			this.setTip(TipKarte.dnevna);
		} else if (kartaDTO.getTip().equalsIgnoreCase("mesecna")) {
			this.setTip(TipKarte.mesecna);
		} else if (kartaDTO.getTip().equalsIgnoreCase("mesecnaSkolska")) {
			this.setTip(TipKarte.mesecnaSkolska);
		} else if (kartaDTO.getTip().equalsIgnoreCase("mesecnaPenzionerska")) {
			this.setTip(TipKarte.mesecnaPenzionerska);
		} else {
			this.setTip(TipKarte.dnevna);
		}
		this.aktivirana = kartaDTO.isAktivirana();
		this.vaziOd = kartaDTO.getVaziOd();
		this.vaziDo = kartaDTO.getVaziDo();
		this.cena = kartaDTO.getCena();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipKarte getTip() {
		return tip;
	}

	public void setTip(TipKarte tip) {
		this.tip = tip;
	}

	public boolean isAktivirana() {
		return aktivirana;
	}

	public void setAktivirana(boolean aktivirana) {
		this.aktivirana = aktivirana;
	}

	public Date getVaziOd() {
		return vaziOd;
	}

	public void setVaziOd(Date vaziOd) {
		this.vaziOd = vaziOd;
	}

	public Date getVaziDo() {
		return vaziDo;
	}

	public void setVaziDo(Date vaziDo) {
		this.vaziDo = vaziDo;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public Long getVlasnik() {
		return idVlasnik;
	}

	public void setVlasnik(Long idVlasnik) {
		this.idVlasnik = idVlasnik;
	}

	@Override
	public String toString() {
		return "Karta [id=" + id + ", tip=" + tip + ", aktivirana=" + aktivirana + ", vaziOd=" + vaziOd + ", vaziDo="
				+ vaziDo + ", cena=" + cena + ", vlasnik=" + idVlasnik + "]";
	}

}