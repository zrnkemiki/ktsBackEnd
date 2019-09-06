package com.smv.AirSpace.model;

import java.util.Date;
import java.util.Map;

import javax.persistence.ElementCollection;
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
	
	private Date datumOd;
	
	private Date datumDo;
	
	@ElementCollection
	private Map<TipKarte,Integer> ceneKarata;

	public Cenovnik() {
		super();
	}

	public Cenovnik(Long id, Date datumOd, Date datumDo, Map<TipKarte, Integer> ceneKarata) {
		super();
		this.id = id;
		this.datumOd = datumOd;
		this.datumDo = datumDo;
		this.ceneKarata = ceneKarata;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Map<TipKarte, Integer> getCeneKarata() {
		return ceneKarata;
	}

	public void setCeneKarata(Map<TipKarte, Integer> ceneKarata) {
		this.ceneKarata = ceneKarata;
	}

	@Override
	public String toString() {
		return "Cenovnik [id=" + id + ", datumOd=" + datumOd + ", datumDo=" + datumDo + ", ceneKarata=" + ceneKarata
				+ "]";
	}
	
	
	
}
