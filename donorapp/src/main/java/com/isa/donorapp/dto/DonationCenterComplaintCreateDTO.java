package com.isa.donorapp.dto;

import com.isa.donorapp.model.DonationCenterComplaint;

public class DonationCenterComplaintCreateDTO {
	private Integer centerId;
	private String text;
	
	public DonationCenterComplaintCreateDTO() {}
	
	public DonationCenterComplaintCreateDTO(Integer centerId, String text) {
		this.centerId = centerId;
		this.text = text;
	}
	
	public DonationCenterComplaintCreateDTO(DonationCenterComplaint complaint) {
		this.centerId = complaint.getCenter().getId();
		this.text = complaint.getText();
	}
	
	public Integer getCenterId() {
		return centerId;
	}
	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
