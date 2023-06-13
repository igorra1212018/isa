package com.isa.donorapp.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import com.isa.donorapp.dto.DonationCenterDTO;

@Entity
public class DonationCenter {
	@Id
	@SequenceGenerator(name = "center_sequence_generator", sequenceName = "center_sequence", initialValue = 100)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="center_sequence_generator")
	protected Integer id;
	
	String name;
	@Embedded
	Location address;
	String description;
	private double blood_A;
	private double blood_B;
	private double blood_AB;
	private double blood_O;
	
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

	public double getBlood_A() {
		return blood_A;
	}

	public void setBlood_A(double blood_A) {
		this.blood_A = blood_A;
	}

	public double getBlood_B() {
		return blood_B;
	}

	public void setBlood_B(double blood_B) {
		this.blood_B = blood_B;
	}

	public double getBlood_AB() {
		return blood_AB;
	}

	public void setBlood_AB(double blood_AB) {
		this.blood_AB = blood_AB;
	}

	public double getBlood_O() {
		return blood_O;
	}

	public void setBlood_O(double blood_O) {
		this.blood_O = blood_O;
	}

}
