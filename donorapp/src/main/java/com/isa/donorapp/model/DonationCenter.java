package com.isa.donorapp.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.isa.donorapp.dto.DonationCenterDTO;

@Entity
public class DonationCenter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	String name;
	@Embedded
	Location address;
	String description;
	
	@Transient
	double rating;
	
	public DonationCenter() {}

	public DonationCenter(String name, Location address, String description, double rating) {
		this.name = name;
		this.address = address;
		this.description = description;
		this.rating = rating;
	}
	
	public DonationCenter(DonationCenterDTO donationCenterDTO) {
		this.name = donationCenterDTO.getName();		
		this.address = new Location(donationCenterDTO.getAddress(), donationCenterDTO.getCity(), donationCenterDTO.getCountry(), donationCenterDTO.getLatitude(), donationCenterDTO.getLongitude());;
		this.description = donationCenterDTO.getDescription();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getAddress() {
		return address;
	}

	public void setAddress(Location address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
}
