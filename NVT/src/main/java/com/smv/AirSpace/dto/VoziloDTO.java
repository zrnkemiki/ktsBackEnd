package com.smv.AirSpace.dto;

import com.smv.AirSpace.model.TipVozila;
import com.smv.AirSpace.model.Vozilo;

public class VoziloDTO {

	private Long id;
	private Long idTrenutnoStajaliste;
	private Long idLinija;
	private String tip;
	private String linijaString;
	private TipVozila tipVozila;

	public VoziloDTO() {
		super();
	}

	public VoziloDTO(Long id, Long idTrenutnoStajaliste, Long idLinija, String tip, String linijaString) {
		super();
		this.id = id;
		//DORADITI DA NE BUDE DEFAULT
		this.idTrenutnoStajaliste = 1L;
		this.idLinija = idLinija;
		this.tip = tip;
		this.linijaString = linijaString;
	}

	public VoziloDTO(Vozilo voz) {
		this.id = voz.getId();
		this.linijaString = voz.getLinija().toString();
		if (voz.getStajaliste() != null)
			this.idTrenutnoStajaliste = voz.getStajaliste();
		if (voz.getLinija() != null)
			this.idLinija = voz.getLinija();
		this.tip = voz.getTip().toString();
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

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getLinijaString() {
		return linijaString;
	}

	public void setLinijaString(String linijaString) {
		this.linijaString = linijaString;
	}

	public TipVozila getTipVozila() {
		return tipVozila;
	}

	public void setTipVozila(TipVozila tipVozila) {
		this.tipVozila = tipVozila;
	}

}
