package com.isa.donorapp.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.isa.donorapp.model.enums.EReservationStatus;

@Entity
public class Reservation {
	@Id
	@SequenceGenerator(name = "reservation_sequence_generator", sequenceName = "reservation_sequence", initialValue = 100)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="reservation_sequence_generator")
	protected Integer id;
	
	@ManyToOne
	private User user;
	@ManyToOne
	private Term term;
	
	private LocalDateTime creationDate;
	
	private boolean canceled;
	private EReservationStatus status;
	
	private byte[] qrCode;
	
	public Reservation() {}
	
	public Reservation(User user, Term term, LocalDateTime creationDate, boolean canceled, EReservationStatus status) {
		this.user = user;
		this.term = term;
		this.creationDate = creationDate;
		this.canceled = canceled;
		this.status = status;
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
	public Term getTerm() {
		return term;
	}
	public void setTerm(Term term) {
		this.term = term;
	}
	public boolean isCanceled() {
		return canceled;
	}
	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}
	public byte[] getQrCode() {
		return qrCode;
	}
	public void setQrCode(byte[] qrCode) {
		this.qrCode = qrCode;
	}
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	public EReservationStatus getStatus() {
		return status;
	}
	public void setStatus(EReservationStatus status) {
		this.status = status;
	}
}
