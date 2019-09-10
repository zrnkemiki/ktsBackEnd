package com.smv.AirSpace.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cenovnik")
public class Cenovnik {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private boolean aktivan;
	
	private Date datumOd;
	
	private Date datumDo;
	
	private TipKarte tipKarte;
	
	private int cena;

	public Cenovnik() {
		super();
	}

	public Cenovnik(Long id, boolean aktivan, Date datumOd, Date datumDo, TipKarte tipKarte, int cena) {
		super();
		this.id = id;
		this.aktivan = aktivan;
		this.datumOd = datumOd;
		this.datumDo = datumDo;
		this.tipKarte = tipKarte;
		this.cena = cena;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isAktivan() {
		return aktivan;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}

	public Date getDatumOd() {
		return datumOd;
	}

	public void setDatumOd(Date datumOd) {
		this.datumOd = datumOd;
	}

	public Date getDatumDo() {
		return datumDo;
	}

	public void setDatumDo(Date datumDo) {
		this.datumDo = datumDo;
	}

	public TipKarte getTipKarte() {
		return tipKarte;
	}

	public void setTipKarte(TipKarte tipKarte) {
		this.tipKarte = tipKarte;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	@Override
	public String toString() {
		return "Cenovnik [id=" + id + ", aktivan=" + aktivan + ", datumOd=" + datumOd + ", datumDo=" + datumDo
				+ ", tipKarte=" + tipKarte + ", cena=" + cena + "]";
	}
	
	
	


	
	

	
}
