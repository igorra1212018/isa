package com.isa.donorapp.dto;

public class StaffComplaintCreateDTO {
	private Integer staffId;
	private String text;
	
	public StaffComplaintCreateDTO() {}
	
	public StaffComplaintCreateDTO(Integer staffId, String text) {
		this.staffId = staffId;
		this.text = text;
	}
	
	public Integer getStaffId() {
		return staffId;
	}
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
