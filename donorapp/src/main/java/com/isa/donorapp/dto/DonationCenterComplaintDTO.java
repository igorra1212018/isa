package com.isa.donorapp.dto;

import com.isa.donorapp.model.DonationCenterComplaint;

public class DonationCenterComplaintDTO {
	private Integer id;
	private Integer centerId;
	private String centerName;
	private Integer userId;
	private String userFirstName;
	private String userLastName;
	private String text;
	private String reply;
	
	public DonationCenterComplaintDTO() {}
	
	public DonationCenterComplaintDTO(Integer id, Integer centerId, String centerName, Integer userId, String userFirstName,
			String userLastName, String text, String reply) {
		this.id = id;
		this.centerId = centerId;
		this.centerName = centerName;
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.text = text;
		this.reply = reply;
	}
	
	public DonationCenterComplaintDTO(DonationCenterComplaint complaint) {
		this.id = complaint.getId();
		this.centerId = complaint.getCenter().getId();
		this.centerName = complaint.getCenter().getName();
		this.userId = complaint.getUser().getId();
		this.userFirstName = complaint.getUser().getFirstName();
		this.userLastName = complaint.getUser().getLastName();
		this.text = complaint.getText();
		this.reply = complaint.getReply();
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
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
}
