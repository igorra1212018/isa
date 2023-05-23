package com.isa.donorapp.dto;

import java.time.LocalDateTime;

import org.springframework.util.Base64Utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.isa.donorapp.model.Reservation;

public class ReservationQRDTO {
	Integer id;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime creationDate;
	private String status;
	private String qrCode;
	public ReservationQRDTO() {}
	
	public ReservationQRDTO(Integer id, LocalDateTime creationDate, String status, String qrCode) {
		this.id = id;
		this.creationDate = creationDate;
		this.status = status;
		this.qrCode = qrCode;
	}
	
	public ReservationQRDTO(Reservation reservation) {
		this.id = reservation.getId();
		this.creationDate = reservation.getCreationDate();
		this.status = reservation.getStatus().toString();
		this.qrCode = Base64Utils.encodeToString(reservation.getQrCode());
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getQrCode() {
		return qrCode;
	}
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}
}
