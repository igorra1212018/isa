package com.isa.donorapp.model;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.isa.donorapp.dto.StaffQuestionnaireDTO;
import com.isa.donorapp.model.enums.EBloodType;

@Entity
public class StaffQuestionnaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
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
	
	public StaffQuestionnaire() {}

	public StaffQuestionnaire(EBloodType krvnaGrupa, String napomenaDoktoru, double bakarSulfat, String nivo,
			Integer hemoglobinometar, double ocitanaVrednost, String pluca, String srce, Integer gornjiPritisak,
			Integer donjiPritisak, Integer trombinskoVreme, boolean odbijen, String razlogOdbijanja, String tipKese,
			Integer brojLotaKese, String mestoPunkcije, LocalTime pocetakDavanja, LocalTime zavrsetakDavanja,
			Integer kolicinaUzeteKrvi, String razlogPrekida) {
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
	}

	public StaffQuestionnaire(StaffQuestionnaireDTO sqdto) {
		this.krvnaGrupa = sqdto.getKrvnaGrupa();
		this.napomenaDoktoru = sqdto.getNapomenaDoktoru();
		this.bakarSulfat = sqdto.getBakarSulfat();
		this.nivo = sqdto.getNivo();
		this.hemoglobinometar = sqdto.getHemoglobinometar();
		this.ocitanaVrednost = sqdto.getOcitanaVrednost();
		this.pluca = sqdto.getPluca();
		this.srce = sqdto.getSrce();
		this.gornjiPritisak = sqdto.getGornjiPritisak();
		this.donjiPritisak = sqdto.getDonjiPritisak();
		this.trombinskoVreme = sqdto.getTrombinskoVreme();
		this.odbijen = sqdto.isOdbijen();
		this.razlogOdbijanja = sqdto.getRazlogOdbijanja();
		this.tipKese = sqdto.getTipKese();
		this.brojLotaKese = sqdto.getBrojLotaKese();
		this.mestoPunkcije = sqdto.getMestoPunkcije();
		this.pocetakDavanja = sqdto.getPocetakDavanja();
		this.zavrsetakDavanja = sqdto.getZavrsetakDavanja();
		this.kolicinaUzeteKrvi = sqdto.getKolicinaUzeteKrvi();
		this.razlogPrekida = sqdto.getRazlogPrekida();
	}

	public Integer getId() {
		return id;
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

}
