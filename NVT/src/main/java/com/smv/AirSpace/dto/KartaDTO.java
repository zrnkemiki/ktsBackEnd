package com.smv.AirSpace.dto;

import java.util.Date;

import com.smv.AirSpace.model.Karta;
import com.smv.AirSpace.model.TipKarte;

public class KartaDTO {

	private Long id;
	private TipKarte tip;
	private boolean aktivirana;
	private Date vaziOd;
	private Date vaziDo;
	private int cena;
	private Long idVlasnik;
	
	public KartaDTO() {
		super();
	}

	public KartaDTO (Karta k) {
		this.id = k.getId();
		this.tip = k.getTip();
		this.aktivirana = k.isAktivirana();
		this.vaziOd = k.getVaziOd();
		this.vaziDo = k.getVaziDo();
		this.cena = k.getCena();
		this.idVlasnik = k.getVlasnik();
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
	
	
	
}
