package com.isa.donorapp.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.isa.donorapp.model.Term;
import com.isa.donorapp.model.User;

public class ProcessesReservationDTO {
	private Integer id;
	private User user;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime date;
	private int duration;
		
	public ProcessesReservationDTO() {}	

	public ProcessesReservationDTO(User u, Term t) {
		super();
		this.id = t.getId();
		this.user = u;;
		this.date = t.getDate();
		this.duration = t.getDuration();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
}
