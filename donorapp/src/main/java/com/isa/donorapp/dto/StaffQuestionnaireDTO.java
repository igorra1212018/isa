package com.isa.donorapp.dto;

import java.time.LocalTime;
import java.util.List;

import com.isa.donorapp.model.Equipment;
import com.isa.donorapp.model.enums.EBloodType;

public class StaffQuestionnaireDTO {
	private EBloodType krvnaGrupa;	
	private String napomenaDoktoru;	
	private double bakarSulfat;	
	private String nivo;	
	private Integer hemoglobinometar;	
	private double ocitanaVrednost;	
	private String pluca;	
	private String srce;	
	private Integer gornjiPritisak;	
	private Integer donjiPritisak;	
	private Integer trombinskoVreme;
	private boolean odbijen;	
	private String razlogOdbijanja;	
	private String tipKese;	
	private Integer brojLotaKese;	
	private String mestoPunkcije;	
	private LocalTime pocetakDavanja;	
	private LocalTime zavrsetakDavanja;	
	private Integer kolicinaUzeteKrvi;	
	private String razlogPrekida;	
	private List<Equipment> equipment;
	private Integer reservationId;
	
	public StaffQuestionnaireDTO() {}
	
	public StaffQuestionnaireDTO(EBloodType krvnaGrupa, String napomenaDoktoru, double bakarSulfat, String nivo,
			Integer hemoglobinometar, double ocitanaVrednost, String pluca, String srce, Integer gornjiPritisak,
			Integer donjiPritisak, Integer trombinskoVreme, boolean odbijen, String razlogOdbijanja, String tipKese,
			Integer brojLotaKese, String mestoPunkcije, LocalTime pocetakDavanja, LocalTime zavrsetakDavanja,
			Integer kolicinaUzeteKrvi, String razlogPrekida, List<Equipment> equipment, Integer reservationId) {
		this.krvnaGrupa = krvnaGrupa;
		this.napomenaDoktoru = napomenaDoktoru;
		this.bakarSulfat = bakarSulfat;
		this.nivo = nivo;
		this.hemoglobinometar = hemoglobinometar;
		this.ocitanaVrednost = ocitanaVrednost;
		this.pluca = pluca;
		this.srce = srce;
		this.gornjiPritisak = gornjiPritisak;
		this.donjiPritisak = donjiPritisak;
		this.trombinskoVreme = trombinskoVreme;
		this.odbijen = odbijen;
		this.razlogOdbijanja = razlogOdbijanja;
		this.tipKese = tipKese;
		this.brojLotaKese = brojLotaKese;
		this.mestoPunkcije = mestoPunkcije;
		this.pocetakDavanja = pocetakDavanja;
		this.zavrsetakDavanja = zavrsetakDavanja;
		this.kolicinaUzeteKrvi = kolicinaUzeteKrvi;
		this.razlogPrekida = razlogPrekida;
		this.equipment = equipment;
		this.reservationId = reservationId;
	}

	public EBloodType getKrvnaGrupa() {
		return krvnaGrupa;
	}

	public void setKrvnaGrupa(EBloodType krvnaGrupa) {
		this.krvnaGrupa = krvnaGrupa;
	}

	public String getNapomenaDoktoru() {
		return napomenaDoktoru;
	}

	public void setNapomenaDoktoru(String napomenaDoktoru) {
		this.napomenaDoktoru = napomenaDoktoru;
	}

	public double getBakarSulfat() {
		return bakarSulfat;
	}

	public void setBakarSulfat(double bakarSulfat) {
		this.bakarSulfat = bakarSulfat;
	}

	public String getNivo() {
		return nivo;
	}

	public void setNivo(String nivo) {
		this.nivo = nivo;
	}

	public Integer getHemoglobinometar() {
		return hemoglobinometar;
	}

	public void setHemoglobinometar(Integer hemoglobinometar) {
		this.hemoglobinometar = hemoglobinometar;
	}

	public double getOcitanaVrednost() {
		return ocitanaVrednost;
	}

	public void setOcitanaVrednost(double ocitanaVrednost) {
		this.ocitanaVrednost = ocitanaVrednost;
	}

	public String getPluca() {
		return pluca;
	}

	public void setPluca(String pluca) {
		this.pluca = pluca;
	}

	public String getSrce() {
		return srce;
	}

	public void setSrce(String srce) {
		this.srce = srce;
	}

	public Integer getGornjiPritisak() {
		return gornjiPritisak;
	}

	public void setGornjiPritisak(Integer gornjiPritisak) {
		this.gornjiPritisak = gornjiPritisak;
	}

	public Integer getDonjiPritisak() {
		return donjiPritisak;
	}

	public void setDonjiPritisak(Integer donjiPritisak) {
		this.donjiPritisak = donjiPritisak;
	}

	public Integer getTrombinskoVreme() {
		return trombinskoVreme;
	}

	public void setTrombinskoVreme(Integer trombinskoVreme) {
		this.trombinskoVreme = trombinskoVreme;
	}

	public boolean isOdbijen() {
		return odbijen;
	}

	public void setOdbijen(boolean odbijen) {
		this.odbijen = odbijen;
	}

	public String getRazlogOdbijanja() {
		return razlogOdbijanja;
	}

	public void setRazlogOdbijanja(String razlogOdbijanja) {
		this.razlogOdbijanja = razlogOdbijanja;
	}

	public String getTipKese() {
		return tipKese;
	}

	public void setTipKese(String tipKese) {
		this.tipKese = tipKese;
	}

	public Integer getBrojLotaKese() {
		return brojLotaKese;
	}

	public void setBrojLotaKese(Integer brojLotaKese) {
		this.brojLotaKese = brojLotaKese;
	}

	public String getMestoPunkcije() {
		return mestoPunkcije;
	}

	public void setMestoPunkcije(String mestoPunkcije) {
		this.mestoPunkcije = mestoPunkcije;
	}

	public LocalTime getPocetakDavanja() {
		return pocetakDavanja;
	}

	public void setPocetakDavanja(LocalTime pocetakDavanja) {
		this.pocetakDavanja = pocetakDavanja;
	}

	public LocalTime getZavrsetakDavanja() {
		return zavrsetakDavanja;
	}

	public void setZavrsetakDavanja(LocalTime zavrsetakDavanja) {
		this.zavrsetakDavanja = zavrsetakDavanja;
	}

	public Integer getKolicinaUzeteKrvi() {
		return kolicinaUzeteKrvi;
	}

	public void setKolicinaUzeteKrvi(Integer kolicinaUzeteKrvi) {
		this.kolicinaUzeteKrvi = kolicinaUzeteKrvi;
	}

	public String getRazlogPrekida() {
		return razlogPrekida;
	}

	public void setRazlogPrekida(String razlogPrekida) {
		this.razlogPrekida = razlogPrekida;
	}

	public List<Equipment> getEquipment() {
		return equipment;
	}

	public void setEquipment(List<Equipment> equipment) {
		this.equipment = equipment;
	}

	public Integer getReservationId() {
		return reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}
		
}
