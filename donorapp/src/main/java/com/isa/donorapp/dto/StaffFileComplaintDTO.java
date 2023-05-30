package com.isa.donorapp.dto;

import com.isa.donorapp.model.User;

public class StaffFileComplaintDTO {
	private Integer id;
	private String firstName;
	private String lastName;
	
	public StaffFileComplaintDTO() {}
	
	public StaffFileComplaintDTO(Integer id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public StaffFileComplaintDTO(User staff) {
		this.id = staff.getId();
		this.firstName = staff.getFirstName();
		this.lastName = staff.getLastName();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
