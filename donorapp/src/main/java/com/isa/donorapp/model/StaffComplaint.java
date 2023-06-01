package com.isa.donorapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.isa.donorapp.dto.StaffComplaintCreateDTO;

@Entity
public class StaffComplaint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	@ManyToOne
	private User staff;
	
	@ManyToOne
	private User user;
	
	private String text;

	public StaffComplaint() {}

	public StaffComplaint(Integer id, User staff, User user, String text) {
		this.id = id;
		this.staff = staff;
		this.user = user;
		this.text = text;
	}
	
	public StaffComplaint(StaffComplaintCreateDTO complaintDTO, User staff, User user) {
		this.staff = staff;
		this.user = user;
		this.text = complaintDTO.getText();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getStaff() {
		return staff;
	}

	public void setStaff(User staff) {
		this.staff = staff;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
