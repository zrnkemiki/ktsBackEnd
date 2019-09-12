package com.smv.AirSpace.dto;

import java.util.Date;

import com.smv.AirSpace.model.Cenovnik;

public class CenovnikDTO {

	private Long id;

	private boolean aktivan;

	private Date datumOd;

	private Date datumDo;

	private String tipKarte;

	private int cena;
	
	

	public CenovnikDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CenovnikDTO(Long id, boolean aktivan, Date datumOd, Date datumDo, String tipKarte, int cena) {
		super();
		this.id = id;
		this.aktivan = aktivan;
		this.datumOd = datumOd;
		this.datumDo = datumDo;
		this.tipKarte = tipKarte;
		this.cena = cena;
	}

	public CenovnikDTO(Cenovnik cen) {
		this.id = cen.getId();
		this.datumOd = cen.getDatumOd();
		this.datumDo = cen.getDatumDo();
		this.tipKarte = cen.getTipKarte().toString();
		this.cena = cen.getCena();
		this.aktivan = cen.isAktivan();
		
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

	public String getTipKarte() {
		return tipKarte;
	}

	public void setTipKarte(String tipKarte) {
		this.tipKarte = tipKarte;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

}
