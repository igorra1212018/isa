package com.isa.donorapp.dto;

import com.isa.donorapp.model.User;

public class UserHomepageDTO {
	private String email;
	private String firstName;
	private String lastName;
	private int penaltyCount;
	private int loyaltyPoints;
	
	public UserHomepageDTO() {}
	
	public UserHomepageDTO(String email, String firstName, String lastName, int penaltyCount) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.penaltyCount = penaltyCount;
	}
	
	public UserHomepageDTO(User user) {
		this.email = user.getEmail();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.penaltyCount = user.getPenaltyCount();
		this.loyaltyPoints = user.getLoyaltyPoints();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getPenaltyCount() {
		return penaltyCount;
	}

	public void setPenaltyCount(int penaltyCount) {
		this.penaltyCount = penaltyCount;
	}

	public int getLoyaltyPoints() {
		return loyaltyPoints;
	}

	public void setLoyaltyPoints(int loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}
}
