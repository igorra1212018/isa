package com.isa.donorapp.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TermAddDTO {
	private String date;
	private int duration;
	private int centerId;
	
	public TermAddDTO( ) {
		
	}
	
	public TermAddDTO(String date, int duration, int centerId) {
		this.date = date;
		this.duration = duration;
		this.centerId = centerId;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getCenterId() {
		return centerId;
	}
	public void setCenterId(int centerId) {
		this.centerId = centerId;
	}
	
	
}
