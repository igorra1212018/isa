package com.isa.donorapp.dto;

import com.isa.donorapp.model.DonationCenter;

public class DonationCenterDTO {
	Integer id;
	String name;
	String city;
	String country;
	String address;
	String description;
	
	double latitude;
	double longitude;
	double rating;
	
	public DonationCenterDTO() {}

	public DonationCenterDTO(Integer id, String name, String city, String country, String address, String description,
			double latitude, double longitude, double rating) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.country = country;
		this.address = address;
		this.description = description;
		this.latitude = latitude;
		this.longitude = longitude;
		this.rating = rating;
	}
	
	public DonationCenterDTO(DonationCenter donationCenter) {
		this.id = donationCenter.getId();
		this.name = donationCenter.getName();
		this.city = donationCenter.getAddress().getCity();
		this.country = donationCenter.getAddress().getCountry();
		this.address = donationCenter.getAddress().getAddress();
		this.description = donationCenter.getDescription();
		this.latitude = donationCenter.getAddress().getLatitude();
		this.longitude = donationCenter.getAddress().getLongtitude();
		this.rating = donationCenter.getRating();
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
}