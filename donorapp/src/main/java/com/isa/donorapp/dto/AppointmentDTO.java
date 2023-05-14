package com.isa.donorapp.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.isa.donorapp.model.Term;

public class AppointmentDTO {
	private Integer id;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime date;
	private int duration;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime reservationDate;
	private DonationCenterDTO center;
	
	public AppointmentDTO() {}

	public AppointmentDTO(Integer id, LocalDateTime date, int duration, LocalDateTime reservationDate,
			DonationCenterDTO center) {
		this.id = id;
		this.date = date;
		this.duration = duration;
		this.reservationDate = reservationDate;
		this.center = center;
	}
	
	public AppointmentDTO(Term term) {
		this.id = term.getId();
		this.date = term.getDate();
		this.duration = term.getDuration();
		this.reservationDate = term.getReservationDate();
		this.center = new DonationCenterDTO(term.getCenter());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public LocalDateTime getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(LocalDateTime reservationDate) {
		this.reservationDate = reservationDate;
	}

	public DonationCenterDTO getCenter() {
		return center;
	}

	public void setCenter(DonationCenterDTO center) {
		this.center = center;
	}
	
	
}
