package com.isa.donorapp.dto;

import com.isa.donorapp.model.DonationCenterComplaint;

public class DonationCenterComplaintDTO {
	private Integer id;
	private Integer centerId;
	private Integer userId; //Mozda izbaciti usera i preimenovati DTO?
	private String text;
	
	public DonationCenterComplaintDTO() {}
	
	public DonationCenterComplaintDTO(Integer id, Integer centerId, Integer userId, String text) {
		this.id = id;
		this.centerId = centerId;
		this.userId = userId;
		this.text = text;
	}
	
	public DonationCenterComplaintDTO(DonationCenterComplaint complaint) {
		this.id = complaint.getId();
		this.centerId = complaint.getCenter().getId();
		this.userId = complaint.getUser().getId();
		this.text = complaint.getText();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCenterId() {
		return centerId;
	}
	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
