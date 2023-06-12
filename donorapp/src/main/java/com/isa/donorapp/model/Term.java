package com.isa.donorapp.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Term {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	@ManyToOne
	private DonationCenter center;
	
	private LocalDateTime date;
	private int duration;
	private boolean deleted = false;
	
	@Transient
	private User reservedBy;
	
	public Term() {}
	
	public Term(LocalDateTime date, int duration) {
		this.date = date;
		this.duration = duration;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getReservedBy() {
		return reservedBy;
	}
	public void setReservedBy(User reservedBy) {
		this.reservedBy = reservedBy;
	}
	public DonationCenter getCenter() {
		return center;
	}
	public void setCenter(DonationCenter center) {
		this.center = center;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
