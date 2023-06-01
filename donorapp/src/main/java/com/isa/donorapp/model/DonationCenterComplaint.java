package com.isa.donorapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.isa.donorapp.dto.DonationCenterComplaintCreateDTO;
import com.isa.donorapp.dto.DonationCenterComplaintDTO;
@Entity
public class DonationCenterComplaint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	@ManyToOne
	private DonationCenter center;
	
	@ManyToOne
	private User user;
	
	@Size(max = 4000)
	private String text;
	@Size(max = 4000)
	private String reply;
	
	public DonationCenterComplaint() {}
	
	public DonationCenterComplaint(Integer id, DonationCenter center, User user, String text, String reply) {
		this.id = id;
		this.center = center;
		this.user = user;
		this.text = text;
		this.reply = reply;
	}
	
	public DonationCenterComplaint(DonationCenterComplaintDTO complaintDTO, DonationCenter center, User user) {
		this.id = complaintDTO.getId();
		this.center = center;
		this.user = user;
		this.text = complaintDTO.getText();
	}
	
	public DonationCenterComplaint(DonationCenterComplaintCreateDTO complaintDTO, DonationCenter center, User user) {
		this.center = center;
		this.user = user;
		this.text = complaintDTO.getText();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public DonationCenter getCenter() {
		return center;
	}
	public void setCenter(DonationCenter center) {
		this.center = center;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
}
