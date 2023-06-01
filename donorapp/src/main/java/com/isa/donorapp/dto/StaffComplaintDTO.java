package com.isa.donorapp.dto;

import com.isa.donorapp.model.StaffComplaint;

public class StaffComplaintDTO {
	private Integer id;
	private Integer staffId;
	private String staffFirstName;
	private String staffLastName;
	private Integer userId;
	private String userFirstName;
	private String userLastName;
	private String text;
	private String reply;
	
	public StaffComplaintDTO() {}
	
	public StaffComplaintDTO(Integer id, Integer staffId, String staffFirstName, String staffLastName, Integer userId,
			String userFirstName, String userLastName, String text, String reply) {
		this.id = id;
		this.staffId = staffId;
		this.staffFirstName = staffFirstName;
		this.staffLastName = staffLastName;
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.text = text;
		this.reply = reply;
	}
	
	public StaffComplaintDTO(StaffComplaint complaint) {
		this.id = complaint.getId();
		this.staffId = complaint.getStaff().getId();
		this.staffFirstName = complaint.getStaff().getFirstName();
		this.staffLastName = complaint.getStaff().getLastName();
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

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public String getStaffFirstName() {
		return staffFirstName;
	}

	public void setStaffFirstName(String staffFirstName) {
		this.staffFirstName = staffFirstName;
	}

	public String getStaffLastName() {
		return staffLastName;
	}

	public void setStaffLastName(String staffLastName) {
		this.staffLastName = staffLastName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}
}
