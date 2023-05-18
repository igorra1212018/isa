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
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "term_staff", 
				joinColumns = @JoinColumn(name = "term_id", referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name = "staff_id", referencedColumnName = "id"))
	private Set<User> staff = new HashSet<>();
	
	@ManyToOne
	private DonationCenter center;
	
	private LocalDateTime date;
	private int duration;
	
	@Transient
	private User reservedBy;
	
	public Term() {}
	
	public Term(Set<User> staff, LocalDateTime date, int duration) {
		this.staff = staff;
		this.date = date;
		this.duration = duration;
	}
	
	public Set<User> getStaff() {
		return staff;
	}
	public void setStaff(Set<User> staff) {
		this.staff = staff;
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
}
