package com.smv.AirSpace.dto;

import com.smv.AirSpace.model.TipVozila;
import com.smv.AirSpace.model.Vozilo;

public class VoziloDTO {
	
	private Long id;
	private Long idTrenutnoStajaliste;
	private Long idLinija;
	private TipVozila tip;
	
	public VoziloDTO() {
		super();
	}

	public VoziloDTO (Vozilo voz) {
		this.id = voz.getId();
		if(voz.getStajaliste()!=null)
			this.idTrenutnoStajaliste = voz.getStajaliste();
		if(voz.getLinija()!=null)
			this.idLinija = voz.getLinija();
		this.tip = voz.getTip();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStajaliste() {
		return idTrenutnoStajaliste;
	}

	public void setStajaliste(Long stajalisteId) {
		this.idTrenutnoStajaliste = stajalisteId;
	}

	public Long getLinija() {
		return idLinija;
	}

	public void setLinija(Long idLinija) {
		this.idLinija = idLinija;
	}

	public TipVozila getTip() {
		return tip;
	}

	public void setTip(TipVozila tip) {
		this.tip = tip;
	}

}
