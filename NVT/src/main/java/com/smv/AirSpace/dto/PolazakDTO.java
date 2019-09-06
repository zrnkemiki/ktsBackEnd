package com.smv.AirSpace.dto;

import com.smv.AirSpace.model.Polazak;

public class PolazakDTO {
	
	private Long id;	
	private String dan;
	private String vreme;
	
	public PolazakDTO() {
		super();
	}

	public PolazakDTO (Polazak pol) {
		this.id = pol.getId();
		this.dan = pol.getDan();
		this.vreme = pol.getVreme();
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

}
