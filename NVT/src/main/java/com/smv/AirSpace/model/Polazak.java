package com.smv.AirSpace.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.smv.AirSpace.dto.PolazakDTO;

@Entity
@Table(name = "polazak")
public class Polazak {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String dan;
	
	private String vreme;
	
	public Polazak() {
		super();
	}
	
	public Polazak(Long id, String dan, String vreme) {
		super();
		this.id = id;
		this.dan = dan;
		this.vreme = vreme;
	}
	
	public Polazak(PolazakDTO dto) {
		this.id = dto.getId();
		this.dan = dto.getDan();
		this.vreme = dto.getVreme();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDan() {
		return dan;
	}
	
	public void setDan(String dan) {
		this.dan = dan;
	}
	
	public String getVreme() {
		return vreme;
	}
	
	public void setVreme(String vreme) {
		this.vreme = vreme;
	}
	
	@Override
	public String toString() {
		return "Polazak [id=" + id + ", dan=" + dan + ", vreme=" + vreme + "]";
	}
	
}
